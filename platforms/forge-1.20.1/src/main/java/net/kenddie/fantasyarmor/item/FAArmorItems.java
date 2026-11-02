package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.config.FAArmorAttributesConfig;
import net.kenddie.fantasyarmor.config.FAArmorConfig;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class FAArmorItems {
    // Set definition -> (ArmorPiece -> RegistryObject<Item> )
    public static final Map<FAArmorSet, Map<ArmorItem.Type, RegistryObject<Item>>> ARMOR_ITEMS = new HashMap<>();

    public static void register(IEventBus eventBus) {
        for (FAArmorSet set : FAArmorSet.values()) {
            Map<ArmorItem.Type, RegistryObject<Item>> setPieces = new HashMap<>();

            for (ArmorItem.Type type : ArmorItem.Type.values()) {
                String name = set.getName() + "_" + type.getName();

                FAArmorAttributesConfig config = FAArmorConfig.ARMOR_CONFIGS.get(set.getName()).get(type.getName());

                Supplier<FAArmorAttributes> attributesSupplier = config::read;

                RegistryObject<Item> item = FAItems.ITEMS.register(name, () -> new FAArmorItem(set, type, attributesSupplier));
                setPieces.put(type, item);
            }

            ARMOR_ITEMS.put(set, setPieces);
        }
        eventBus.addListener((FMLCommonSetupEvent event) -> event.enqueueWork(() -> {
            var interactions = CauldronInteraction.WATER;
            var wash = interactions.get(Items.LEATHER_CHESTPLATE);
            ARMOR_ITEMS.values().forEach(pieces -> pieces.values().forEach(item -> interactions.put(item.get(), wash)));
        }));
    }

    public static RegistryObject<Item> getArmorItem(FAArmorSet set, ArmorItem.Type type) {
        return ARMOR_ITEMS.get(set).get(type);
    }

    private FAArmorItems() {}
}
