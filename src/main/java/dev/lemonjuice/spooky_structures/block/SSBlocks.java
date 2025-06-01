package dev.lemonjuice.spooky_structures.block;

import dev.lemonjuice.spooky_structures.SpookyStructures;
import dev.lemonjuice.spooky_structures.item.SSItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SSBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SpookyStructures.MOD_ID);

    public static final DeferredBlock<Block> FLESH_BLOCK = registerBlock("flesh_block", () -> new Block(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.SLIME_BLOCK)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        SSItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
