package dev.lemonjuice.spooky_structures.item.custom;

import dev.lemonjuice.scalar_core.item.ExtraDamageCategorySwordItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class SilveredSwordItem extends ExtraDamageCategorySwordItem {

    public SilveredSwordItem(Tier tier, Properties properties) {
        super(tier, properties, "undead", 3.0F);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        Component component = Component.translatable("tooltip.spooky_structures.silvered_sword").withStyle(ChatFormatting.GRAY);
        tooltipComponents.add(component);
    }

}