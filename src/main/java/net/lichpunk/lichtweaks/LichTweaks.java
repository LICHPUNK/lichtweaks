package net.lichpunk.lichtweaks;

import com.mojang.logging.LogUtils;
import net.lichpunk.lichtweaks.item.ModCreativeModeTab;
import net.lichpunk.lichtweaks.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LichTweaks.MOD_ID)
public class LichTweaks {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "lichtweaks";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public LichTweaks() {
        // Creating IEventBus object for loading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // Registering all the ModItems into designated modEventBus
        ModItems.register(modEventBus);

        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);
        // Register the addCreative method for supplying creative tabs
        modEventBus.addListener(this::addCreative);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {

        // Add items to custom LichTweaks creative mode tab
        if(event.getTab() == ModCreativeModeTab.LICH_TAB) {
            // SAMPLE ITEMS
            event.accept(ModItems.ZIRCON);
            event.accept(ModItems.RAW_ZIRCON);
            // CUSTOM ITEMS
            event.accept(ModItems.MOON_SHARD);
            event.accept(ModItems.PURIFIED_MOON_ESSENCE);
        }

        // Add items to existing INGREDIENTS creative mode tab
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_ZIRCON);
            event.accept(ModItems.ZIRCON);
            event.accept(ModItems.MOON_SHARD);
            event.accept(ModItems.PURIFIED_MOON_ESSENCE);
        }

        // Add items to existing FOOD_AND_DRINKS creative mode tab
        if(event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
        }

        // Add items to existing   creative mode tab
        if(event.getTab() == CreativeModeTabs.SEARCH) {
            event.accept(ModItems.RAW_ZIRCON);
            event.accept(ModItems.ZIRCON);
            event.accept(ModItems.MOON_SHARD);
            event.accept(ModItems.PURIFIED_MOON_ESSENCE);
        }
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
