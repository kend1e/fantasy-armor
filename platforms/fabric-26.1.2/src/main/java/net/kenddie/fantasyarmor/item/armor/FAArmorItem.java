package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.shared.config.EffectEntry;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;

import net.kenddie.fantasyarmor.shared.armor.FAArmorAttributes;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.client.model.FAArmorModel;
import net.kenddie.fantasyarmor.client.render.FAArmorRenderer;
import net.kenddie.fantasyarmor.config.FAArmorEffectsConfig;
import net.kenddie.fantasyarmor.config.FAConfigs;
import net.kenddie.fantasyarmor.item.FATooltips;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.Nullable;
import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.renderer.GeoArmorRenderer;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FAArmorItem extends Item implements GeoItem {
    public static final int DEFAULT_COLOR = 0xA06540;

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    private final FAArmorSet armorSet;
    private final ArmorType armorType;
    private final Supplier<FAArmorAttributes> attributesSupplier;
    private FAArmorAttributes cachedAttributes;
    private ItemAttributeModifiers cachedModifiers;

    public FAArmorItem(FAArmorSet armorSet, ArmorType armorType, Supplier<FAArmorAttributes> attributesSupplier, Item.Properties properties) {
        super(buildProperties(properties, armorType, attributesSupplier.get()));
        this.armorSet = armorSet;
        this.armorType = armorType;
        this.attributesSupplier = attributesSupplier;
    }

    private static Item.Properties buildProperties(Item.Properties properties, ArmorType armorType, FAArmorAttributes armorAttributes) {
        ItemAttributeModifiers modifiers = ArmorModifiers.build(armorType, armorAttributes.withBonuses(FAConfigs.getMainConfig().applyModifiers));

        properties = properties
                .stacksTo(1)
                .fireResistant()
                .humanoidArmor(ArmorMaterials.NETHERITE, armorType)
                .component(DataComponents.ATTRIBUTE_MODIFIERS, modifiers);

        if (FAConfigs.getMainConfig().enableDurability && armorAttributes.durability() > 0) {
            properties = properties.durability((int) armorAttributes.durability());
        }

        return properties;
    }

    public FAArmorSet getArmorSet() {
        return armorSet;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    @Override
    public void inventoryTick(ItemStack stack, net.minecraft.server.level.ServerLevel level, net.minecraft.world.entity.Entity entity, @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, level, entity, slot);
        applyServerSettings(stack);
    }

    public boolean hasCustomColor(ItemStack stack) {
        return stack.has(DataComponents.DYED_COLOR);
    }

    public int getColor(ItemStack stack) {
        DyedItemColor color = stack.get(DataComponents.DYED_COLOR);
        return color != null ? color.rgb() : DEFAULT_COLOR;
    }

    public void setColor(ItemStack stack, int color) {
        stack.set(DataComponents.DYED_COLOR, new DyedItemColor(color));
    }

    public void clearColor(ItemStack stack) {
        stack.remove(DataComponents.DYED_COLOR);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, flag);

        if (FAConfigs.getMainConfig().showDescriptions) {
            FATooltips.append(
                    Component.translatable(getDescriptionId() + ".tooltip"),
                    FAConfigs.getMainConfig().descriptionsLength,
                    tooltipAdder);
        }

    }

    public List<EffectEntry> getFullSetEffects() {
        return FAArmorEffectsConfig.getEffectsFor(armorSet.getName());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        // No controllers yet
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private GeoArmorRenderer<?, ?> renderer;

            @Override
            public @Nullable GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
                if (this.renderer == null) {
                    this.renderer = new FAArmorRenderer<>(new FAArmorModel<>(armorSet.getGeoPath(), armorSet.getTexturePath()), armorSet,
                            () -> FAConfigs.getMainConfig().showCapes, () -> false);
                }

                return this.renderer;
            }
        });
    }

    public void applyServerSettings(ItemStack stack) {
        var attributes = attributesSupplier.get().withBonuses(FAConfigs.getMainConfig().applyModifiers);
        if (cachedModifiers == null || !attributes.equals(cachedAttributes)) {
            cachedModifiers = ArmorModifiers.build(armorType, attributes);
            cachedAttributes = attributes;
        }
        ArmorStackSettings.apply(stack, attributes, cachedModifiers, FAConfigs.getMainConfig().enableDurability);
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        applyServerSettings(stack);
        return stack;
    }

    @Override
    public void onCraftedBy(ItemStack stack, net.minecraft.world.entity.player.Player player) {
        super.onCraftedBy(stack, player);
        if (!player.level().isClientSide()) applyServerSettings(stack);
    }

}
