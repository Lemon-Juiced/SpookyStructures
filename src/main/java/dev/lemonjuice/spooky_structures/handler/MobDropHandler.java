package dev.lemonjuice.spooky_structures.handler;

import dev.lemonjuice.spooky_structures.item.SSItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

import java.util.Random;

public class MobDropHandler {
    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event){
        var entity = event.getEntity();
        var level = event.getEntity().level();

        if(!level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) return;

        var drops = event.getDrops();
        var attacker = event.getSource().getEntity();
        int ghastDropEctoplasmChance = 80; // Out of 100
        Random random = new Random();

        if(attacker instanceof Player playerEntity){
            Item itemInHand = playerEntity.getItemInHand(InteractionHand.MAIN_HAND).getItem();

            if (entity instanceof Ghast) {
                if (random.nextInt(0, 100) < ghastDropEctoplasmChance)
                    drops.add(new ItemEntity(level, entity.getX(), entity.getY(), entity.getZ(), new ItemStack(SSItems.ECTOPLASM.get())));
            }
        }
    }
}
