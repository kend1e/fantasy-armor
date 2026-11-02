package net.kenddie.fantasyarmor.entity.client.armor.render.lib;

import net.minecraft.world.entity.EquipmentSlot;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.item.FAArmorItems;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
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
            for (EquipmentSlot type : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
                Item item = FAArmorItems.getArmorItem(set, type).get();

                registerColorForItem(item, event.getItemColors());
            }
        }
    }

    private static void registerColorForItem(Item item, ItemColors itemColors) {
        itemColors.register((stack, tintIndex) -> {
            if (tintIndex != 1)
                return 0xFFFFFFFF;

            if (!(stack.getItem() instanceof DyeableLeatherItem dyeable) || !dyeable.hasCustomColor(stack)) {
                return 0xFFFFFFFF;
            }

            return dyeable.getColor(stack);
        }, item);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        software.bernie.geckolib3.renderers.geo.GeoArmorRenderer.registerArmorRenderer(
                net.kenddie.fantasyarmor.item.armor.FAArmorItem.class,
                () -> new net.kenddie.fantasyarmor.client.render.FAArmorRenderer(
                        net.kenddie.fantasyarmor.config.FAClientConfig::showCapes,
                        () -> FantasyArmor.isEpicFightLoaded && !net.kenddie.fantasyarmor.config.FAClientConfig.epicFightNotStaticCapes()));

        for (FAArmorSet set : FAArmorSet.values()) {
            for (EquipmentSlot type : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {

                Item item = FAArmorItems.getArmorItem(set, type).get();

                event.enqueueWork(() -> ItemProperties.register(
                        item,
                        new ResourceLocation(FantasyArmor.MOD_ID, "dyed"),
                        (stack, level, entity, seed) -> {
                            if (stack.getItem() instanceof DyeableLeatherItem dyeable
                                    && dyeable.hasCustomColor(stack)) {
                                return 1.0F;
                            }
                            return 0.0F;
                        }
                ));
            }
        }
    }

}
