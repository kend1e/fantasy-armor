package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.config.FAConfigs;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public final class FAArmorItems {
    public static final ArrayList<ArmorType> VALID_ARMOR_TYPES = new ArrayList<>(List.of(
            ArmorType.HELMET,
            ArmorType.CHESTPLATE,
            ArmorType.LEGGINGS,
            ArmorType.BOOTS
    ));

    // ArmorSet -> (ArmorType -> Item)
    public static final Map<FAArmorSet, Map<ArmorType, Item>> ARMOR_ITEMS = new HashMap<>();

    private FAArmorItems() {
    }

    public static void init() {
        for (FAArmorSet set : FAArmorSet.values()) {
            Map<ArmorType, Item> setPieces = new EnumMap<>(ArmorType.class);

            for (ArmorType type : VALID_ARMOR_TYPES) {
                String name = set.getName() + "_" + type.getName();

                Identifier id = Identifier.fromNamespaceAndPath(FantasyArmor.MOD_ID, name);
                ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

                Item.Properties props = new Item.Properties().setId(key);

                Supplier<FAArmorAttributes> attributesSupplier = FAConfigs.armorSupplier(set, type.getName());
                FAArmorItem item = new FAArmorItem(set, type, attributesSupplier, props);

                Item registered = Registry.register(BuiltInRegistries.ITEM, key, item);

                FAItems.ITEMS.add(registered);
                setPieces.put(type, registered);
            }

            ARMOR_ITEMS.put(set, setPieces);
        }
    }

    public static Item getArmorItem(FAArmorSet set, ArmorType type) {
        Map<ArmorType, Item> pieces = ARMOR_ITEMS.get(set);
        if (pieces == null) {
            throw new IllegalStateException("Armor set not registered: " + set.getName());
        }

        Item item = pieces.get(type);
        if (item == null) {
            throw new IllegalStateException("Armor piece not registered: " + set.getName() + " / " + type.getName());
        }

        return item;
    }
}