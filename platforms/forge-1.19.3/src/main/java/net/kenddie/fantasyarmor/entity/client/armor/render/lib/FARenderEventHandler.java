package net.kenddie.fantasyarmor.entity.client.armor.render.lib;

import net.kenddie.fantasyarmor.FantasyArmor;
import net.kenddie.fantasyarmor.client.render.FARenderUtils;
import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FantasyArmor.MOD_ID, value = Dist.CLIENT)
@SuppressWarnings("unused")
public final class FARenderEventHandler {
    @SubscribeEvent
    public static void onRenderPlayerPre(RenderPlayerEvent.Pre event) {
        Item item = event.getEntity().getItemBySlot(EquipmentSlot.CHEST).getItem();

        if(item instanceof FAArmorItem) {
            PlayerModel<AbstractClientPlayer> model = event.getRenderer().getModel();
            FARenderUtils.setArmsVisibility(model, false);
        }
    }

    @SubscribeEvent
    public static void onRenderPlayerPost(RenderPlayerEvent.Post event) {
        Item item = event.getEntity().getItemBySlot(EquipmentSlot.CHEST).getItem();

        if(item instanceof FAArmorItem) {
            PlayerModel<AbstractClientPlayer> model = event.getRenderer().getModel();
            FARenderUtils.setArmsVisibility(model, true);
        }
    }
}
