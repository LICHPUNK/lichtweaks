package net.lichpunk.lichtweaks.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MemoryGlobeItem extends Item {

    private static final String PROMPT_TOOLTIP = "prompt.lichtweaks.tooltip";
    private static final String MESSAGE_ROLL = "message.lichtweaks.roll";
    private static final String DESCRIPTION_MEMORY_GLOBE = "description.lichtweaks.memory_globe";

    public MemoryGlobeItem(Properties properties) {

        super(properties);
    }

    // Method for text response on right-click with cooldown
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
        // Output random number given the player who initiated the interaction
            outputRandomNumber(player);
        // Set cooldown to X ticks (20 ticks per 1 second)
            player.getCooldowns().addCooldown(this, 20);
    }

        return super.use(level, player, hand);
    }

    // Method for tooltip(s)

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {


        // If the player is holding the 'Shift' key...
        if(Screen.hasShiftDown()) {
            // Reveal the tooltip
            components.add(Component.translatable(DESCRIPTION_MEMORY_GLOBE).withStyle());
        } else {
            // Otherwise, display the tooltip prompt translatable in the color YELLOW
            components.add(Component.translatable(PROMPT_TOOLTIP).withStyle(ChatFormatting.YELLOW));
        }
        super.appendHoverText(itemStack, level, components, flag);
    }

    private void outputRandomNumber(Player player) {
        player.sendSystemMessage(Component.translatable(MESSAGE_ROLL + getRandomNumber()).withStyle());
    }
    // Random number generation method
    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}
