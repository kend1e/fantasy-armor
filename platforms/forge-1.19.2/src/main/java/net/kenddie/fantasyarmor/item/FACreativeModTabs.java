package net.kenddie.fantasyarmor.item;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
public final class FACreativeModTabs {
    public static final CreativeModeTab FANTASY_ARMOR_TAB = new CreativeModeTab("fantasy_armor.fa_tab") {
        @Override public ItemStack makeIcon() { return new ItemStack(FAArmorItems.getArmorItem(FAArmorSet.require("hero"), EquipmentSlot.HEAD).get()); }
    };
    private FACreativeModTabs() {}
}
