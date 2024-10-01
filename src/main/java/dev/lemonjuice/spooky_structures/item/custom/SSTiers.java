package dev.lemonjuice.spooky_structures.item.custom;

import dev.lemonjuice.spooky_structures.item.SSItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

/**
 * Simple Tiers
 * new SimpleTier(TagKey<Block> incorrectBlockForDrops, int uses, float speed, int enchantmentValue, Supplier<Ingredient> repairIngredient)
 *
 * WOOD(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 59, 2.0F, 0.0F, 15, () -> {
 *  return Ingredient.of(ItemTags.PLANKS);
 * }),
 * STONE(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 4.0F, 1.0F, 5, () -> {
 *  return Ingredient.of(ItemTags.STONE_TOOL_MATERIALS);
 * }),
 * IRON(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, () -> {
 *  return Ingredient.of(new ItemLike[]{Items.IRON_INGOT});
 * }),
 * DIAMOND(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 10, () -> {
 *  return Ingredient.of(new ItemLike[]{Items.DIAMOND});
 * }),
 * GOLD(BlockTags.INCORRECT_FOR_GOLD_TOOL, 32, 12.0F, 0.0F, 22, () -> {
 *  return Ingredient.of(new ItemLike[]{Items.GOLD_INGOT});
 * }),
 * NETHERITE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2031, 9.0F, 4.0F, 15, () -> {
 *  return Ingredient.of(new ItemLike[]{Items.NETHERITE_INGOT});
 * });
 */
public class SSTiers {
    private static final int SILVER_USES = Tiers.GOLD.getUses() * 4;
    private static final float SILVER_SPEED = Tiers.GOLD.getSpeed() / 1.5F;
    private static final float SILVER_ATTACK_DAMAGE_BONUS = 2.0F;
    private static final int SILVER_ENCHANTMENT_VALUE = 14;

    public static final Tier SILVER_WOOD_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_WOODEN_TOOL, averageSilverUses(Tiers.WOOD.getUses()), averageSilverSpeed(Tiers.WOOD.getSpeed()), averageSilverAttackDamageBonus(Tiers.WOOD.getAttackDamageBonus()), averageSilverEnchantmentValue(Tiers.WOOD.getEnchantmentValue()), () -> Ingredient.of(SSItems.SILVER_INGOT.get()));
    public static final Tier SILVER_STONE_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_STONE_TOOL, averageSilverUses(Tiers.STONE.getUses()), averageSilverSpeed(Tiers.STONE.getSpeed()), averageSilverAttackDamageBonus(Tiers.STONE.getAttackDamageBonus()), averageSilverEnchantmentValue(Tiers.STONE.getEnchantmentValue()), () -> Ingredient.of(SSItems.SILVER_INGOT.get()));
    public static final Tier SILVER_IRON_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, averageSilverUses(Tiers.IRON.getUses()), averageSilverSpeed(Tiers.IRON.getSpeed()), averageSilverAttackDamageBonus(Tiers.IRON.getAttackDamageBonus()), averageSilverEnchantmentValue(Tiers.IRON.getEnchantmentValue()), () -> Ingredient.of(SSItems.SILVER_INGOT.get()));
    public static final Tier SILVER_DIAMOND_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, averageSilverUses(Tiers.DIAMOND.getUses()), averageSilverSpeed(Tiers.DIAMOND.getSpeed()), averageSilverAttackDamageBonus(Tiers.DIAMOND.getAttackDamageBonus()), averageSilverEnchantmentValue(Tiers.DIAMOND.getEnchantmentValue()), () -> Ingredient.of(SSItems.SILVER_INGOT.get()));
    public static final Tier SILVER_GOLD_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_GOLD_TOOL, averageSilverUses(Tiers.GOLD.getUses()), averageSilverSpeed(Tiers.GOLD.getSpeed()), averageSilverAttackDamageBonus(Tiers.GOLD.getAttackDamageBonus()), averageSilverEnchantmentValue(Tiers.GOLD.getEnchantmentValue()), () -> Ingredient.of(SSItems.SILVER_INGOT.get()));
    public static final Tier SILVER_NETHERITE_TIER = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, averageSilverUses(Tiers.NETHERITE.getUses()), averageSilverSpeed(Tiers.NETHERITE.getSpeed()), averageSilverAttackDamageBonus(Tiers.NETHERITE.getAttackDamageBonus()), averageSilverEnchantmentValue(Tiers.NETHERITE.getEnchantmentValue()), () -> Ingredient.of(SSItems.SILVER_INGOT.get()));

    private static int averageSilverUses(int currentUses) {return (currentUses + SILVER_USES) / 2;}
    private static float averageSilverSpeed(float currentSpeed) {return (currentSpeed + SILVER_SPEED) / 2;}
    private static float averageSilverAttackDamageBonus(float currentAttackDamageBonus) {return (currentAttackDamageBonus + SILVER_ATTACK_DAMAGE_BONUS) / 2;}
    private static int averageSilverEnchantmentValue(int currentEnchantmentValue) {return (currentEnchantmentValue + SILVER_ENCHANTMENT_VALUE) / 2;}

}
