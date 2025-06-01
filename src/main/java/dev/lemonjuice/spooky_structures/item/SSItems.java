package dev.lemonjuice.spooky_structures.item;

import dev.lemonjuice.spooky_structures.item.custom.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static dev.lemonjuice.scalar_core.item.ToolItemPropFactory.getNonBurningSwordItemProperties;
import static dev.lemonjuice.scalar_core.item.ToolItemPropFactory.getSwordItemProperties;
import static dev.lemonjuice.spooky_structures.SpookyStructures.MOD_ID;

public class SSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MOD_ID);

    // Ectoplasm Items
    public static final Supplier<Item> ECTOPLASM = ITEMS.register("ectoplasm", () -> new Item(new Item.Properties()));
    public static final Supplier<Item> ECTOPLASM_INFUSED_SILVER_INGOT = ITEMS.register("ectoplasm_infused_silver_ingot", () -> new Item(new Item.Properties()));

    // Ectoplasm Armor
    public static final Supplier<ArmorItem> ECTOPLASM_HELMET = ITEMS.register("ectoplasm_helmet", () -> new EctoplasmArmorItem(SSArmorMaterials.ECTOPLASM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(33))));
    public static final Supplier<ArmorItem> ECTOPLASM_CHESTPLATE = ITEMS.register("ectoplasm_chestplate", () -> new ArmorItem(SSArmorMaterials.ECTOPLASM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(33))));
    public static final Supplier<ArmorItem> ECTOPLASM_LEGGINGS = ITEMS.register("ectoplasm_leggings", () -> new ArmorItem(SSArmorMaterials.ECTOPLASM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(33))));
    public static final Supplier<ArmorItem> ECTOPLASM_BOOTS = ITEMS.register("ectoplasm_boots", () -> new ArmorItem(SSArmorMaterials.ECTOPLASM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(33))));

    // Spooky Jam 2.0
    public static final Supplier<Item> SPOOKY_JAM = ITEMS.register("spooky_jam", () -> new SpookyJamItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
