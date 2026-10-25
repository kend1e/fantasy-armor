package net.kenddie.fantasyarmor.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;

public final class FACreativeModTabs {
    public static final CreativeModeTab FANTASY_ARMOR_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(FAArmorItems.getArmorItem(FAArmorSet.require("hero"), ArmorType.HELMET)))
            .title(Component.translatable("itemGroup." + FantasyArmor.MOD_ID + ".fa_tab"))
            .displayItems((context, entries) -> {
                for (var item : FAItems.ITEMS) {
                    entries.accept(item);
                }
            })
            .build();

    private FACreativeModTabs() {
    }

    public static void register() {
        Identifier id = Identifier.fromNamespaceAndPath(FantasyArmor.MOD_ID, "fa_tab");
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, id, FANTASY_ARMOR_TAB);
    }
}