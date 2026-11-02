package net.kenddie.fantasyarmor.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FAConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue APPLY_ARMOR_EFFECTS;
    public static final ForgeConfigSpec.BooleanValue APPLY_MODIFIERS;
    public static final ForgeConfigSpec.BooleanValue SHOW_PARTICLES;
    public static final ForgeConfigSpec.IntValue EFFECTS_INTERVAL;
    public static final ForgeConfigSpec.BooleanValue SHOW_EFFECT_ICON;
    public static final ForgeConfigSpec.BooleanValue ENABLE_DURABILITY;

    static {
        BUILDER.push("General Settings");

        APPLY_ARMOR_EFFECTS = BUILDER.worldRestart()
                .comment("Apply armor effects")
                .define("applyArmorEffects", true);

        APPLY_MODIFIERS = BUILDER.worldRestart()
                .comment("Apply attribute modifiers")
                .define("applyModifiers", true);

        SHOW_PARTICLES = BUILDER.worldRestart()
                .comment("Show effect particles")
                .define("showParticles", false);

        EFFECTS_INTERVAL = BUILDER.worldRestart()
                .comment("The minimum duration of the existing effect, after which it will be given again")
                .defineInRange("effectsInterval", 241, 1, Integer.MAX_VALUE);

        SHOW_EFFECT_ICON = BUILDER.worldRestart()
                .comment("Show effect icon or not")
                .define("showEffectIcon", true);

        ENABLE_DURABILITY = BUILDER.worldRestart()
                .comment("Enable durability on Fantasy Armor pieces. When false, armor is indestructible. Requires world restart.")
                .define("enableDurability", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    @SuppressWarnings("unchecked")
    private static <T> T value(ForgeConfigSpec.ConfigValue<T> setting) {
        return SPEC.isLoaded() ? setting.get() : (T) SPEC.getSpec().<ForgeConfigSpec.ValueSpec>get(setting.getPath()).getDefault();
    }

    public static boolean applyArmorEffects() { return value(APPLY_ARMOR_EFFECTS); }
    public static boolean applyModifiers() { return value(APPLY_MODIFIERS); }
    public static boolean showParticles() { return value(SHOW_PARTICLES); }
    public static boolean showEffectIcon() { return value(SHOW_EFFECT_ICON); }
    public static boolean enableDurability() { return value(ENABLE_DURABILITY); }
    public static int effectsInterval() { return value(EFFECTS_INTERVAL); }
}
