package net.lichpunk.lichtweaks.datagen;

import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.block.ModBlocks;
import net.lichpunk.lichtweaks.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LichTweaks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.MOON_SHARD);
        simpleItem(ModItems.PURIFIED_MOON_SHARD);
        handheldItem(ModItems.MEMORY_GLOBE);

        simpleItem(ModItems.BELLADONNA_SEEDS);
        simpleItem(ModItems.BELLADONNA);

        saplingItem(ModBlocks.NECROTIC_SAPLING);
        saplingItem(ModBlocks.SPECTRAL_SAPLING);

        generatedItem(ModItems.MANA_WATER_BUCKET);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LichTweaks.MOD_ID, "item/" + item.getId().getPath()));

    }    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LichTweaks.MOD_ID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(LichTweaks.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder generatedItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LichTweaks.MOD_ID, "item/" + item.getId().getPath()));
    }

}
