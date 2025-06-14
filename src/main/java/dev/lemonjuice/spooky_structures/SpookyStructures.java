package dev.lemonjuice.spooky_structures;

import dev.lemonjuice.spooky_structures.block.SSBlocks;
import dev.lemonjuice.spooky_structures.creativetab.SSCreativeTab;
import dev.lemonjuice.spooky_structures.handler.MobDropHandler;
import dev.lemonjuice.spooky_structures.item.SSItems;
import dev.lemonjuice.spooky_structures.loot.SSLootModifiers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(SpookyStructures.MOD_ID)
public class SpookyStructures {
    public static final String MOD_ID = "spooky_structures";

    public SpookyStructures(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register Items & Blocks
        SSItems.register(modEventBus);
        SSBlocks.register(modEventBus);

        // Register Creative Tab
        SSCreativeTab.register(modEventBus);
        modEventBus.addListener(SSCreativeTab::registerTabs);

        // Register Loot Modifiers
        SSLootModifiers.LOOT_MODIFIERS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        NeoForge.EVENT_BUS.register(new MobDropHandler());
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {}
    }
}
