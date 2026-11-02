package net.kenddie.fantasyarmor.shared.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class FAArmorDefaults {

    private static final String RESOURCE_PATH = "/armor_defaults.json";
    private static Map<String, Map<String, FAArmorAttributes>> cache;

    private FAArmorDefaults() {}

    public static Map<String, Map<String, FAArmorAttributes>> load() {
        if (cache != null) return cache;

        InputStream is = FAArmorDefaults.class.getResourceAsStream(RESOURCE_PATH);
        if (is == null) {
            throw new IllegalStateException("Missing resource: " + RESOURCE_PATH);
        }

        Type type = new TypeToken<Map<String, Map<String, RawPiece>>>() {}.getType();
        Map<String, Map<String, RawPiece>> raw = new Gson().fromJson(
                new InputStreamReader(is, StandardCharsets.UTF_8), type);

        Map<String, Map<String, FAArmorAttributes>> result = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, RawPiece>> setEntry : raw.entrySet()) {
            Map<String, FAArmorAttributes> pieces = new LinkedHashMap<>();
            for (Map.Entry<String, RawPiece> pieceEntry : setEntry.getValue().entrySet()) {
                pieces.put(pieceEntry.getKey(), pieceEntry.getValue().toAttributes());
            }
            result.put(setEntry.getKey(), Collections.unmodifiableMap(pieces));
        }

        cache = Collections.unmodifiableMap(result);
        return cache;
    }

    public static FAArmorAttributes get(String setName, String pieceName) {
        Map<String, Map<String, FAArmorAttributes>> all = load();
        Map<String, FAArmorAttributes> set = all.get(setName);
        if (set == null) return fallback(pieceName);
        FAArmorAttributes attrs = set.get(pieceName);
        return attrs != null ? attrs : fallback(pieceName);
    }

    public static FAArmorAttributes fallback(String pieceName) {
        switch (pieceName) {
            case "helmet": return FAArmorAttributes.builder().armor(3).armorToughness(2).knockbackResistance(0.1).durability(440.0).build();
            case "chestplate": return FAArmorAttributes.builder().armor(8).armorToughness(2).knockbackResistance(0.1).durability(620.0).build();
            case "leggings": return FAArmorAttributes.builder().armor(6).armorToughness(2).knockbackResistance(0.1).durability(580.0).build();
            case "boots": return FAArmorAttributes.builder().armor(3).armorToughness(2).knockbackResistance(0.1).durability(500.0).build();
            default: return FAArmorAttributes.builder().build();
        }
    }

    private static class RawPiece {
        double armor;
        double armorToughness;
        double knockbackResistance;
        double movementSpeed;
        double maxHealth;
        double attackDamage;
        double attackSpeed;
        double luck;
        double durability;

        FAArmorAttributes toAttributes() {
            return new FAArmorAttributes(
                    armor, armorToughness, knockbackResistance,
                    movementSpeed, maxHealth, attackDamage,
                    attackSpeed, luck, durability
            );
        }
    }
}
