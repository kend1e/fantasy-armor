package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.shared.content.MaterialCatalog;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public final class FAItems {
    public static final Collection<Item> ITEMS = new ArrayList<>();

    private FAItems() {
    }

    public static void register() {
        MaterialCatalog.IDS.forEach(id -> register(id, FAMaterials::create));
    }

    private static Item register(String name, Function<Item.Properties, Item> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(FantasyArmor.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(BuiltInRegistries.ITEM.key(), id);

        Item.Properties props = new Item.Properties().setId(key);
        Item item = factory.apply(props);

        Item registered = Registry.register(BuiltInRegistries.ITEM, key, item);
        ITEMS.add(registered);

        return registered;
    }
}