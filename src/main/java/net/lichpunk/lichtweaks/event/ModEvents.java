package net.lichpunk.lichtweaks.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.lichpunk.lichtweaks.LichTweaks;
import net.lichpunk.lichtweaks.item.ModItems;
import net.lichpunk.lichtweaks.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;

import java.util.List;

@Mod.EventBusSubscriber(modid = LichTweaks.MOD_ID)
public class ModEvents {


    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if(event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            // Setting what is received from the trade
            ItemStack stack = new ItemStack(ModItems.MOON_SHARD.get(), 12);
            int villagerLevel = 1;
            // Setting the price of the trade
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack, 10, 8, 0.02F));
        }


        if(event.getType() == ModVillagers.WIZARD.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModItems.MEMORY_GLOBE.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    // Setting max uses, experience, & price multiplier
                    stack, 10, 8, 0.02F));
        }
    }

}
