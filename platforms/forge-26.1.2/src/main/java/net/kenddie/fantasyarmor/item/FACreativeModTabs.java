package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings({"unused"})
public class FACreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FantasyArmor.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FANTASY_ARMOR_TAB =
            CREATIVE_MODE_TABS.register(
                    "fa_tab",
                    () -> CreativeModeTab.builder()
                            .icon(() -> new ItemStack(FAArmorItems.ARMOR_ITEMS.get(FAArmorSet.require("hero")).get(ArmorType.HELMET).get()))
                            .title(Component.translatable("itemGroup." + FantasyArmor.MOD_ID + ".fa_tab"))
                            .displayItems((pParameters, pOutput) -> {
                                FAItems.ITEMS.getEntries().forEach(item -> {
                                    pOutput.accept(item.get());
                                });
                            })
                            .build()
            );

    public static void register(BusGroup eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
