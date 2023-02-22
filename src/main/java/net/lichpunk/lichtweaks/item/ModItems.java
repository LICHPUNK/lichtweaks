package net.lichpunk.lichtweaks.item;

import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.block.ModBlocks;
import net.lichpunk.lichtweaks.item.custom.MemoryGlobeItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LichTweaks.MOD_ID);

    /* CUSTOM ITEMS */

    // Creating RegistryObject for "moon_shard" item
    public static final RegistryObject<Item> MOON_SHARD = ITEMS.register("moon_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PURIFIED_MOON_SHARD = ITEMS.register("purified_moon_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MEMORY_GLOBE = ITEMS.register("memory_globe",
            // Setting MemoryGlobeItem properties to max of 1 per stack
            () -> new MemoryGlobeItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BELLADONNA_SEEDS = ITEMS.register("belladonna_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BELLADONNA_CROP.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> BELLADONNA = ITEMS.register("belladonna",
            () -> new Item(new Item.Properties()
                    // Setting the nutrition and saturation modifiers of the Belladonna food item
                    // Refills 1 bar of hunger in-game & applies POISON mob effect
                    // MobEffectInstance is given the effect parameters and a probability to occur (0.0F being never occurring)
                    // MobEffects method is given type, duration, & amplifier (0 being level 1)
                    .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).effect(() -> new MobEffectInstance(MobEffects.POISON, 100, 0), 0.7F).build())));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
