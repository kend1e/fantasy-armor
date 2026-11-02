package net.kenddie.fantasyarmor.entity.client.armor.render.lib;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.client.render.FARenderUtils;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FantasyArmor.MOD_ID, value = Dist.CLIENT)
@SuppressWarnings("unused")
public final class FARenderEventHandler {
    @SubscribeEvent
    public static void onRenderPlayerPre(RenderPlayerEvent.Pre event) {
        Item item = event.getPlayer().getItemBySlot(EquipmentSlotType.CHEST).getItem();

        if(item instanceof FAArmorItem) {
            PlayerModel<AbstractClientPlayerEntity> model = event.getRenderer().getModel();
            FARenderUtils.setArmsVisibility(model, false);
        }
    }

    @SubscribeEvent
    public static void onRenderPlayerPost(RenderPlayerEvent.Post event) {
        Item item = event.getPlayer().getItemBySlot(EquipmentSlotType.CHEST).getItem();

        if(item instanceof FAArmorItem) {
            PlayerModel<AbstractClientPlayerEntity> model = event.getRenderer().getModel();
            FARenderUtils.setArmsVisibility(model, true);
        }
    }
}
