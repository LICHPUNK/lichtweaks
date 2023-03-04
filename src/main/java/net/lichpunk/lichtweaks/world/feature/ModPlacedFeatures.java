package net.lichpunk.lichtweaks.world.feature;

import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

// Gets passed to ModWorldGenProvider class for data generation
public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MOON_SHARD_ORE_PLACED_KEY = createKey("moon_shard_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_MOON_SHARD_ORE_PLACED_KEY = createKey("nether_moon_shard_ore_placed");
    public static final ResourceKey<PlacedFeature> END_MOON_SHARD_ORE_PLACED_KEY = createKey("end_moon_shard_ore_placed");
    public static final ResourceKey<PlacedFeature> NECROTIC_PLACED_KEY = createKey("necrotic_placed");
    public static final ResourceKey<PlacedFeature> SPECTRAL_PLACED_KEY = createKey("spectral_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NECROTIC_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NECROTIC_KEY),
                // Place 3 trees, with a 10% float chance of placing 2 extra
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), ModBlocks.NECROTIC_SAPLING.get()));
        register(context, SPECTRAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPECTRAL_KEY),
                // Place 3 trees, with a 10% float chance of placing 2 extra
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), ModBlocks.SPECTRAL_SAPLING.get()));


        register(context, MOON_SHARD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MOON_SHARD_ORE_KEY),
                commonOrePlacement(12, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, NETHER_MOON_SHARD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_MOON_SHARD_ORE_KEY),
                commonOrePlacement(12, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, END_MOON_SHARD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_MOON_SHARD_ORE_KEY),
                commonOrePlacement(12, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

    }



    // HELPER METHODS
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(LichTweaks.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
