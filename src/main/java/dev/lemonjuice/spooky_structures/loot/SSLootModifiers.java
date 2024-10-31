package dev.lemonjuice.spooky_structures.loot;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class SSLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS
            = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, "spooky_structures");

    public static final Supplier<MapCodec<SSDungeonLootModifier>> DUNGEON_LOOT
            = LOOT_MODIFIERS.register("dungeon_loot", SSDungeonLootModifier.CODEC);
}