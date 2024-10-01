package dev.lemonjuice.spooky_structures.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static dev.lemonjuice.spooky_structures.SpookyStructures.MOD_ID;

public class SSItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(MOD_ID);



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
