package net.kenddie.fantasyarmor.item;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
public final class FACreativeModTabs {
    public static final ItemGroup FANTASY_ARMOR_TAB = new ItemGroup("fantasy_armor.fa_tab") {
        @Override public ItemStack makeIcon() { return new ItemStack(FAArmorItems.getArmorItem(FAArmorSet.require("hero"), EquipmentSlotType.HEAD).get()); }
    };
    private FACreativeModTabs() {}
}
