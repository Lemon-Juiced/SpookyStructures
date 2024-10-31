package dev.lemonjuice.spooky_structures.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.common.util.Lazy;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SSDungeonLootModifier extends LootModifier {
    public static final Supplier<MapCodec<SSDungeonLootModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst).apply(inst, SSDungeonLootModifier::new))
    );

    public SSDungeonLootModifier(LootItemCondition[] conditions) {
        super(conditions);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.addAll(CustomPools.roll(context));
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }

    private static class CustomPools {
        private static final Lazy<LootPool> commonPool = Lazy.of(() -> buildLootPool("common"));

        private static List<ItemStack> roll(LootContext ctx) {
            return Util.make(new ArrayList<>(), l -> {
                commonPool.get().addRandomItems(l::add, ctx);
            });
        }

        private static LootPool buildLootPool(String name) {
            ResourceKey<LootTable> key = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("spooky_structures", "custom/" + name + "_dungeon_loot"));
            return LootPool.lootPool()
                    .add(NestedLootTable.lootTableReference(key).setWeight(1))
                    .name("spooky_structures_custom_" + name)
                    .build();
        }
    }
}