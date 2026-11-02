package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.config.FAConfigs;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.core.cauldron.CauldronInteraction;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class FAArmorItems {
    // Set definition -> (ArmorPiece -> Item)
    public static final Map<FAArmorSet, Map<ArmorItem.Type, Item>> ARMOR_ITEMS = new HashMap<>();

    public static void init() {
        for (FAArmorSet set : FAArmorSet.values()) {
            Map<ArmorItem.Type, Item> setPieces = new EnumMap<>(ArmorItem.Type.class);

            for (ArmorItem.Type type : ArmorItem.Type.values()) {
                String name = set.getName() + "_" + type.getName();

                Supplier<FAArmorAttributes> attributesSupplier = FAConfigs.armorSupplier(set, type.getName());

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

    public static Item getArmorItem(FAArmorSet set, ArmorItem.Type type) {
        return ARMOR_ITEMS.get(set).get(type);
    }

    private FAArmorItems() {}}
