package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.shared.content.MaterialCatalog;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.Collection;

public final class FAItems {
    public static final Collection<Item> ITEMS = new ArrayList<>();

    private FAItems() {
    }

    public static void register() {
        MaterialCatalog.IDS.forEach(id -> register(id, FAMaterials.create(new Item.Properties())));
    }

    private static void register(String name, Item item) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(FantasyArmor.MOD_ID, name), item);
        ITEMS.add(item);
    }
}
