package net.kenddie.fantasyarmor.config;

import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;
import net.kenddie.fantasyarmor.shared.ModConstants;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import java.nio.charset.StandardCharsets;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID)
public final class ConfigSync {
    private static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(ModConstants.MOD_ID);
    private static final Gson GSON = new Gson();
    public static void register() { NETWORK.registerMessage(Handler.class, Packet.class, 0, Side.CLIENT); }

    @SubscribeEvent
    public static void login(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.player instanceof EntityPlayerMP) NETWORK.sendTo(new Packet(FAConfig.localSettings()), (EntityPlayerMP) event.player);
    }

    @SubscribeEvent
    public static void disconnected(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        FMLCommonHandler.instance().getWorldThread(event.getHandler()).addScheduledTask(FAConfig::restoreLocalSettings);
    }

    public static final class Packet implements IMessage {
        private FAConfig.Settings settings;
        public Packet() {}
        Packet(FAConfig.Settings settings) { this.settings = settings; }
        @Override public void fromBytes(ByteBuf buffer) { settings = GSON.fromJson(new String(new PacketBuffer(buffer).readByteArray(), StandardCharsets.UTF_8), FAConfig.Settings.class); }
        @Override public void toBytes(ByteBuf buffer) { new PacketBuffer(buffer).writeByteArray(GSON.toJson(settings).getBytes(StandardCharsets.UTF_8)); }
    }

    public static final class Handler implements IMessageHandler<Packet, IMessage> {
        @Override public IMessage onMessage(Packet packet, MessageContext context) {
            FMLCommonHandler.instance().getWorldThread(context.netHandler).addScheduledTask(() -> FAConfig.applyServerSettings(packet.settings));
            return null;
        }
    }
    private ConfigSync() {}
}
