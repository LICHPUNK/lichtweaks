package net.lichpunk.lichtweaks;

import com.mojang.logging.LogUtils;
import net.lichpunk.lichtweaks.block.ModBlocks;
import net.lichpunk.lichtweaks.fluid.ModFluidTypes;
import net.lichpunk.lichtweaks.fluid.ModFluids;
import net.lichpunk.lichtweaks.item.ModCreativeModeTab;
import net.lichpunk.lichtweaks.item.ModItems;
import net.lichpunk.lichtweaks.networking.ModMessages;
import net.lichpunk.lichtweaks.painting.ModPaintings;
import net.lichpunk.lichtweaks.villager.ModVillagers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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

        // IEventBus object for loading mod features
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // ModConfiguredFeatures
        //ModConfiguredFeatures.register(modEventBus);

        // ModPlacedFeatures
        //ModPlacedFeatures.register(modEventBus);

        // ModItems
        ModItems.register(modEventBus);

        // ModBlocks
        ModBlocks.register(modEventBus);

        // ModPaintings
        ModPaintings.register(modEventBus);

        // ModVillagers
        ModVillagers.register(modEventBus);

        // ModFluids
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);

        // Register the addCreative method for supplying creative tabs
        modEventBus.addListener(this::addCreative);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModMessages.register();
            ModVillagers.registerPOIs();
        });

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
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MANA_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MANA_WATER.get(), RenderType.translucent());
        }

    }


    private void addCreative(CreativeModeTabEvent.BuildContents event) {

        /* ===== CUSTOM TAB(S) ===== */

        // Add items to custom LichTweaks creative mode tab
        if(event.getTab() == ModCreativeModeTab.LICH_TAB) {

            // ITEMS
            event.accept(ModItems.MOON_SHARD);
            event.accept(ModItems.PURIFIED_MOON_SHARD);
            event.accept(ModItems.MEMORY_GLOBE);
            event.accept(ModItems.MANA_WATER_BUCKET);

            // WEAPONS
            event.accept(ModItems.MAGIC_SHIV);

            // BLOCKS
            event.accept(ModBlocks.PURIFIED_MOON_BLOCK);

            // CROPS
            event.accept(ModItems.BELLADONNA);
            event.accept(ModItems.BELLADONNA_SEEDS);

            // NATURAL BLOCKS
            event.accept(ModBlocks.NECROTIC_LOG);
            event.accept(ModBlocks.NECROTIC_WOOD);
            event.accept(ModBlocks.STRIPPED_NECROTIC_LOG);
            event.accept(ModBlocks.STRIPPED_NECROTIC_WOOD);
            event.accept(ModBlocks.NECROTIC_PLANKS);
            event.accept(ModBlocks.NECROTIC_LEAVES);
            event.accept(ModBlocks.NECROTIC_SAPLING);
            event.accept(ModBlocks.SPECTRAL_LOG);
            event.accept(ModBlocks.SPECTRAL_WOOD);
            event.accept(ModBlocks.STRIPPED_SPECTRAL_LOG);
            event.accept(ModBlocks.STRIPPED_SPECTRAL_WOOD);
            event.accept(ModBlocks.SPECTRAL_PLANKS);
            event.accept(ModBlocks.SPECTRAL_LEAVES);
            event.accept(ModBlocks.SPECTRAL_SAPLING);


            // ORE BLOCKS
            event.accept(ModBlocks.MOON_SHARD_ORE);
            event.accept(ModBlocks.DEEPSLATE_MOON_SHARD_ORE);
            event.accept(ModBlocks.NETHERRACK_MOON_SHARD_ORE);
            event.accept(ModBlocks.END_STONE_MOON_SHARD_ORE);

            // FUNCTIONAL BLOCKS
            event.accept(ModBlocks.JUMP_BLOCK);
            event.accept(ModBlocks.SOUL_BEACON_BLOCK);
        }

        /* ===== VANILLA TAB(S) ===== */

        // BUILDING_BLOCKS
        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.MOON_SHARD_ORE);
            event.accept(ModBlocks.DEEPSLATE_MOON_SHARD_ORE);
            event.accept(ModBlocks.NETHERRACK_MOON_SHARD_ORE);
            event.accept(ModBlocks.END_STONE_MOON_SHARD_ORE);
            event.accept(ModBlocks.PURIFIED_MOON_BLOCK);
        }

        // NATURAL BLOCKS
        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.NECROTIC_LOG);
            event.accept(ModBlocks.NECROTIC_WOOD);
            event.accept(ModBlocks.STRIPPED_NECROTIC_LOG);
            event.accept(ModBlocks.STRIPPED_NECROTIC_WOOD);
            event.accept(ModBlocks.NECROTIC_PLANKS);
            event.accept(ModBlocks.NECROTIC_LEAVES);
            event.accept(ModBlocks.NECROTIC_SAPLING);
            event.accept(ModBlocks.SPECTRAL_LOG);
            event.accept(ModBlocks.SPECTRAL_WOOD);
            event.accept(ModBlocks.STRIPPED_SPECTRAL_LOG);
            event.accept(ModBlocks.STRIPPED_SPECTRAL_WOOD);
            event.accept(ModBlocks.SPECTRAL_PLANKS);
            event.accept(ModBlocks.SPECTRAL_LEAVES);
            event.accept(ModBlocks.SPECTRAL_SAPLING);
        }

        // FUNCTIONAL
        if(event.getTab() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.JUMP_BLOCK);
            event.accept(ModBlocks.SOUL_BEACON_BLOCK);
        }

        // INGREDIENTS
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.MOON_SHARD);
            event.accept(ModItems.PURIFIED_MOON_SHARD);
            event.accept(ModItems.BELLADONNA_SEEDS);
        }


        // FOOD_AND_DRINKS
        if(event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.BELLADONNA);
        }

        // SEARCH
        if(event.getTab() == CreativeModeTabs.SEARCH) {
            event.accept(ModItems.MOON_SHARD);
            event.accept(ModItems.PURIFIED_MOON_SHARD);
            event.accept(ModItems.MEMORY_GLOBE);
            event.accept(ModItems.MANA_WATER_BUCKET);

            event.accept(ModItems.MAGIC_SHIV);

            event.accept(ModBlocks.PURIFIED_MOON_BLOCK);

            event.accept(ModItems.BELLADONNA_SEEDS);
            event.accept(ModItems.BELLADONNA);

            event.accept(ModBlocks.MOON_SHARD_ORE);
            event.accept(ModBlocks.DEEPSLATE_MOON_SHARD_ORE);
            event.accept(ModBlocks.NETHERRACK_MOON_SHARD_ORE);
            event.accept(ModBlocks.END_STONE_MOON_SHARD_ORE);

            event.accept(ModBlocks.JUMP_BLOCK);
            event.accept(ModBlocks.SOUL_BEACON_BLOCK);
        }
    }


}
