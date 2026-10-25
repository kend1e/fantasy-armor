package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public final class FAArmorItems {
    public static final List<ArmorType> VALID_ARMOR_TYPES = List.of(
            ArmorType.HELMET,
            ArmorType.CHESTPLATE,
            ArmorType.LEGGINGS,
            ArmorType.BOOTS
    );
    // Set definition -> (ArmorPiece -> DeferredItem<Item> )
    public static final Map<FAArmorSet, Map<ArmorType, DeferredItem<Item>>> ARMOR_ITEMS = new HashMap<>();

    public static void register(IEventBus eventBus) {
        for (FAArmorSet set : FAArmorSet.values()) {
            Map<ArmorType, DeferredItem<Item>> setPieces = new HashMap<>();

            for (ArmorType type : VALID_ARMOR_TYPES) {
                String name = set.getName() + "_" + type.getName();

                Supplier<FAArmorAttributes> attributesSupplier = () -> set.defaults().get(type.getName());
                DeferredItem<Item> item = FAItems.ITEMS.registerItem(name,
                        properties -> new FAArmorItem(set, type, attributesSupplier, properties));
                setPieces.put(type, item);
            }

            ARMOR_ITEMS.put(set, setPieces);
        }
    }

    public static DeferredItem<Item> getArmorItem(FAArmorSet set, ArmorType type) {
        return ARMOR_ITEMS.get(set).get(type);
    }

    private FAArmorItems() {}
}
