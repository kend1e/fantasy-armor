package net.kenddie.fantasyarmor.item.armor;

import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.kenddie.fantasyarmor.config.FAConfig;
import net.kenddie.fantasyarmor.FantasyArmor;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FantasyArmor.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FAArmorEffectHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent.Pre event) {
        if (event.side() == net.minecraftforge.fml.LogicalSide.SERVER) {
            Player player = event.player();

            ArmorSetEffects.tick(player, FAConfig.applyArmorEffects(), FAConfig.effectsInterval(), FAConfig.showParticles(), FAConfig.showEffectIcon());
        }
    }

    @SubscribeEvent
    public static void onEquipmentChanged(LivingEquipmentChangeEvent event) {
        if (!event.getEntity().level().isClientSide() && event.getTo().getItem() instanceof FAArmorItem armor) {
            armor.applyServerSettings(event.getTo());
        }
    }

}
