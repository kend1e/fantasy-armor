package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.config.FAArmorAttributesConfig;
import net.kenddie.fantasyarmor.config.FAArmorConfig;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
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
    // Set definition -> (ArmorPiece -> RegistryObject<Item> )
    public static final Map<FAArmorSet, Map<ArmorType, RegistryObject<Item>>> ARMOR_ITEMS = new HashMap<>();

    public static void register(BusGroup eventBus) {
        for (FAArmorSet set : FAArmorSet.values()) {
            Map<ArmorType, RegistryObject<Item>> setPieces = new HashMap<>();

            for (ArmorType type : VALID_ARMOR_TYPES) {
                String name = set.getName() + "_" + type.getName();

                FAArmorAttributesConfig config = FAArmorConfig.ARMOR_CONFIGS.get(set.getName()).get(type.getName());

                Supplier<FAArmorAttributes> attributesSupplier = () -> config.defaults;
                var key = net.minecraft.resources.ResourceKey.create(
                        net.minecraft.core.registries.Registries.ITEM,
                        net.minecraft.resources.Identifier.fromNamespaceAndPath(
                                net.kenddie.fantasyarmor.FantasyArmor.MOD_ID, name));
                RegistryObject<Item> item = FAItems.ITEMS.register(name,
                        () -> new FAArmorItem(set, type, attributesSupplier, new Item.Properties().setId(key)));
                setPieces.put(type, item);
            }

            ARMOR_ITEMS.put(set, setPieces);
        }
    }

    public static RegistryObject<Item> getArmorItem(FAArmorSet set, ArmorType type) {
        return ARMOR_ITEMS.get(set).get(type);
    }

    private FAArmorItems() {}
}
