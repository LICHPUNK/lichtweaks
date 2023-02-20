package net.lichpunk.lichtweaks.item;

import net.lichpunk.lichtweaks.LichTweaks;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LichTweaks.MOD_ID);

    /* SAMPLE ITEMS */

    // Creating RegistryObject for "zircon" item
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties()));

    /* CUSTOM ITEMS */

    // Creating RegistryObject for "moon_shard" item
    public static final RegistryObject<Item> MOON_SHARD = ITEMS.register("moon_shard",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PURIFIED_MOON_SHARD = ITEMS.register("purified_moon_shard",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
