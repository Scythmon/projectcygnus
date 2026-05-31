package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;


import java.util.List;

public class A21TheWorld extends Item {
    public A21TheWorld(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);
        if (!pLevel.isClientSide() && pLevel instanceof ServerLevel serverLevel) {
            double radius = 15.0D;
            double secondRadius = 30.0;
            AABB divineblind = pPlayer.getBoundingBox().inflate(radius);
            AABB glowing = pPlayer.getBoundingBox().inflate(secondRadius);
            List<Player> blindedPlayers = serverLevel.getEntitiesOfClass(Player.class, divineblind);
            List<Player> glowingPlayers = serverLevel.getEntitiesOfClass(Player.class, glowing);
            blindedPlayers.remove(pPlayer);
            glowingPlayers.remove(pPlayer);

            if (!glowingPlayers.isEmpty()) {
                for (Player blinders : blindedPlayers) {
                    blinders.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 600, 0 ));
                }
                for (Player glowers : glowingPlayers){
                    glowers.addEffect(new MobEffectInstance(MobEffects.GLOWING, 1200, 0));
                }
            } else {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 12000, 0));
            }

            mainHand.shrink(1);

            if (!pPlayer.isCreative()) {
                pPlayer.getCooldowns().addCooldown(this, 6000);
            }
            return InteractionResultHolder.success(mainHand);
        }

        return InteractionResultHolder.sidedSuccess(mainHand, pLevel.isClientSide());
    }
}
