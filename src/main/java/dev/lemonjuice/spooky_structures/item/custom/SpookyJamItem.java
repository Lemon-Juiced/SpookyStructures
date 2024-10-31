package dev.lemonjuice.spooky_structures.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.List;
import java.util.Random;

public class SpookyJamItem extends Item {
    private static final int DRINK_DURATION = 32;

    public SpookyJamItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entityLiving) {
        Player player = entityLiving instanceof Player ? (Player) entityLiving : null;
        if (player instanceof ServerPlayer) {
            player.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!level.isClientSide) {
            FoodData foodData = player.getFoodData();
            foodData.eat(20, 1.0F); // Fill the hunger bar completely

            // Also the player has an 80% chance to get a random negative effect
            Random random = new Random();
            if (random.nextInt(100) < 80) {
                // Determine the strength of the effect (1-5) the higher the level the more rare the effect
                // 1 = 50%, 2 = 30%, 3 = 15%, 4 = 4%, 5 = 1%
                int effectLevel = 0;
                int effectChance = random.nextInt(100);
                if (effectChance < 50) effectLevel = 1;
                else if (effectChance < 80) effectLevel = 2;
                else if (effectChance < 95) effectLevel = 3;
                else if (effectChance < 99) effectLevel = 4;
                else effectLevel = 5;

                // Determine the effect
                // 0 = poison, 1 = wither, 2 = blindness, 3 = weakness, 4 = mining fatigue, 5 = slowness
                int effectType = random.nextInt(6);
                switch (effectType) {
                    case 0:
                        player.addEffect(new MobEffectInstance(MobEffects.POISON, 20 * 10 * effectLevel, effectLevel - 1));
                        break;
                    case 1:
                        player.addEffect(new MobEffectInstance(MobEffects.WITHER, 20 * 10 * effectLevel, effectLevel - 1));
                        break;
                    case 2:
                        player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20 * 10 * effectLevel, effectLevel - 1));
                        break;
                    case 3:
                        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 20 * 10 * effectLevel, effectLevel - 1));
                        break;
                    case 4:
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 20 * 10 * effectLevel, effectLevel - 1));
                        break;
                    case 5:
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * 10 * effectLevel, effectLevel - 1));
                        break;
                }
            }
        }

        if (player != null) {
            stack.shrink(1);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 1.0F, 1.0F);
        player.gameEvent(GameEvent.EAT);
        return stack.isEmpty() ? ItemStack.EMPTY : stack;
    }

    public int getUseDuration(ItemStack stack) {
        return DRINK_DURATION;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.EAT;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.spooky_structures.spooky_jam"));
    }
}