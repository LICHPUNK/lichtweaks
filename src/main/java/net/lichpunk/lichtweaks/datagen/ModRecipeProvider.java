package net.lichpunk.lichtweaks.datagen;

import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.block.ModBlocks;
import net.lichpunk.lichtweaks.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, List.of(ModItems.MOON_SHARD.get()), RecipeCategory.MISC,
                ModItems.PURIFIED_MOON_SHARD.get(), 0.7f, 200, "purified_moon_shard");
        oreBlasting(consumer, List.of(ModItems.MOON_SHARD.get()), RecipeCategory.MISC,
                ModItems.PURIFIED_MOON_SHARD.get(), 0.7f, 200, "purified_moon_shard");

        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.PURIFIED_MOON_SHARD.get(), RecipeCategory.MISC,
                ModBlocks.PURIFIED_MOON_BLOCK.get());

        modShapelessBuilder(consumer, List.of(ModItems.BELLADONNA.get()),
                ModItems.BELLADONNA_SEEDS.get(), 4, "belladonna_seeds");


        // ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURIFIED_MOON_SHARD.get())
        //        .requires(ModBlocks.PURIFIED_MOON_BLOCK.get())
        //        .unlockedBy("has_purified_moon_block", inventoryTrigger(ItemPredicate.Builder.item()
        //                .of(ModBlocks.PURIFIED_MOON_BLOCK.get()).build()))
        //        .save(consumer);

        //ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PURIFIED_MOON_BLOCK.get())
        //        .define('B', ModItems.PURIFIED_MOON_SHARD.get())
        //        .pattern("BBB")
        //        .pattern("BBB")
        //        .pattern("BBB")
        //        .unlockedBy("has_purified_moon_shard", inventoryTrigger(ItemPredicate.Builder.item()
        //                .of(ModItems.PURIFIED_MOON_SHARD.get()).build()));
    }

    protected static void SeedsFromSeedCrop(Consumer<FinishedRecipe> consumer, ItemLike like, TagKey< Item > tagKey, int amount) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BELLADONNA_SEEDS.get())
                .requires(ModItems.BELLADONNA.get())
                .unlockedBy("has_belladonna", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.BELLADONNA.get()).build()))
                .save(consumer);
    }

    protected static void modShapelessBuilder(Consumer<FinishedRecipe> consumer, List<ItemLike> list, ItemLike like, int received, String name) {
        for(ItemLike itemLike : list) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, like, received)
                    .requires(itemLike).group(name)
                    .unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(consumer, new ResourceLocation(LichTweaks.MOD_ID, getItemName(like)) + "_from_" + getItemName(itemLike));
        }

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> consumer, List<ItemLike> list, RecipeCategory category, ItemLike like, float experience, int cooktime, String name) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, list, category, like, experience, cooktime, name, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> consumer, List<ItemLike> list, RecipeCategory category, ItemLike like, float experience, int cooktime, String name) {
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, list, category, like, experience, cooktime, name, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> consumer, RecipeSerializer<? extends AbstractCookingRecipe> serializer, List<ItemLike> list, RecipeCategory category, ItemLike like, float experience, int cooktime, String name, String appendage) {
        for(ItemLike itemlike : list) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, like, experience, cooktime, serializer).group(name)
                    .unlockedBy(getHasName(itemlike), has(itemlike)).save(consumer, new ResourceLocation(LichTweaks.MOD_ID, getItemName(like)) + appendage + "_" + getItemName(itemlike));
        }
    }



    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_,
                                                  RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_,
                                                  String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_))
                .save(p_250423_, new ResourceLocation(LichTweaks.MOD_ID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_)
                .unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(LichTweaks.MOD_ID, p_250475_));
    }

}
