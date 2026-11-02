package net.kenddie.fantasyarmor.item.armor;

import com.google.common.collect.Multimap;
import net.kenddie.fantasyarmor.client.render.FAArmorRenderer;
import net.kenddie.fantasyarmor.config.FAConfig;
import net.kenddie.fantasyarmor.item.ArmorPieces;
import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import java.util.List;

public final class FAArmorItem extends ItemArmor implements IAnimatable {
    private final FAArmorSet armorSet;
    private final AnimationFactory factory = new AnimationFactory(this);
    private FAArmorAttributes cachedAttributes;
    private Multimap<String, AttributeModifier> cachedModifiers;

    public FAArmorItem(FAArmorSet set, EntityEquipmentSlot slot) {
        super(ArmorMaterial.DIAMOND, 0, slot);
        armorSet = set;
    }

    public FAArmorSet getArmorSet() { return armorSet; }
    @Override public int getItemEnchantability() { return 15; }
    @Override public int getMaxDamage(ItemStack stack) {
        return FAConfig.durability() ? Math.max(0, (int) FAConfig.attributes(armorSet, ArmorPieces.name(armorType)).durability()) : 0;
    }
    @Override public boolean isEnchantable(ItemStack stack) { return true; }
    @Override public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        if (slot != armorType) return super.getAttributeModifiers(slot, stack);
        FAArmorAttributes attributes = FAConfig.attributes(armorSet, ArmorPieces.name(slot)).withBonuses(FAConfig.modifiers());
        if (!attributes.equals(cachedAttributes)) {
            cachedAttributes = attributes;
            cachedModifiers = ArmorModifiers.build(slot, attributes);
        }
        return cachedModifiers;
    }

    @Override public boolean hasColor(ItemStack stack) {
        NBTTagCompound display = stack.getSubCompound("display");
        return display != null && display.hasKey("color", 99);
    }
    @Override public int getColor(ItemStack stack) { return hasColor(stack) ? stack.getSubCompound("display").getInteger("color") : 0xA06540; }
    @Override public void setColor(ItemStack stack, int color) { stack.getOrCreateSubCompound("display").setInteger("color", color); }
    @Override public void removeColor(ItemStack stack) {
        NBTTagCompound display = stack.getSubCompound("display");
        if (display != null) display.removeTag("color");
    }
    @Override public boolean hasOverlay(ItemStack stack) { return hasColor(stack); }

    @Override @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack stack, EntityEquipmentSlot slot, ModelBiped original) {
        FAArmorRenderer renderer = (FAArmorRenderer) software.bernie.geckolib3.renderers.geo.GeoArmorRenderer.getRenderer(getClass());
        renderer.applyEntityStats(original);
        renderer.setCurrentItem(entity, stack, slot);
        return renderer.applySlot(slot);
    }
    @Override @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        if (FAConfig.showDescriptions) tooltip.add(I18n.format(getTranslationKey() + ".tooltip"));
    }
    @Override public void registerControllers(AnimationData data) {}
    @Override public AnimationFactory getFactory() { return factory; }
}
