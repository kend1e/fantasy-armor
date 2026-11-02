package net.kenddie.fantasyarmor.shared.armor;

import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import net.kenddie.fantasyarmor.shared.config.FAArmorDefaults;
import net.kenddie.fantasyarmor.shared.config.FAEffectDefaults;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Immutable content identity, independent of Minecraft registries and game configuration. */
public final class FAArmorSet {
    private final String id;
    private final Map<String, FAArmorAttributes> defaults;
    private final List<EffectEntry> effects;

    private FAArmorSet(String id, Map<String, FAArmorAttributes> defaults, List<EffectEntry> effects) {
        this.id = id;
        this.defaults = Collections.unmodifiableMap(new LinkedHashMap<>(defaults));
        this.effects = Collections.unmodifiableList(new java.util.ArrayList<>(effects));
    }

    private static final class Catalog {
        private static final Map<String, FAArmorSet> BY_ID = load();
        private static final List<FAArmorSet> VALUES = Collections.unmodifiableList(new java.util.ArrayList<>(BY_ID.values()));

        private static Map<String, FAArmorSet> load() {
            Map<String, Map<String, FAArmorAttributes>> attributes = FAArmorDefaults.load();
            Map<String, List<EffectEntry>> effects = FAEffectDefaults.load();
            if (!attributes.keySet().equals(effects.keySet())) {
                throw new IllegalStateException("Armor and effect definitions contain different set IDs");
            }
            Map<String, FAArmorSet> sets = new LinkedHashMap<>();
            attributes.forEach((id, pieces) -> {
                if (!id.matches("[a-z0-9_]+") || !pieces.keySet().equals(new java.util.HashSet<>(java.util.Arrays.asList("helmet", "chestplate", "leggings", "boots")))) {
                    throw new IllegalStateException("Invalid armor definition: " + id);
                }
                sets.put(id, new FAArmorSet(id, pieces, effects.get(id)));
            });
            return Collections.unmodifiableMap(sets);
        }
    }

    public static List<FAArmorSet> values() { return Catalog.VALUES; }

    public static FAArmorSet require(String id) {
        FAArmorSet result = Catalog.BY_ID.get(id);
        if (result == null) throw new IllegalArgumentException("Unknown armor set: " + id);
        return result;
    }

    public String getName() { return id; }
    public Map<String, FAArmorAttributes> defaults() { return defaults; }
    public List<EffectEntry> effects() { return effects; }
    public String getGeoPath() { return id + "_armor"; }
    public String getTexturePath() { return "textures/armor/" + id + "_armor.png"; }
    public String getOverlayPath() { return "textures/armor/" + id + "_armor_overlay.png"; }

    @Override public boolean equals(Object other) {
        return other instanceof FAArmorSet && id.equals(((FAArmorSet) other).id);
    }
    @Override public int hashCode() { return id.hashCode(); }
    @Override public String toString() { return id; }
}
