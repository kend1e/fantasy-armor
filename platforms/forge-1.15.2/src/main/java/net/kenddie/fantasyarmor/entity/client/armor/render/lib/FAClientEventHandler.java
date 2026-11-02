package net.kenddie.fantasyarmor.entity.client.armor.render.lib;

import net.minecraft.inventory.EquipmentSlotType;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.item.FAArmorItems;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.client.renderer.color.ItemColors;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        modid = FantasyArmor.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class FAClientEventHandler {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onItemColors(ColorHandlerEvent.Item event) {
        for (FAArmorSet set : FAArmorSet.values()) {
            for (EquipmentSlotType type : new EquipmentSlotType[]{EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET}) {
                Item item = FAArmorItems.getArmorItem(set, type).get();

                registerColorForItem(item, event.getItemColors());
            }
        }
    }

    private static void registerColorForItem(Item item, ItemColors itemColors) {
        itemColors.register((stack, tintIndex) -> {
            if (tintIndex != 1)
                return 0xFFFFFFFF;

            if (!(stack.getItem() instanceof IDyeableArmorItem) || !((IDyeableArmorItem) stack.getItem()).hasCustomColor(stack)) {
                return 0xFFFFFFFF;
            }

            return ((IDyeableArmorItem) stack.getItem()).getColor(stack);
        }, item);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        software.bernie.geckolib3.renderers.geo.GeoArmorRenderer.registerArmorRenderer(
                net.kenddie.fantasyarmor.item.armor.FAArmorItem.class,
                new net.kenddie.fantasyarmor.client.render.FAArmorRenderer(
                        net.kenddie.fantasyarmor.config.FAClientConfig::showCapes,
                        () -> FantasyArmor.isEpicFightLoaded && !net.kenddie.fantasyarmor.config.FAClientConfig.epicFightNotStaticCapes()));

        for (FAArmorSet set : FAArmorSet.values()) {
            for (EquipmentSlotType type : new EquipmentSlotType[]{EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET}) {

                Item item = FAArmorItems.getArmorItem(set, type).get();

                net.minecraftforge.fml.DeferredWorkQueue.runLater(() -> item.addProperty(
                        new ResourceLocation(FantasyArmor.MOD_ID, "dyed"),
                        (stack, level, entity) -> {
                            if (stack.getItem() instanceof IDyeableArmorItem
                                    && ((IDyeableArmorItem) stack.getItem()).hasCustomColor(stack)) {
                                return 1.0F;
                            }
                            return 0.0F;
                        }
                ));
            }
        }
    }

}
