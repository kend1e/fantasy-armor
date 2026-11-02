package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.shared.content.MaterialCatalog;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.Collection;

public final class FAItems {
    public static final Collection<Item> ITEMS = new ArrayList<>();

    private FAItems() {
    }

    public static void register() {
        MaterialCatalog.IDS.forEach(id -> register(id, FAMaterials.create(new Item.Properties().tab(net.kenddie.fantasyarmor.item.FACreativeModTabs.FANTASY_ARMOR_TAB))));
    }

    private static void register(String name, Item item) {
        Registry.register(Registry.ITEM, new ResourceLocation(FantasyArmor.MOD_ID, name), item);
        ITEMS.add(item);
    }
}
