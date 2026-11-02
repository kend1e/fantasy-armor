package net.kenddie.fantasyarmor.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.kenddie.fantasyarmor.config.FAArmorAttributesConfig;
import net.kenddie.fantasyarmor.config.FAArmorConfig;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class FAArmorItems {
    public static final Map<FAArmorSet, Map<EquipmentSlot, RegistryObject<Item>>> ARMOR_ITEMS = new HashMap<>();

    public static void register(IEventBus eventBus) {
        for (FAArmorSet set : FAArmorSet.values()) {
            Map<EquipmentSlot, RegistryObject<Item>> setPieces = new HashMap<>();

            for (EquipmentSlot type : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
                String name = set.getName() + "_" + net.kenddie.fantasyarmor.item.ArmorPieces.name(type);

                FAArmorAttributesConfig config = FAArmorConfig.ARMOR_CONFIGS.get(set.getName()).get(net.kenddie.fantasyarmor.item.ArmorPieces.name(type));

                Supplier<FAArmorAttributes> attributesSupplier = config::read;

                RegistryObject<Item> item = FAItems.ITEMS.register(name, () -> new FAArmorItem(set, type, attributesSupplier));
                setPieces.put(type, item);
            }

            ARMOR_ITEMS.put(set, setPieces);
        }
    }

    public static RegistryObject<Item> getArmorItem(FAArmorSet set, EquipmentSlot type) {
        return ARMOR_ITEMS.get(set).get(type);
    }

    private FAArmorItems() {}
}
