package net.kenddie.fantasyarmor.test;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.UnmodifiableConfig;
import net.kenddie.fantasyarmor.config.FAConfig;
import net.kenddie.fantasyarmor.config.FAArmorConfig;
import net.kenddie.fantasyarmor.config.FAArmorEffectsConfig;
import net.minecraftforge.common.ForgeConfigSpec;

final class ConfigAccess {
    static boolean modifiers() { return FAConfig.applyModifiers(); }
    static void modifiers(boolean value) { FAConfig.APPLY_MODIFIERS.set(value); }
    static boolean durability() { return FAConfig.enableDurability(); }
    static void durability(boolean value) { FAConfig.ENABLE_DURABILITY.set(value); }
    static boolean effects() { return FAConfig.applyArmorEffects(); }
    static void effects(boolean value) { FAConfig.APPLY_ARMOR_EFFECTS.set(value); }
    static double helmetArmor() { return FAArmorConfig.ARMOR_CONFIGS.get("eclipse_soldier").get("helmet").armor.get(); }
    static void helmetArmor(double value) { FAArmorConfig.ARMOR_CONFIGS.get("eclipse_soldier").get("helmet").armor.set(value); }
    static boolean loaded() { return FAConfig.SPEC.isLoaded() && FAArmorConfig.SPEC.isLoaded() && FAArmorEffectsConfig.SPEC.isLoaded(); }

    static void withSettings(Runnable scenario) {
        var bindings = ConfigRegistry.serverConfigs().stream()
                .filter(config -> config.getSpec() == FAConfig.SPEC || config.getSpec() == FAArmorConfig.SPEC)
                .map(config -> new Binding((ForgeConfigSpec) config.getSpec(), config.getConfigData()))
                .toList();
        if (bindings.size() != 2) throw new IllegalStateException("Expected both registered armor config specs");
        try {
            for (var binding : bindings) {
                var memory = CommentedConfig.inMemory();
                copyValues(binding.spec().getValues(), memory);
                binding.spec().correct(memory);
                // File-backed setters autosave and race with Forge's watcher thread.
                binding.spec().setConfig(memory);
            }
            scenario.run();
        } finally {
            for (var binding : bindings) binding.spec().setConfig(binding.original());
        }
    }

    private static void copyValues(UnmodifiableConfig values, CommentedConfig destination) {
        for (Object value : values.valueMap().values()) {
            if (value instanceof ForgeConfigSpec.ConfigValue<?> setting) destination.set(setting.getPath(), setting.get());
            else if (value instanceof UnmodifiableConfig section) copyValues(section, destination);
        }
    }

    private record Binding(ForgeConfigSpec spec, CommentedConfig original) {}
    private ConfigAccess() {}
}
