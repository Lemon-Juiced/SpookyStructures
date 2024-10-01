package dev.lemonjuice.spooky_structures.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

import static dev.lemonjuice.scalar_core.category.Category.isUndeadEntity;

public class SilveredSwordItem extends SwordItem {

    public SilveredSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (isUndeadEntity(target)) target.setHealth(target.getHealth() - 3.0F);
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        Component component = Component.translatable("tooltip.spooky_structures.silvered_sword").withStyle(ChatFormatting.GRAY);
        tooltipComponents.add(component);
    }

}