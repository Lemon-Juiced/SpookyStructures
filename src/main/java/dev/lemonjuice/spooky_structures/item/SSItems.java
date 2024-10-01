package dev.lemonjuice.spooky_structures.item;

import dev.lemonjuice.spooky_structures.item.custom.SSTiers;
import dev.lemonjuice.spooky_structures.item.custom.SilverSmithingTemplateItem;
import dev.lemonjuice.spooky_structures.item.custom.SilveredSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static dev.lemonjuice.scalar_core.item.ToolItemPropFactory.getSwordItemProperties;
import static dev.lemonjuice.spooky_structures.SpookyStructures.MOD_ID;

public class SSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final Supplier<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> RAW_SILVER = ITEMS.register("raw_silver", () -> new Item(new Item.Properties()));
    public static final Supplier<SilverSmithingTemplateItem> SILVER_SMITHING_TEMPLATE = ITEMS.register("silver_smithing_template", () -> new SilverSmithingTemplateItem());

    // Silvered Swords
    public static final Supplier<Item> SILVERED_WOODEN_SWORD = ITEMS.register("silvered_wooden_sword", () -> new SilveredSwordItem(SSTiers.SILVER_WOOD_TIER, getSwordItemProperties(SSTiers.SILVER_WOOD_TIER)));
    public static final Supplier<Item> SILVERED_STONE_SWORD = ITEMS.register("silvered_stone_sword", () -> new SilveredSwordItem(SSTiers.SILVER_STONE_TIER, getSwordItemProperties(SSTiers.SILVER_STONE_TIER)));
    public static final Supplier<Item> SILVERED_IRON_SWORD = ITEMS.register("silvered_iron_sword", () -> new SilveredSwordItem(SSTiers.SILVER_IRON_TIER, getSwordItemProperties(SSTiers.SILVER_IRON_TIER)));
    public static final Supplier<Item> SILVERED_DIAMOND_SWORD = ITEMS.register("silvered_diamond_sword", () -> new SilveredSwordItem(SSTiers.SILVER_DIAMOND_TIER, getSwordItemProperties(SSTiers.SILVER_DIAMOND_TIER)));
    public static final Supplier<Item> SILVERED_GOLDEN_SWORD = ITEMS.register("silvered_golden_sword", () -> new SilveredSwordItem(SSTiers.SILVER_GOLD_TIER, getSwordItemProperties(SSTiers.SILVER_GOLD_TIER)));
    public static final Supplier<Item> SILVERED_NETHERITE_SWORD = ITEMS.register("silvered_netherite_sword", () -> new SilveredSwordItem(SSTiers.SILVER_NETHERITE_TIER, getSwordItemProperties(SSTiers.SILVER_NETHERITE_TIER)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
