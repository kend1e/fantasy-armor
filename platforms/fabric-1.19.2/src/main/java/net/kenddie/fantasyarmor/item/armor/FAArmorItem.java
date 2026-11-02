package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;

import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;

import com.google.common.collect.Multimap;
import net.kenddie.fantasyarmor.config.FAArmorEffectsConfig;
import net.kenddie.fantasyarmor.config.FAConfigs;
import net.kenddie.fantasyarmor.item.FATooltips;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;
import java.util.function.Supplier;

public class FAArmorItem extends DyeableArmorItem implements IAnimatable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private final FAArmorSet armorSet;
    private FAArmorAttributes cachedAttributes;
    private final Supplier<FAArmorAttributes> attributesSupplier;
    private Multimap<Attribute, AttributeModifier> cachedModifiers;

    public FAArmorItem(FAArmorSet armorSet, EquipmentSlot type, Supplier<FAArmorAttributes> attributesSupplier) {
        super(ArmorMaterials.NETHERITE, type, buildProperties(attributesSupplier));
        this.armorSet = armorSet;
        this.attributesSupplier = attributesSupplier;
    }

    private static Properties buildProperties(Supplier<FAArmorAttributes> attributesSupplier) {
        Properties props = new Properties().tab(net.kenddie.fantasyarmor.item.FACreativeModTabs.FANTASY_ARMOR_TAB).stacksTo(1).fireResistant();
        FAArmorAttributes attrs = attributesSupplier.get();
        if (FAConfigs.getMainConfig().enableDurability && attrs.durability() > 0) {
            props = props.durability((int) attrs.durability());
        }
        return props;
    }

    public int configuredMaxDamage() {
        return FAConfigs.getMainConfig().enableDurability
                ? Math.max(0, (int) attributesSupplier.get().durability()) : 0;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);

        if (FAConfigs.getMainConfig().showDescriptions) {
            FATooltips.append(
                    Component.translatable(getDescriptionId() + ".tooltip"),
                    FAConfigs.getMainConfig().descriptionsLength,
                    tooltip::add);
        }

    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(ItemStack stack, EquipmentSlot slot) {
        if (slot != this.slot) {
            return super.getAttributeModifiers(stack, slot);
        }

        FAArmorAttributes effective = attributesSupplier.get().withBonuses(FAConfigs.getMainConfig().applyModifiers);
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
        return FAArmorEffectsConfig.getEffectsFor(armorSet.getName());
    }

    public FAArmorSet getArmorSet() {
        return armorSet;
    }

}
