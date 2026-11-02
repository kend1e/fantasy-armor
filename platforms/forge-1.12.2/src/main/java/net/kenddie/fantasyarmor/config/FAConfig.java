package net.kenddie.fantasyarmor.config;

import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.kenddie.fantasyarmor.shared.config.ArmorAttributeLimits.Range;
import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import net.minecraftforge.common.config.Configuration;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static net.kenddie.fantasyarmor.shared.config.ArmorAttributeLimits.*;

public final class FAConfig {
    private static Settings local;
    private static volatile Settings active;
    public static boolean showDescriptions = true;
    public static boolean showCapes = true;

    public static final class Settings {
        boolean modifiers = true;
        boolean effects = true;
        boolean durability;
        boolean particles;
        int threshold = 241;
        Map<String, Map<String, FAArmorAttributes>> attributes = new LinkedHashMap<>();
        Map<String, List<EffectEntry>> setEffects = new LinkedHashMap<>();
    }

    public static void load(File file) {
        Configuration config = new Configuration(file);
        Settings settings = new Settings();
        settings.modifiers = config.getBoolean("applyModifiers", "general", true, "Apply attribute bonuses.");
        settings.effects = config.getBoolean("applyArmorEffects", "general", true, "Apply complete-set effects.");
        settings.durability = config.getBoolean("enableDurability", "general", false, "Enable armor durability.");
        settings.particles = config.getBoolean("showParticles", "general", false, "Show effect particles.");
        settings.threshold = config.getInt("effectsInterval", "general", 241, 1, Integer.MAX_VALUE, "Refresh effects below this remaining duration.");
        showDescriptions = config.getBoolean("showDescriptions", "client", true, "Show armor descriptions.");
        showCapes = config.getBoolean("showCapes", "client", true, "Show armor capes.");
        for (FAArmorSet set : FAArmorSet.values()) {
            Map<String, FAArmorAttributes> pieces = new LinkedHashMap<>();
            set.defaults().forEach((piece, defaults) -> {
                String category = "attributes." + set.getName() + "." + piece;
                pieces.put(piece, new FAArmorAttributes(
                        attribute(config, category, "armor", defaults.armor(), ARMOR),
                        attribute(config, category, "armorToughness", defaults.armorToughness(), ARMOR_TOUGHNESS),
                        attribute(config, category, "knockbackResistance", defaults.knockbackResistance(), KNOCKBACK_RESISTANCE),
                        attribute(config, category, "movementSpeed", defaults.movementSpeed(), MOVEMENT_SPEED),
                        attribute(config, category, "maxHealth", defaults.maxHealth(), MAX_HEALTH),
                        attribute(config, category, "attackDamage", defaults.attackDamage(), ATTACK_DAMAGE),
                        attribute(config, category, "attackSpeed", defaults.attackSpeed(), ATTACK_SPEED),
                        attribute(config, category, "luck", defaults.luck(), LUCK),
                        attribute(config, category, "durability", defaults.durability(), DURABILITY)));
            });
            settings.attributes.put(set.getName(), pieces);
            String[] defaults = set.effects().stream().map(EffectEntry::toConfigValue).toArray(String[]::new);
            String[] values = config.getStringList("effects", "effects." + set.getName(), defaults, "Effect id,duration,amplifier.");
            List<EffectEntry> effects = new ArrayList<>();
            for (String value : values) EffectEntry.parse(value).ifPresent(effects::add);
            settings.setEffects.put(set.getName(), effects);
        }
        if (config.hasChanged()) config.save();
        local = settings;
        active = settings;
    }

    private static double attribute(Configuration config, String category, String key, double fallback, Range range) {
        net.minecraftforge.common.config.Property property = config.get(category, key, fallback, "", range.min(), range.max());
        double value = range.orDefault(property.getDouble(), fallback);
        property.set(value);
        return value;
    }

    static Settings localSettings() { return local; }
    static void applyServerSettings(Settings settings) { active = settings; }
    static void restoreLocalSettings() { active = local; }
    public static FAArmorAttributes attributes(FAArmorSet set, String piece) {
        return active == null ? set.defaults().get(piece) : active.attributes.get(set.getName()).get(piece);
    }
    public static List<EffectEntry> effects(FAArmorSet set) { return active == null ? set.effects() : active.setEffects.get(set.getName()); }
    public static boolean modifiers() { return active == null || active.modifiers; }
    public static boolean durability() { return active != null && active.durability; }
    public static boolean effects() { return active == null || active.effects; }
    public static boolean particles() { return active != null && active.particles; }
    public static int threshold() { return active == null ? 241 : active.threshold; }
    private FAConfig() {}
}
