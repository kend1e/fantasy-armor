package net.kenddie.fantasyarmor.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.config.FAConfigs;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.core.cauldron.CauldronInteraction;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class FAArmorItems {
    // Set definition -> (ArmorPiece -> Item)
    public static final Map<FAArmorSet, Map<EquipmentSlot, Item>> ARMOR_ITEMS = new HashMap<>();

    public static void init() {
        for (FAArmorSet set : FAArmorSet.values()) {
            Map<EquipmentSlot, Item> setPieces = new EnumMap<>(EquipmentSlot.class);

            for (EquipmentSlot type : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
                String name = set.getName() + "_" + net.kenddie.fantasyarmor.item.ArmorPieces.name(type);

                Supplier<FAArmorAttributes> attributesSupplier = FAConfigs.armorSupplier(set, net.kenddie.fantasyarmor.item.ArmorPieces.name(type));

                FAArmorItem item = new FAArmorItem(set, type, attributesSupplier);
                Item registered = Registry.register(
                        BuiltInRegistries.ITEM,
                        new ResourceLocation(FantasyArmor.MOD_ID, name),
                        item
                );
                FAItems.ITEMS.add(item);

                setPieces.put(type, registered);
                CauldronInteraction.WATER.put(registered, CauldronInteraction.WATER.get(Items.LEATHER_CHESTPLATE));
            }

            ARMOR_ITEMS.put(set, setPieces);
        }
    }

    public static Item getArmorItem(FAArmorSet set, EquipmentSlot type) {
        return ARMOR_ITEMS.get(set).get(type);
    }

    private FAArmorItems() {}}
