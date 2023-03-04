package net.lichpunk.lichtweaks.networking;

import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.networking.packet.ClientToServerPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetID = 0;

    // Method for incrementing packet IDs
    private static int ID() {
        return packetID++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(LichTweaks.MOD_ID, "messages"))
                // Packet protocol
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(ClientToServerPacket.class, ID(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ClientToServerPacket::new)
                .encoder(ClientToServerPacket::toBytes)
                .consumerMainThread(ClientToServerPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
