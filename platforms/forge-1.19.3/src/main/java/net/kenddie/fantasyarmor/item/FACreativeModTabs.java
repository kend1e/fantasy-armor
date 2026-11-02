package net.kenddie.fantasyarmor.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FantasyArmor.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FACreativeModTabs {
    public static CreativeModeTab FANTASY_ARMOR_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        FANTASY_ARMOR_TAB = event.registerCreativeModeTab(new ResourceLocation(FantasyArmor.MOD_ID, "fa_tab"),
                builder -> builder.icon(() -> new ItemStack(FAArmorItems.ARMOR_ITEMS.get(FAArmorSet.require("hero")).get(EquipmentSlot.HEAD).get()))
                        .title(Component.translatable("itemGroup." + FantasyArmor.MOD_ID + ".fa_tab")));
    }

    @SubscribeEvent
    public static void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == FACreativeModTabs.FANTASY_ARMOR_TAB) {
            FAItems.ITEMS.getEntries().forEach(item -> event.accept(item.get()));
        }
    }
}
