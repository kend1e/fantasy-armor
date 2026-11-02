package net.kenddie.fantasyarmor.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.kenddie.fantasyarmor.config.FAArmorAttributesConfig;
import net.kenddie.fantasyarmor.config.FAArmorConfig;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class FAArmorItems {
    public static final Map<FAArmorSet, Map<EquipmentSlotType, RegistryObject<Item>>> ARMOR_ITEMS = new HashMap<>();

    public static void register(IEventBus eventBus) {
        for (FAArmorSet set : FAArmorSet.values()) {
            Map<EquipmentSlotType, RegistryObject<Item>> setPieces = new HashMap<>();

            for (EquipmentSlotType type : new EquipmentSlotType[]{EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET}) {
                String name = set.getName() + "_" + net.kenddie.fantasyarmor.item.ArmorPieces.name(type);

                FAArmorAttributesConfig config = FAArmorConfig.ARMOR_CONFIGS.get(set.getName()).get(net.kenddie.fantasyarmor.item.ArmorPieces.name(type));

                Supplier<FAArmorAttributes> attributesSupplier = config::read;

                RegistryObject<Item> item = FAItems.ITEMS.register(name, () -> new FAArmorItem(set, type, attributesSupplier));
                setPieces.put(type, item);
            }

            ARMOR_ITEMS.put(set, setPieces);
        }
    }

    public static RegistryObject<Item> getArmorItem(FAArmorSet set, EquipmentSlotType type) {
        return ARMOR_ITEMS.get(set).get(type);
    }

    private FAArmorItems() {}
}
