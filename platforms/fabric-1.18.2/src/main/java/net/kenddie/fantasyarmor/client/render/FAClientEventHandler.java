package net.kenddie.fantasyarmor.client.render;

import net.minecraft.world.entity.EquipmentSlot;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.item.FAArmorItems;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeableArmorItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;

public class FAClientEventHandler implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        software.bernie.geckolib3.renderers.geo.GeoArmorRenderer.registerArmorRenderer(
                new FAArmorRenderer(() -> net.kenddie.fantasyarmor.config.FAConfigs.getMainConfig().showCapes, () -> false),
                FAArmorItems.ARMOR_ITEMS.values().stream().flatMap(pieces -> pieces.values().stream()).toArray(Item[]::new));
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

                    if (!(stack.getItem() instanceof DyeableArmorItem dyeable) || !dyeable.hasCustomColor(stack)) {
                        return 0xFFFFFFFF;
                    }

                    return dyeable.getColor(stack);
                }, item);
            }
        }
    }

    private static void registerDyedPredicate() {
        ResourceLocation id = new ResourceLocation(FantasyArmor.MOD_ID, "dyed");

        for (FAArmorSet set : FAArmorSet.values()) {
            for (EquipmentSlot type : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
                Item item = FAArmorItems.getArmorItem(set, type);

                ItemProperties.register(item, id, (stack, level, entity, seed) -> {
                    if (stack.getItem() instanceof DyeableLeatherItem dyeable && dyeable.hasCustomColor(stack)) {
                        return 1.0F;
                    }
                    return 0.0F;
                });
            }
        }
    }
}
