package net.kenddie.fantasyarmor.test;

import com.mojang.authlib.GameProfile;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import java.util.UUID;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

final class TickAccess {
    static Player createPlayer(GameTestHelper helper) {
        var level = helper.getLevel();
        var player = new ServerPlayer(level.getServer(), level,
                new GameProfile(UUID.randomUUID(), "armor-test"), null) {
            @Override public boolean isSpectator() { return false; }
            @Override public boolean isCreative() { return true; }
        };
        player.connection = new ServerGamePacketListenerImpl(level.getServer(),
                new Connection(PacketFlow.SERVERBOUND), player);
        level.addNewPlayer(player);
        return player;
    }
    static void tick(Player player) { ((ServerPlayer) player).doTick(); }
    static void close(Player player) {
        var serverPlayer = (ServerPlayer) player;
        try {
            serverPlayer.getLevel().getServer().getPlayerList().remove(serverPlayer);
        } finally {
            serverPlayer.discard();
        }
    }
    private TickAccess() {}
}
