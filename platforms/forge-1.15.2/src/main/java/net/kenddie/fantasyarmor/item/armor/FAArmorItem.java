package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.config.FAClientConfig;
import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;

import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;

import com.google.common.collect.Multimap;
import net.kenddie.fantasyarmor.client.render.FAArmorRenderer;
import net.kenddie.fantasyarmor.config.FAArmorEffectsConfig;
import net.kenddie.fantasyarmor.config.FAConfig;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.List;
import java.util.function.Supplier;

public class FAArmorItem extends DyeableArmorItem implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);
    private final FAArmorSet armorSet;
    private FAArmorAttributes cachedAttributes;
    private final Supplier<FAArmorAttributes> attributesSupplier;
    private Multimap<String, AttributeModifier> cachedModifiers;

    public FAArmorItem(FAArmorSet armorSet, EquipmentSlotType type, Supplier<FAArmorAttributes> attributesSupplier) {
        super(ArmorMaterial.DIAMOND, type, new Properties().tab(net.kenddie.fantasyarmor.item.FACreativeModTabs.FANTASY_ARMOR_TAB).stacksTo(1));
        this.armorSet = armorSet;
        this.attributesSupplier = attributesSupplier;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        if (FAConfig.enableDurability()) {
            double dur = attributesSupplier.get().durability();
            if (dur > 0) return (int) dur;
        }
        return 0;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);

        if (FAClientConfig.showDescriptions()) {
            String translationKey = this.getDescriptionId() + ".tooltip";
            tooltip.add(new net.minecraft.util.text.TranslationTextComponent(translationKey));
        }

    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @SuppressWarnings("unchecked")
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlotType slot, A original) {
        FAArmorRenderer renderer = (FAArmorRenderer) software.bernie.geckolib3.renderers.geo.GeoArmorRenderer.getRenderer(getClass());
        renderer.applyEntityStats(original);
        renderer.setCurrentItem(entity, stack, slot);
        return (A) renderer.applySlot(slot);
    }

    @Override
    public String getArmorTexture(ItemStack stack, net.minecraft.entity.Entity entity, EquipmentSlotType slot, @Nullable String type) {
        // GeckoLib selects the actual base and dyed layers; Forge still requests a texture for both passes.
        return net.kenddie.fantasyarmor.shared.ModConstants.MOD_ID + ":" + armorSet.getTexturePath();
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
        if (slot != this.slot) {
            return super.getAttributeModifiers(slot, stack);
        }

        FAArmorAttributes effective = attributesSupplier.get().withBonuses(FAConfig.applyModifiers());
        if (cachedModifiers == null || !effective.equals(cachedAttributes)) {
            cachedModifiers = ArmorModifiers.build(slot, effective);
            cachedAttributes = effective;
        }

        return cachedModifiers;
    }

    @Override
    public void registerControllers(AnimationData controllers) {
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    public List<EffectEntry> getFullSetEffects() {
        return FAArmorEffectsConfig.ARMOR_EFFECTS_CONFIGS.get(armorSet.getName()).getEffects();
    }

    public FAArmorSet getArmorSet() {
        return armorSet;
    }

}
