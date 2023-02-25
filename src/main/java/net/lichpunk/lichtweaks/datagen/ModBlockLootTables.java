package net.lichpunk.lichtweaks.datagen;

import net.lichpunk.lichtweaks.block.ModBlocks;
import net.lichpunk.lichtweaks.block.custom.BelladonnaCropBlock;
import net.lichpunk.lichtweaks.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        LootItemCondition.Builder BELLADONNA_LOOT_CONDITION_BUILDER = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BELLADONNA_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 6));

        dropSelf(ModBlocks.PURIFIED_MOON_BLOCK.get());
        dropSelf(ModBlocks.JUMP_BLOCK.get());
        dropSelf(ModBlocks.SOUL_BEACON_BLOCK.get());

        add(ModBlocks.MOON_SHARD_ORE.get(),
                (block) -> createOreDrop(ModBlocks.MOON_SHARD_ORE.get(), ModItems.MOON_SHARD.get()));

        add(ModBlocks.DEEPSLATE_MOON_SHARD_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_MOON_SHARD_ORE.get(), ModItems.MOON_SHARD.get()));

        add(ModBlocks.NETHERRACK_MOON_SHARD_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHERRACK_MOON_SHARD_ORE.get(), ModItems.MOON_SHARD.get()));

        add(ModBlocks.END_STONE_MOON_SHARD_ORE.get(),
                (block) -> createOreDrop(ModBlocks.END_STONE_MOON_SHARD_ORE.get(), ModItems.MOON_SHARD.get()));
        add(ModBlocks.BELLADONNA_CROP.get(),
                (block) -> createCropDrops(ModBlocks.BELLADONNA_CROP.get(), ModItems.BELLADONNA_SEEDS.get(), ModItems.BELLADONNA.get(), BELLADONNA_LOOT_CONDITION_BUILDER));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
