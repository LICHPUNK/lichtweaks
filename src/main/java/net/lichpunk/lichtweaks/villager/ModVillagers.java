package net.lichpunk.lichtweaks.villager;

import com.google.common.collect.ImmutableSet;
import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {

    // This will ignore any missing test items from the specified world
    @SubscribeEvent
    public void onMissing(final MissingMappingsEvent event) {
        event.getMappings(ForgeRegistries.Keys.ITEMS, LichTweaks.MOD_ID).stream()
                .filter(mapping -> mapping.getKey().getPath().contains("lichtweaks:wizard"))
                .forEach(MissingMappingsEvent.Mapping::ignore);
    }

    // Creating POI & Professions Forge objects
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, LichTweaks.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, LichTweaks.MOD_ID);

    // CUSTOM POIs

    // Jump Block
    public static final RegistryObject<PoiType> JUMP_BLOCK_POI = POI_TYPES.register("jump_block_poi",
            // Setting up the POI to available regardless of the POI blocks state
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.JUMP_BLOCK.get().getStateDefinition().getPossibleStates()),
            1, 1));


    // CUSTOM PROFESSIONS

    //  Wizard
    public static final RegistryObject<VillagerProfession> WIZARD = VILLAGER_PROFESSIONS.register ("wizard",
            () -> new VillagerProfession("wizard", x -> x.get() == JUMP_BLOCK_POI.get(),
                    x -> x.get() == JUMP_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CLERIC));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, JUMP_BLOCK_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }





    // Using event bus to register new POI & Profession objects
    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
