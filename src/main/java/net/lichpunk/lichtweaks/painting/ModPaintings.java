package net.lichpunk.lichtweaks.painting;

import net.lichpunk.lichtweaks.LichTweaks;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, LichTweaks.MOD_ID);

    public static final RegistryObject<PaintingVariant> ATROPA_BELLADONNA = PAINTING_VARIANTS.register("atropa_belladonna",
            () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> ELIXIRS = PAINTING_VARIANTS.register("elixirs",
            () -> new PaintingVariant(32, 32));

    public static final RegistryObject<PaintingVariant> MIDNIGHT = PAINTING_VARIANTS.register("midnight",
            () -> new PaintingVariant(32, 32));

    public static final RegistryObject<PaintingVariant> REINCARNATE = PAINTING_VARIANTS.register("reincarnate",
            () -> new PaintingVariant(48, 32));

    public static final RegistryObject<PaintingVariant> SACRIFICE = PAINTING_VARIANTS.register("sacrifice",
            () -> new PaintingVariant(16, 16));


    public static final RegistryObject<PaintingVariant> TOWER = PAINTING_VARIANTS.register("tower",
            () -> new PaintingVariant(16, 32));

    public static final RegistryObject<PaintingVariant> WANDERER = PAINTING_VARIANTS.register("wanderer",
            () -> new PaintingVariant(32, 32));

    public static final RegistryObject<PaintingVariant> WEEP = PAINTING_VARIANTS.register("weep",
            () -> new PaintingVariant(32, 32));



    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}
