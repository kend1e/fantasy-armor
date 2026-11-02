package net.kenddie.fantasyarmor.item.armor;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.kenddie.fantasyarmor.config.FAConfigs;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

public class FAArmorEffectHandler {

    public static void register() {
        ServerTickEvents.START_WORLD_TICK.register(FAArmorEffectHandler::onWorldTick);
    }

    private static void onWorldTick(ServerLevel world) {
        var config = FAConfigs.getMainConfig();
        for (ServerPlayer player : world.players()) {
            ArmorSetEffects.tick(player, config.applyArmorEffects, config.effectsInterval, config.showParticles, config.showEffectIcon);
        }
    }

}
