package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.shared.content.MaterialCatalog;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings({"unused"})
public final class FAItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FantasyArmor.MOD_ID);

    private FAItems() {}

    public static void register(IEventBus eventBus) {
        MaterialCatalog.IDS.forEach(id -> ITEMS.registerItem(id, FAMaterials::create));
        ITEMS.register(eventBus);
    }
}
