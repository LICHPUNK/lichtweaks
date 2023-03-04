package net.lichpunk.lichtweaks.datagen;

import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.block.ModBlocks;
import net.lichpunk.lichtweaks.block.custom.BelladonnaCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LichTweaks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        /* ========== ITEMS ========== */
        blockWithItem(ModBlocks.MOON_SHARD_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MOON_SHARD_ORE);
        blockWithItem(ModBlocks.NETHERRACK_MOON_SHARD_ORE);
        blockWithItem(ModBlocks.END_STONE_MOON_SHARD_ORE);
        blockWithItem(ModBlocks.PURIFIED_MOON_BLOCK);
        blockWithItem(ModBlocks.JUMP_BLOCK);


        /* ========== NATURAL BLOCKS ========== */

        // Necrotic Tree - Related Blocks
        logBlock(((RotatedPillarBlock) ModBlocks.NECROTIC_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.NECROTIC_WOOD.get(), blockTexture(ModBlocks.NECROTIC_LOG.get()), blockTexture(ModBlocks.NECROTIC_LOG.get()));

        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_NECROTIC_LOG.get(), new ResourceLocation(LichTweaks.MOD_ID, "block/stripped_necrotic_log"),
                new ResourceLocation(LichTweaks.MOD_ID, "block/stripped_necrotic_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_NECROTIC_WOOD.get(), new ResourceLocation(LichTweaks.MOD_ID, "block/stripped_necrotic_log"),
                new ResourceLocation(LichTweaks.MOD_ID, "block/stripped_necrotic_log"));

        blockWithItem(ModBlocks.NECROTIC_LEAVES);
        blockWithItem(ModBlocks.NECROTIC_PLANKS);
        saplingBlock(ModBlocks.NECROTIC_SAPLING);

        simpleBlockItem(ModBlocks.NECROTIC_LOG.get(), models().withExistingParent("lichtweaks:necrotic_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.NECROTIC_WOOD.get(), models().withExistingParent("lichtweaks:necrotic_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_NECROTIC_LOG.get(), models().withExistingParent("lichtweaks:stripped_necrotic_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_NECROTIC_WOOD.get(), models().withExistingParent("lichtweaks:stripped_necrotic_wood", "minecraft:block/cube_column"));


        // Spectral Tree - Related Blocks
        logBlock(((RotatedPillarBlock) ModBlocks.SPECTRAL_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.SPECTRAL_WOOD.get(), blockTexture(ModBlocks.SPECTRAL_LOG.get()), blockTexture(ModBlocks.SPECTRAL_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_SPECTRAL_LOG.get(), new ResourceLocation(LichTweaks.MOD_ID, "block/stripped_spectral_log"),
                new ResourceLocation(LichTweaks.MOD_ID, "block/stripped_spectral_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_SPECTRAL_WOOD.get(), new ResourceLocation(LichTweaks.MOD_ID, "block/stripped_spectral_log"),
                new ResourceLocation(LichTweaks.MOD_ID, "block/stripped_spectral_log"));

        blockWithItem(ModBlocks.SPECTRAL_LEAVES);
        blockWithItem(ModBlocks.SPECTRAL_PLANKS);
        saplingBlock(ModBlocks.SPECTRAL_SAPLING);

        simpleBlockItem(ModBlocks.SPECTRAL_LOG.get(), models().withExistingParent("lichtweaks:spectral_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.SPECTRAL_WOOD.get(), models().withExistingParent("lichtweaks:spectral_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_SPECTRAL_LOG.get(), models().withExistingParent("lichtweaks:stripped_spectral_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_SPECTRAL_WOOD.get(), models().withExistingParent("lichtweaks:stripped_spectral_wood", "minecraft:block/cube_column"));


        /* ========== CROP BLOCKS ========== */

        makeCrop((BelladonnaCropBlock)ModBlocks.BELLADONNA_CROP.get(), "belladonna_stage", "belladonna_stage");

        // buttonBlock((ButtonBlock)ModBlocks.BUTTON_NAME.get(), blockTexture(ModBlocks.BLOCK_FOR_TEXTURE.get()));

        // pressurePlateBlock((PressurePlateBlock)ModBlocks.PLATE_NAME.get(), blockTexture(ModBlocks.BLOCK_FOR_TEXTURE.get()));

        // wallBlock((WallBlock) ModBlocks.WALL_NAME.get(), blockTexture(ModBlocks.BLOCK_FOR_TEXTURE.get()));

        // fenceBlock((FenceBlock) ModBlocks.FENCE_NAME.get(), blockTexture(ModBlocks.BLOCK_FOR_TEXTURE.get()));

        // fenceGateBlock((FenceGateBlock)ModBlocks.GATE_NAME.get(), blockTexture(ModBlocks.BLOCK_FOR_TEXTURE.get()));

        // slabBlock((SlabBlock) ModBlocks.SLAB_NAME.get(), blockTexture(ModBlocks.BLOCK_FOR_TEXTURE.get()), blockTexture(ModBlocks.BLOCK_FOR_TEXTURE.get()));

        // stairsBlock((StairBlock) ModBlocks.STAIR_NAME.get(), blockTexture(ModBlocks.BLOCK_FOR_TEXTURE.get()));

        // doorBlock((DoorBlock) ModBlocks.DOOR_NAME.get(), new ResourceLocation(LichTweaks.MOD_ID, "block/DOOR_NAME_bottom"),
        //        new ResourceLocation(LichTweaks.MOD_ID, "block/DOOR_NAME_top"));

        // trapdoorBlock((TrapDoorBlock)ModBlocks.TRAPDOOR_NAME.get(), blockTexture(ModBlocks.TRAPDOOR_TEXTURE.get()), true);

        // logBlock((RotatedPillarBlock)ModBlocks.LOG_NAME.get());
        // axisBlock((RotatedPillarBlock)ModBlocks.WOOD_NAME.get(), blockTexture(ModBlocks.LOG_NAME.get()), blockTexture(ModBlocks.LOG_NAME.get()));
        // axisBlock((RotatedPillarBlock)ModBlocks.STRIPPED_LOG_NAME.get(), new ResourceLocation(LichTweaks.MOD_ID, "block/STRIPPED_LOG_NAME_bottom"),
        //        new ResourceLocation(LichTweaks.MOD_ID, "block/STRIPPED_LOG_NAME_top"));
        // axisBlock((RotatedPillarBlock)ModBlocks.STRIPPED_WOOD_NAME.get(), new ResourceLocation(LichTweaks.MOD_ID, "block/STRIPPED_LOG_NAME_bottom"),
        //        new ResourceLocation(LichTweaks.MOD_ID, "block/STRIPPED_LOG_NAME_TOP"));

        //signBlock((StandingSignBlock)ModBlocks.SIGN_NAME.get(), (WallSignBlock)ModBlocks.WALL_SIGN_NAME.get(),
        //        blockTexture(ModBlocks.PLANK_NAME.get()));

        //simpleBlock(ModBlocks.FLOWER_NAME.get(), models().cross(ModBlocks.FLOWER_NAME.get().getRegistryName().getPath(),
        //        blockTexture(ModBlocks.FLOWER_NAME.get())));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    /*
    public ModelFile flowerPotCross(String name) {
        return models().withExistingParent(name, flower_pot_cross);
    }
    */


    // TODO: add crop generation parameter for cut-out, currently entered manually
    // if not entered manually textures currently render black instead of transparent
    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(block.getAgeProperty()),
                new ResourceLocation(LichTweaks.MOD_ID, "block/" + textureName + state.getValue(block.getAgeProperty()))));

        return models;
    }



}
