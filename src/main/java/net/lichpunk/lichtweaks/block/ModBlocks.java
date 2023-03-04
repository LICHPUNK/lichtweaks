package net.lichpunk.lichtweaks.block;

import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.block.custom.BelladonnaCropBlock;
import net.lichpunk.lichtweaks.block.custom.JumpBlock;
import net.lichpunk.lichtweaks.block.custom.SoulBeaconBlock;
import net.lichpunk.lichtweaks.fluid.ModFluids;
import net.lichpunk.lichtweaks.item.ModItems;
import net.lichpunk.lichtweaks.world.tree.NecroticTreeGrower;
import net.lichpunk.lichtweaks.world.tree.SpectralTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LichTweaks.MOD_ID);

    /* ========== BUILDING BLOCK SECTION ========== */

    // "Purified Moon Block"
    public static final RegistryObject<Block> PURIFIED_MOON_BLOCK = registerBlock("purified_moon_block",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()));


    /* ========== CROP BLOCK SECTION ========== */

    // "Belladonna"
    public static final RegistryObject<Block> BELLADONNA_CROP = BLOCKS.register("belladonna_crop",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new BelladonnaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    /* ========== TREE BLOCK SECTION ========== */

    // "Necrotic Log"
    public static final RegistryObject<Block> NECROTIC_LOG = registerBlock("necrotic_log",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(2f)));

    // "Necrotic Wood"
    public static final RegistryObject<Block> NECROTIC_WOOD = registerBlock("necrotic_wood",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(2f)));

    // "Stripped Necrotic Log"
    public static final RegistryObject<Block> STRIPPED_NECROTIC_LOG = registerBlock("stripped_necrotic_log",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(2f)));

    // "Stripped Necrotic Wood"
    public static final RegistryObject<Block> STRIPPED_NECROTIC_WOOD = registerBlock("stripped_necrotic_wood",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(2f)));

    // "Necrotic Planks"
    public static final RegistryObject<Block> NECROTIC_PLANKS = registerBlock("necrotic_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 6;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });

    // "Necrotic Leaves"
    public static final RegistryObject<Block> NECROTIC_LEAVES = registerBlock("necrotic_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(0.2f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    // "Necrotic Sapling"
    public static final RegistryObject<Block> NECROTIC_SAPLING = registerBlock("necrotic_sapling",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new SaplingBlock(new NecroticTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    // ========


    // "Spectral Log"
    public static final RegistryObject<Block> SPECTRAL_LOG = registerBlock("spectral_log",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(3f)));

    // "Spectral Wood"
    public static final RegistryObject<Block> SPECTRAL_WOOD = registerBlock("spectral_wood",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(3f)));

    // "Stripped Spectral Log"
    public static final RegistryObject<Block> STRIPPED_SPECTRAL_LOG = registerBlock("stripped_spectral_log",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(3f)));

    // "Stripped Spectral Wood"
    public static final RegistryObject<Block> STRIPPED_SPECTRAL_WOOD = registerBlock("stripped_spectral_wood",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(3f)));

    // "Spectral Planks"
    public static final RegistryObject<Block> SPECTRAL_PLANKS = registerBlock("spectral_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 6;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            });

    // "Spectral Leaves"
    public static final RegistryObject<Block> SPECTRAL_LEAVES = registerBlock("spectral_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(0.2f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });

    // "Spectral Sapling"
    public static final RegistryObject<Block> SPECTRAL_SAPLING = registerBlock("spectral_sapling",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new SaplingBlock(new SpectralTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    /* ========== ORE BLOCK SECTION ========== */

    // "Moon Shard Ore"
    public static final RegistryObject<Block> MOON_SHARD_ORE = registerBlock("moon_shard_ore",
            // Block type changed to DropExperienceBlock to enable XP drop on mine
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    // Setting the strength/durability of the block & requiring tool usage
                    .strength(6f).requiresCorrectToolForDrops(),
                    // Setting XP dropped at 3-7 & adding block to LICH_TAB
                    UniformInt.of(3, 7)));

    // "Deepslate Moon Shard Ore"
    public static final RegistryObject<Block> DEEPSLATE_MOON_SHARD_ORE = registerBlock("deepslate_moon_shard_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));

    // "Netherrack Moon Shard Ore"
    public static final RegistryObject<Block> NETHERRACK_MOON_SHARD_ORE = registerBlock("netherrack_moon_shard_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));

    // "End Stone Moon Shard Ore"
    public static final RegistryObject<Block> END_STONE_MOON_SHARD_ORE = registerBlock("end_stone_moon_shard_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));


    /* ===== FUNCTIONAL BLOCK SECTION ===== */

    // "Jump Block"
    public static final RegistryObject<Block> JUMP_BLOCK = registerBlock("jump_block",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new JumpBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()));

    // "Soul Beacon Block"
    public static final RegistryObject<Block> SOUL_BEACON_BLOCK = registerBlock("soul_beacon_block",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new SoulBeaconBlock(BlockBehaviour.Properties.of(Material.AMETHYST)
                    .strength(6f).requiresCorrectToolForDrops()
                    // If LIT property for SoulBeaconBlock is true light level is 15, otherwise it's 0
                    .lightLevel(state -> state.getValue(SoulBeaconBlock.LIT) ? 15 : 0)
            ));

    /* ========== FLUID BLOCK SECTION ========== */

    public static final RegistryObject<LiquidBlock> MANA_WATER_BLOCK = BLOCKS.register("mana_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MANA_WATER, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));








    // REGISTERING ALL BLOCKS BY PASSING (name, block, and tab) OF EACH
    // Enables block as an in-game block placed within the world.
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        // Registering each block with its provided parameters
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // ADDITIONALLY REGISTERING ALL BLOCKS AS ITEMS BY PASSING (name, block, and tab) & ADDING ITS TAB PROPERTY
    // Enables the block as an in-game item to be dropped, picked up, etc.
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    // Register Method to register all blocks
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}