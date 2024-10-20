package dev.lemonjuice.spooky_structures.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class EctoplasmArmorItem extends ArmorItem {
    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP = (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>()).put(SSArmorMaterials.ECTOPLASM_ARMOR_MATERIAL, List.of(new MobEffectInstance(MobEffects.INVISIBILITY, MobEffectInstance.INFINITE_DURATION, 0, false, false))).build();

    public EctoplasmArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide() && hasFullSuitOfArmorOn(player)) evaluateArmorEffects(player);
        else if (entity instanceof Player player && !level.isClientSide() && !hasFullSuitOfArmorOn(player)) removeArmorEffects(player);
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();

            if (hasPlayerCorrectArmorOn(mapArmorMaterial, player)) addEffectToPlayer(player, mapEffect);
        }
    }

    private void removeArmorEffects(Player player) {
        for (List<MobEffectInstance> mapEffect : MATERIAL_TO_EFFECT_MAP.values())
            for (MobEffectInstance effect : mapEffect)
                if (player.hasEffect(effect.getEffect())) player.removeEffect(effect.getEffect());
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if (!hasPlayerEffect) {
            for (MobEffectInstance effect : mapEffect)
                player.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> mapArmorMaterial, Player player) {
        for (ItemStack armorStack : player.getArmorSlots())
            if (!(armorStack.getItem() instanceof ArmorItem)) return false;

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial().equals(mapArmorMaterial) && leggings.getMaterial().equals(mapArmorMaterial)
                && chestplate.getMaterial().equals(mapArmorMaterial) && helmet.getMaterial().equals(mapArmorMaterial);
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.spooky_structures.ectoplasm_armor"));
    }
}
