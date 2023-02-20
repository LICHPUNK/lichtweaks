package net.lichpunk.lichtweaks.block;

import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LichTweaks.MOD_ID);

    // Creating the "Moon Shard Ore" block
    public static final RegistryObject<Block> MOON_SHARD_ORE = registerBlock("moon_shard_ore",
            // Block type changed to DropExperienceBlock to enable XP drop on mine
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    // Setting the strength/durability of the block & requiring tool usage
                    .strength(6f).requiresCorrectToolForDrops(),
                    // Setting XP dropped at 3-7 & adding block to LICH_TAB
                    UniformInt.of(3, 7)));

    // Creating the "Deepslate Moon Shard Ore" block
    public static final RegistryObject<Block> DEEPSLATE_MOON_SHARD_ORE = registerBlock("deepslate_moon_shard_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));

    // Creating the "Netherrack Moon Shard Ore" block
    public static final RegistryObject<Block> NETHERRACK_MOON_SHARD_ORE = registerBlock("netherrack_moon_shard_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));

    // Creating the "End Stone Moon Shard Ore" block
    public static final RegistryObject<Block> END_STONE_MOON_SHARD_ORE = registerBlock("end_stone_moon_shard_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));

    // Creating the "Purified Moon Block" block
    public static final RegistryObject<Block> PURIFIED_MOON_BLOCK = registerBlock("purified_moon_block",
            // Block type changed to just Block so no XP will be dropped from the block
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()));

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