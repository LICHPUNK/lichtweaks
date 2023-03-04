package net.lichpunk.lichtweaks.event;

import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.networking.ModMessages;
import net.lichpunk.lichtweaks.networking.packet.ClientToServerPacket;
import net.lichpunk.lichtweaks.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = LichTweaks.MOD_ID, value = Dist.CLIENT)

    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.FUNCTION_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed custom keybind!"));
            }
            if(KeyBinding.C2S_KEY.consumeClick()) {
                ModMessages.sendToServer(new ClientToServerPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = LichTweaks.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.FUNCTION_KEY);
            event.register(KeyBinding.C2S_KEY);
        }
    }
}
