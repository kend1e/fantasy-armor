package net.kenddie.fantasyarmor.client.render;

import net.minecraft.world.entity.EquipmentSlot;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.item.FAArmorItems;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;

public class FAClientEventHandler implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        software.bernie.geckolib3.renderer.geo.GeoArmorRenderer.registerArmorRenderer(
                net.kenddie.fantasyarmor.item.armor.FAArmorItem.class,
                new FAArmorRenderer(() -> net.kenddie.fantasyarmor.config.FAConfigs.getMainConfig().showCapes, () -> false));
        registerItemColors();
        registerDyedPredicate();
    }

    private static void registerItemColors() {
        for (FAArmorSet set : FAArmorSet.values()) {
            for (EquipmentSlot type : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
                Item item = FAArmorItems.getArmorItem(set, type);

                ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
                    if (tintIndex != 1) {
                        return 0xFFFFFFFF;
                    }

                    if (!(stack.getItem() instanceof DyeableArmorItem) || !((DyeableLeatherItem) stack.getItem()).hasCustomColor(stack)) {
                        return 0xFFFFFFFF;
                    }

                    return ((DyeableLeatherItem) stack.getItem()).getColor(stack);
                }, item);
            }
        }
    }

    private static void registerDyedPredicate() {
        ResourceLocation id = new ResourceLocation(FantasyArmor.MOD_ID, "dyed");

        for (FAArmorSet set : FAArmorSet.values()) {
            for (EquipmentSlot type : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
                Item item = FAArmorItems.getArmorItem(set, type);

                FabricModelPredicateProviderRegistry.register(item, id, (stack, level, entity) -> {
                    if (stack.getItem() instanceof DyeableLeatherItem && ((DyeableLeatherItem) stack.getItem()).hasCustomColor(stack)) {
                        return 1.0F;
                    }
                    return 0.0F;
                });
            }
        }
    }
}
