package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.shared.content.MaterialCatalog;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings({"unused"})
public final class FAItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FantasyArmor.MOD_ID);

    private FAItems() {}

    public static void register(BusGroup eventBus) {
        MaterialCatalog.IDS.forEach(id -> ITEMS.register(id, () -> FAMaterials.create(new Item.Properties().setId(ITEMS.key(id)))));
        ITEMS.register(eventBus);
    }
}
