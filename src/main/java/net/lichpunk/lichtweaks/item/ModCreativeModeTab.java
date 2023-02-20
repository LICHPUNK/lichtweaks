package net.lichpunk.lichtweaks.item;

import net.lichpunk.lichtweaks.LichTweaks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

    @Mod.EventBusSubscriber(modid = LichTweaks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)

    public class ModCreativeModeTab {
        public static CreativeModeTab LICH_TAB;

        @SubscribeEvent
        public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
            LICH_TAB = event.registerCreativeModeTab(new ResourceLocation(LichTweaks.MOD_ID, "lich_tab"),
                    builder -> builder.icon(() -> new ItemStack(ModItems.PURIFIED_MOON_ESSENCE.get())).title(Component.literal("LichTweaks Tab")).build());
        }
    }
