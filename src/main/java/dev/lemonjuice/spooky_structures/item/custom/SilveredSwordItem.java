package dev.lemonjuice.spooky_structures.item.custom;

import com.mojang.datafixers.util.Either;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SilveredSwordItem extends SwordItem {

    public SilveredSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (isUndeadEntity(target)) {
            target.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1));
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        Component component = Component.translatable("tooltip.spooky_structures.silvered_sword").withStyle(ChatFormatting.GRAY);
        tooltipComponents.add(component);
    }

    private boolean isUndeadEntity(LivingEntity entity) {
        return (entity instanceof Phantom
                || entity instanceof AbstractSkeleton // Bogged, Stray, Wither Skeleton
                || entity instanceof SkeletonHorse
                || entity instanceof WitherBoss
                || entity instanceof Zoglin
                || entity instanceof Zombie // Drowned, Husk, Zombie Villager, Zombified Piglin
                || entity instanceof ZombieHorse);
    }
}