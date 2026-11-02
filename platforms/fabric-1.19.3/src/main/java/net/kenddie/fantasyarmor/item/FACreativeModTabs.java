package net.kenddie.fantasyarmor.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class FACreativeModTabs {
    public static final CreativeModeTab FANTASY_ARMOR_TAB = FabricItemGroup.builder(new ResourceLocation(FantasyArmor.MOD_ID, "fa_tab")).icon(() ->
            new ItemStack(FAArmorItems.getArmorItem(FAArmorSet.require("hero"), EquipmentSlot.HEAD)))
            .title(Component.translatable("itemGroup." + FantasyArmor.MOD_ID + ".fa_tab"))
            .displayItems((flags, populator, permissions) -> {
        for (var item : FAItems.ITEMS) {
            populator.accept(item);
        }
    }).build();

    private FACreativeModTabs() {
    }

    public static void register() {

    }
}
