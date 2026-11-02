package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.config.FAClientConfig;
import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;

import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;

import com.google.common.collect.Multimap;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.client.model.FAArmorModel;
import net.kenddie.fantasyarmor.client.render.FAArmorRenderer;
import net.kenddie.fantasyarmor.config.FAArmorEffectsConfig;
import net.kenddie.fantasyarmor.config.FAConfig;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FAArmorItem extends DyeableArmorItem implements GeoItem {

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final FAArmorSet armorSet;
    private FAArmorAttributes cachedAttributes;
    private final Supplier<FAArmorAttributes> attributesSupplier;
    private Multimap<Attribute, AttributeModifier> cachedModifiers;

    public FAArmorItem(FAArmorSet armorSet, EquipmentSlot type, Supplier<FAArmorAttributes> attributesSupplier) {
        super(ArmorMaterials.NETHERITE, type, new Properties().stacksTo(1).fireResistant());
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
    public boolean isDamageable(ItemStack stack) {
        return getMaxDamage(stack) > 0;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);

        if (FAClientConfig.showDescriptions()) {
            String translationKey = this.getDescriptionId() + ".tooltip";
            tooltip.add(Component.translatable(translationKey));
        }

    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<? extends FAArmorItem> renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (renderer == null) {
                    renderer = createArmorRenderer();
                }

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }

    @Override
    public String getArmorTexture(ItemStack stack, net.minecraft.world.entity.Entity entity, EquipmentSlot slot, @Nullable String type) {
        // GeckoLib selects the actual base and dyed layers; Forge still requests a texture for both passes.
        return net.kenddie.fantasyarmor.shared.ModConstants.MOD_ID + ":" + armorSet.getTexturePath();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
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
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @OnlyIn(Dist.CLIENT)
    protected GeoArmorRenderer<? extends FAArmorItem> createArmorRenderer() {

        return new FAArmorRenderer<>(new FAArmorModel<>("geo/" + armorSet.getGeoPath() + ".geo.json", armorSet.getTexturePath()), armorSet,
                            () -> FAClientConfig.showCapes(), () -> FantasyArmor.isEpicFightLoaded && !FAClientConfig.epicFightNotStaticCapes(), 3.5f);
    }

    public List<EffectEntry> getFullSetEffects() {
        return FAArmorEffectsConfig.ARMOR_EFFECTS_CONFIGS.get(armorSet.getName()).getEffects();
    }

    public FAArmorSet getArmorSet() {
        return armorSet;
    }

}
