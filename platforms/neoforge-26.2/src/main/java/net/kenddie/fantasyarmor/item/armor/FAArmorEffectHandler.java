package net.kenddie.fantasyarmor.item.armor;

import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.kenddie.fantasyarmor.config.FAConfig;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class FAArmorEffectHandler {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Pre event) {
        Player player = event.getEntity();
        if (player.level().isClientSide()) return;

        ArmorSetEffects.tick(player, FAConfig.applyArmorEffects, FAConfig.effectsInterval, FAConfig.showParticles, FAConfig.showEffectIcon);
    }

    @SubscribeEvent
    public static void onEquipmentChanged(LivingEquipmentChangeEvent event) {
        if (!event.getEntity().level().isClientSide() && event.getTo().getItem() instanceof FAArmorItem armor) {
            armor.applyServerSettings(event.getTo());
        }
    }
}
