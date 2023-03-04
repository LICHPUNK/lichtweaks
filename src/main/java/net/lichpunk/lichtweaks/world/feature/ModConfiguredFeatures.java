package net.lichpunk.lichtweaks.world.feature;


import com.google.common.base.Suppliers;
import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.block.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.function.Supplier;

// Gets passed to ModWorldGenProvider class for data generation
public class ModConfiguredFeatures {

    /* CUSTOM ORE KEYS */
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MOON_SHARD_ORE_KEY = registerKey("overworld_moon_shard_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_MOON_SHARD_ORE_KEY = registerKey("nether_moon_shard_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_MOON_SHARD_ORE_KEY = registerKey("end_moon_shard_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NECROTIC_KEY = registerKey("necrotic");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPECTRAL_KEY = registerKey("spectral");


    /* CUSTOM ORE GENERATION */

    // Overworld Moon Shard Ore
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MOON_SHARD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.MOON_SHARD_ORE.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_MOON_SHARD_ORE.get().defaultBlockState())
    ));

    // Nether Moon Shard Ore
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_MOON_SHARD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHERRACK_MOON_SHARD_ORE.get().defaultBlockState())
    ));

    // End Moon Shard Ore
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_MOON_SHARD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_STONE_MOON_SHARD_ORE.get().defaultBlockState())
    ));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, OVERWORLD_MOON_SHARD_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_MOON_SHARD_ORES.get(), 12));
        register(context, END_MOON_SHARD_ORE_KEY, Feature.ORE, new OreConfiguration(END_MOON_SHARD_ORES.get(), 12));
        register(context, NETHER_MOON_SHARD_ORE_KEY, Feature.ORE, new OreConfiguration(NETHER_MOON_SHARD_ORES.get(), 12));

        register(context, NECROTIC_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                // Designating the log type
                BlockStateProvider.simple(ModBlocks.NECROTIC_LOG.get()),
                // Trunk pattern to be used
                new StraightTrunkPlacer(5, 6, 3),
                // Designating leaves type
                BlockStateProvider.simple(ModBlocks.NECROTIC_LEAVES.get()),
                // Leaves pattern to be used
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                // Tree spawning
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, SPECTRAL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                // Designating the log type
                BlockStateProvider.simple(ModBlocks.SPECTRAL_LOG.get()),
                // Trunk pattern to be used
                new StraightTrunkPlacer(5, 6, 3),
                // Designating leaves type
                BlockStateProvider.simple(ModBlocks.SPECTRAL_LEAVES.get()),
                // Leaves pattern to be used
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                // Tree spawning
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }


    /* HELPER METHODS */
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(LichTweaks.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
            context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
