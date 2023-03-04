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
import net.minecraft.world.item.Items;
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
        // Moon Shard to Purified Moon Shard
        oreSmelting(consumer, List.of(ModItems.MOON_SHARD.get()), RecipeCategory.MISC,
                ModItems.PURIFIED_MOON_SHARD.get(), 0.7f, 200, "purified_moon_shard");
        // Moon Shard to Purified Moon Shard
        oreBlasting(consumer, List.of(ModItems.MOON_SHARD.get()), RecipeCategory.MISC,
                ModItems.PURIFIED_MOON_SHARD.get(), 0.7f, 200, "purified_moon_shard");
        // Purified Moon Shard to Purified Moon Block
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.PURIFIED_MOON_SHARD.get(), RecipeCategory.MISC,
                ModBlocks.PURIFIED_MOON_BLOCK.get());
        // Belladonna to Bellladonna Seeds
        modShapelessBuilder(consumer, List.of(ModItems.BELLADONNA.get()),
                ModItems.BELLADONNA_SEEDS.get(), 4, "belladonna_seeds");

        // Necrotic Log to Planks
        modShapelessBuilder(consumer, List.of(ModBlocks.NECROTIC_LOG.get()),
                ModBlocks.NECROTIC_PLANKS.get(), 4, "necrotic_planks");
        // Necrotic Wood to Planks
        modShapelessBuilder(consumer, List.of(ModBlocks.NECROTIC_WOOD.get()),
                ModBlocks.NECROTIC_PLANKS.get(), 4, "necrotic_planks");
        // Stripped Necrotic Log to Planks
        modShapelessBuilder(consumer, List.of(ModBlocks.STRIPPED_NECROTIC_LOG.get()),
                ModBlocks.NECROTIC_PLANKS.get(), 4, "necrotic_planks");
        // Stripped Necrotic Wood to Planks
        modShapelessBuilder(consumer, List.of(ModBlocks.STRIPPED_NECROTIC_WOOD.get()),
                ModBlocks.NECROTIC_PLANKS.get(), 4, "necrotic_planks");
        // Necrotic Log to Wood
        woodFromLogs(consumer, ModBlocks.NECROTIC_WOOD.get(),
                ModBlocks.NECROTIC_LOG.get());
        // Necrotic Planks to Sticks
        mod1x2Builder(consumer, List.of(ModBlocks.NECROTIC_PLANKS.get()),
                Items.STICK, 4, "stick");

        // Necrotic Log to Charcoal
        oreSmelting(consumer, List.of(ModBlocks.NECROTIC_LOG.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.5f, 200, "charcoal");
        // Necrotic Wood to Charcoal
        oreSmelting(consumer, List.of(ModBlocks.NECROTIC_WOOD.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.5f, 200, "charcoal");

        // Spectral Log to Planks
        modShapelessBuilder(consumer, List.of(ModBlocks.SPECTRAL_LOG.get()),
                ModBlocks.SPECTRAL_PLANKS.get(), 4, "spectral_planks");
        // Spectral Wood to Planks
        modShapelessBuilder(consumer, List.of(ModBlocks.SPECTRAL_WOOD.get()),
                ModBlocks.SPECTRAL_PLANKS.get(), 4, "spectral_planks");
        // Stripped Spectral Log to Planks
        modShapelessBuilder(consumer, List.of(ModBlocks.STRIPPED_SPECTRAL_LOG.get()),
                ModBlocks.SPECTRAL_PLANKS.get(), 4, "necrotic_planks");
        // Stripped Spectral Wood to Planks
        modShapelessBuilder(consumer, List.of(ModBlocks.STRIPPED_SPECTRAL_WOOD.get()),
                ModBlocks.SPECTRAL_PLANKS.get(), 4, "necrotic_planks");
        // Spectral Log to Wood
        woodFromLogs(consumer, ModBlocks.SPECTRAL_WOOD.get(),
                ModBlocks.SPECTRAL_LOG.get());
        // Spectral Log to Charcoal
        oreSmelting(consumer, List.of(ModBlocks.SPECTRAL_LOG.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.5f, 200, "charcoal");
        // Spectral Wood to Charcoal
        oreSmelting(consumer, List.of(ModBlocks.SPECTRAL_WOOD.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.5f, 200, "charcoal");
        // Spectral Planks to Sticks
        mod1x2Builder(consumer, List.of(ModBlocks.SPECTRAL_PLANKS.get()),
                Items.STICK, 4, "stick");


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


    // Shapeless Recipes Method
    protected static void modShapelessBuilder(Consumer<FinishedRecipe> consumer, List<ItemLike> list, ItemLike like, int received, String name) {
        for(ItemLike itemLike : list) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, like, received)
                    .requires(itemLike).group(name)
                    .unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(consumer, new ResourceLocation(LichTweaks.MOD_ID, getItemName(like)) + "_from_" + getItemName(itemLike));
        }

    }

    protected static void mod2x2Builder(Consumer<FinishedRecipe> consumer, List<ItemLike> list, ItemLike like, int received, String name) {
        for (ItemLike itemLike : list) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, like, received)
                    .define('#', itemLike)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(consumer, new ResourceLocation(LichTweaks.MOD_ID, getItemName(like)) + "_from_" + getItemName(itemLike));
        }
    }
    protected static void mod1x2Builder(Consumer<FinishedRecipe> consumer, List<ItemLike> list, ItemLike like, int received, String name) {
        for (ItemLike itemLike : list) {
            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, like, received)
                    .define('#', itemLike)
                    .pattern("#")
                    .pattern("#")
                    .unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(consumer, new ResourceLocation(LichTweaks.MOD_ID, getItemName(like)) + "_from_" + getItemName(itemLike));
        }
    }

    // Furnace Recipes Method
    protected static void oreSmelting(Consumer<FinishedRecipe> consumer, List<ItemLike> list, RecipeCategory category, ItemLike like, float experience, int cooktime, String name) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, list, category, like, experience, cooktime, name, "_from_smelting");
    }

    // Blast Furnace Recipes Method
    protected static void oreBlasting(Consumer<FinishedRecipe> consumer, List<ItemLike> list, RecipeCategory category, ItemLike like, float experience, int cooktime, String name) {
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, list, category, like, experience, cooktime, name, "_from_blasting");
    }

    // Smoker Recipes Method
    protected static void oreCooking(Consumer<FinishedRecipe> consumer, RecipeSerializer<? extends AbstractCookingRecipe> serializer, List<ItemLike> list, RecipeCategory category, ItemLike like, float experience, int cooktime, String name, String appendage) {
        for(ItemLike itemlike : list) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, like, experience, cooktime, serializer).group(name)
                    .unlockedBy(getHasName(itemlike), has(itemlike)).save(consumer, new ResourceLocation(LichTweaks.MOD_ID, getItemName(like)) + appendage + "_" + getItemName(itemlike));
        }
    }

    // 9 to 1 Recipes Method
    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike like, RecipeCategory category1, ItemLike like1) {
        nineBlockStorageRecipes(consumer, category, like, category1, like1, getSimpleRecipeName(like1), (String)null, getSimpleRecipeName(like), (String)null);
    }

    protected static void nineBlockStorageRecipes(
            Consumer<FinishedRecipe> consumer, RecipeCategory category, ItemLike like, RecipeCategory category1,
            ItemLike like1, String string, @Nullable String string2, String string3, @Nullable String string4) {

        ShapelessRecipeBuilder.shapeless(category, like, 9).requires(like1).group(string4).unlockedBy(getHasName(like1), has(like1))
                .save(consumer, new ResourceLocation(LichTweaks.MOD_ID, string3));

        ShapedRecipeBuilder.shaped(category1, like1).define('#', like).pattern("###").pattern("###").pattern("###").group(string2)
                .unlockedBy(getHasName(like), has(like)).save(consumer, new ResourceLocation(LichTweaks.MOD_ID, string));
    }



    // Crop Recipes Method (Unused)
    protected static void SeedsFromSeedCrop(Consumer<FinishedRecipe> consumer, ItemLike like, TagKey< Item > tagKey, int amount) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BELLADONNA_SEEDS.get())
                .requires(ModItems.BELLADONNA.get())
                .unlockedBy("has_belladonna", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.BELLADONNA.get()).build()))
                .save(consumer);
    }

    protected static void planksFromLog(Consumer<FinishedRecipe> consumer, ItemLike like, TagKey<Item> key, int amount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, like, amount).requires(key).group("planks").unlockedBy("has_log", has(key)).save(consumer);
    }

    protected static void planksFromLogs(Consumer<FinishedRecipe> consumer, ItemLike like, TagKey<Item> key, int amount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, like, amount).requires(key).group("planks").unlockedBy("has_logs", has(key)).save(consumer);
    }

    protected static void woodFromLogs(Consumer<FinishedRecipe> consumer, ItemLike like, ItemLike like1) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, like, 3).define('#', like1).pattern("##").pattern("##").group("bark").unlockedBy("has_log", has(like1)).save(consumer, new ResourceLocation(LichTweaks.MOD_ID, getItemName(like)) + "_from_" + getItemName(like1));
    }

}
