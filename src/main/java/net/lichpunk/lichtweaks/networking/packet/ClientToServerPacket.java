package net.lichpunk.lichtweaks.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ClientToServerPacket {
    public ClientToServerPacket() {

    }

    // These buffers are only used if additional data is being sent from Client to Server
    public ClientToServerPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // Events on the Server
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            EntityType.ZOMBIE.spawn(level, null, (Player) null, player.blockPosition(), MobSpawnType.COMMAND, true, false);

        });
        return true;
    }
}
