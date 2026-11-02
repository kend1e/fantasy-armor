package net.kenddie.fantasyarmor.item.armor;

import net.kenddie.fantasyarmor.config.FAConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FAArmorEffectHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            PlayerEntity player = event.player;
            if (player.level.isClientSide) return;

            ArmorSetEffects.tick(player, FAConfig.applyArmorEffects(), FAConfig.effectsInterval(), FAConfig.showParticles(), FAConfig.showEffectIcon());
        }
    }

}
