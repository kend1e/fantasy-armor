package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.shared.ModConstants;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
public final class FACreativeModTabs {
    public static final CreativeModeTab FANTASY_ARMOR_TAB = FabricItemGroupBuilder.create(new ResourceLocation(ModConstants.MOD_ID, "fa_tab"))
            .icon(() -> new ItemStack(FAArmorItems.getArmorItem(FAArmorSet.require("hero"), EquipmentSlot.HEAD))).build();
    public static void register() {}
    private FACreativeModTabs() {}
}
