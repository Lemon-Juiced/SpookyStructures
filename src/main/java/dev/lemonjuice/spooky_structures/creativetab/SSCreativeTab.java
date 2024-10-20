package dev.lemonjuice.spooky_structures.creativetab;

import dev.lemonjuice.scalar_core.ScalarCore;
import dev.lemonjuice.spooky_structures.block.SSBlocks;
import dev.lemonjuice.spooky_structures.item.SSItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SSCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ScalarCore.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SS_ITEMS_TAB = CREATIVE_MODE_TABS.register("spooky_structures_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.spooky_structures.tab"))
            .icon(() -> new ItemStack(SSItems.SILVER_INGOT.get()))
            .build());

    public static void registerTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == SS_ITEMS_TAB.get()) {
            event.accept(SSItems.SILVER_INGOT.get());
            event.accept(SSItems.SILVER_NUGGET.get());
            event.accept(SSItems.RAW_SILVER.get());
            event.accept(SSItems.SILVER_SMITHING_TEMPLATE.get());
            event.accept(SSItems.ECTOPLASM.get());
            event.accept(SSItems.ECTOPLASM_INFUSED_SILVER_INGOT.get());

            event.accept(SSItems.SILVERED_WOODEN_SWORD.get());
            event.accept(SSItems.SILVERED_STONE_SWORD.get());
            event.accept(SSItems.SILVERED_IRON_SWORD.get());
            event.accept(SSItems.SILVERED_DIAMOND_SWORD.get());
            event.accept(SSItems.SILVERED_GOLDEN_SWORD.get());
            event.accept(SSItems.SILVERED_NETHERITE_SWORD.get());

            event.accept(SSItems.ECTOPLASM_HELMET.get());
            event.accept(SSItems.ECTOPLASM_CHESTPLATE.get());
            event.accept(SSItems.ECTOPLASM_LEGGINGS.get());
            event.accept(SSItems.ECTOPLASM_BOOTS.get());

            event.accept(SSBlocks.FLESH_BLOCK.get().asItem());
            event.accept(SSBlocks.SILVER_BLOCK.get().asItem());
            event.accept(SSBlocks.RAW_SILVER_BLOCK.get().asItem());
            event.accept(SSBlocks.SILVER_ORE.get().asItem());
            event.accept(SSBlocks.DEEPSLATE_SILVER_ORE.get().asItem());
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
