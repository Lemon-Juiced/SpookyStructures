package dev.lemonjuice.spooky_structures.item.custom;

import dev.lemonjuice.spooky_structures.SpookyStructures;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class SilverSmithingTemplateItem extends SmithingTemplateItem {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    private static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.parse("item/empty_slot_hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.parse("item/empty_slot_axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.parse("item/empty_slot_sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.parse("item/empty_slot_shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.parse("item/empty_slot_pickaxe");

    private static final ResourceLocation EMPTY_SLOT_BLOCK = SpookyStructures.makeID("item/empty_slot_block");

    private static final Component APPLIES_TO = Component.translatable("tooltip.spooky_structures.applies_to").withStyle(DESCRIPTION_FORMAT);
    private static final Component INGREDIENTS = Component.translatable("tooltip.spooky_structures.ingredients").withStyle(DESCRIPTION_FORMAT);
    private static final Component UPGRADE_DESCRIPTION = Component.translatable("tooltip.spooky_structures.upgrade_description").withStyle(TITLE_FORMAT);
    private static final Component BASE_SLOT_DESCRIPTION = Component.translatable("tooltip.spooky_structures.base_slot_description");
    private static final Component ADDITIONS_SLOT_DESCRIPTION = Component.translatable("tooltip.spooky_structures.additions_slot_description");

    private static final List<ResourceLocation> BASE_SLOT_EMPTY_ICONS = List.of(EMPTY_SLOT_SWORD, EMPTY_SLOT_PICKAXE, EMPTY_SLOT_AXE, EMPTY_SLOT_HOE, EMPTY_SLOT_SHOVEL);
    private static final List<ResourceLocation> ADDITIONAL_SLOT_EMPTY_ICONS = List.of(EMPTY_SLOT_BLOCK);

    public SilverSmithingTemplateItem() {
        super(APPLIES_TO, INGREDIENTS, UPGRADE_DESCRIPTION, BASE_SLOT_DESCRIPTION, ADDITIONS_SLOT_DESCRIPTION, BASE_SLOT_EMPTY_ICONS, ADDITIONAL_SLOT_EMPTY_ICONS);
    }
}
