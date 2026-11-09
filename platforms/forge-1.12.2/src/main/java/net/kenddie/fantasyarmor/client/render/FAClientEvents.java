package net.kenddie.fantasyarmor.client.render;

import net.kenddie.fantasyarmor.item.ArmorPieces;
import net.kenddie.fantasyarmor.item.FAItems;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.kenddie.fantasyarmor.shared.armor.FAArmorSet;
import net.kenddie.fantasyarmor.shared.content.MaterialCatalog;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, value = Side.CLIENT)
public final class FAClientEvents {
    @SubscribeEvent
    public static void models(ModelRegistryEvent event) {
        for (String id : MaterialCatalog.IDS) registerModel(id);
        for (FAArmorSet set : FAArmorSet.values()) {
            for (EntityEquipmentSlot slot : new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET}) {
                String id = set.getName() + "_" + ArmorPieces.name(slot);
                registerModel(id);
                FAItems.get(id).addPropertyOverride(new ResourceLocation(ModConstants.MOD_ID, "dyed"),
                        (stack, world, entity) -> ((FAArmorItem) stack.getItem()).hasColor(stack) ? 1 : 0);
            }
        }
        GeoArmorRenderer.registerArmorRenderer(FAArmorItem.class, new FAArmorRenderer());
    }
    private static void registerModel(String id) {
        ModelLoader.setCustomModelResourceLocation(FAItems.get(id), 0,
                new ModelResourceLocation(new ResourceLocation(ModConstants.MOD_ID, id), "inventory"));
    }
    @SubscribeEvent
    public static void colors(ColorHandlerEvent.Item event) {
        for (FAArmorSet set : FAArmorSet.values()) {
            for (EntityEquipmentSlot slot : new EntityEquipmentSlot[]{EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET}) {
                event.getItemColors().registerItemColorHandler((stack, tint) -> tint == 1 ? ((FAArmorItem) stack.getItem()).getColor(stack) : 0xFFFFFF,
                        FAItems.get(set.getName() + "_" + ArmorPieces.name(slot)));
            }
        }
    }
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void before(RenderLivingEvent.Pre<?> event) {
        if (!(event.getRenderer() instanceof RenderPlayer)) return;
        Item chest = event.getEntity().getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem();
        if (!(chest instanceof FAArmorItem)) return;
        FAArmVisibilityLayer.hideArms((RenderPlayer) event.getRenderer());
    }
    @SubscribeEvent
    public static void after(RenderPlayerEvent.Post event) {
        FAArmVisibilityLayer.restoreArms(event.getRenderer());
    }
    private FAClientEvents() {}
}
