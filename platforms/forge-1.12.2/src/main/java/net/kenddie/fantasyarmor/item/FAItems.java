package net.kenddie.fantasyarmor.item;

import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.kenddie.fantasyarmor.shared.content.MaterialCatalog;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.List;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID)
public final class FAItems {
    public static final CreativeTabs TAB = new CreativeTabs(ModConstants.MOD_ID + ".fa_tab") {
        @Override public ItemStack createIcon() { return new ItemStack(get("hero_helmet")); }
        @Override @SideOnly(Side.CLIENT)
        public String getTranslationKey() { return "itemGroup." + ModConstants.MOD_ID + ".fa_tab"; }
    };

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Item> event) {
        for (String id : MaterialCatalog.IDS) {
            Item item = new Item() {
                @Override @SideOnly(Side.CLIENT)
                public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
                    super.addInformation(stack, world, tooltip, flag);
                    tooltip.add(TextFormatting.GRAY + I18n.format(getTranslationKey() + ".tooltip"));
                }
            };
            event.getRegistry().register(named(id, item));
        }
        for (FAArmorSet set : FAArmorSet.values()) {
            for (EntityEquipmentSlot slot : new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET}) {
                event.getRegistry().register(named(set.getName() + "_" + ArmorPieces.name(slot), new FAArmorItem(set, slot)));
            }
        }
    }

    private static Item named(String id, Item item) {
        return item.setRegistryName(new ResourceLocation(ModConstants.MOD_ID, id))
                .setTranslationKey(ModConstants.MOD_ID + "." + id).setCreativeTab(TAB);
    }
    public static Item get(String id) { return ForgeRegistries.ITEMS.getValue(new ResourceLocation(ModConstants.MOD_ID, id)); }
    private FAItems() {}
}
