package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.scythmon.cygnus.util.tickhandlers.DelayHandler;

import java.util.List;

public class A20Judgement extends Item {
    public A20Judgement(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide() && pLevel instanceof ServerLevel serverLevel) {
            double radius = 15.0D;
            AABB searchBox = pPlayer.getBoundingBox().inflate(radius);
            List<Player> nearbyPlayers = serverLevel.getEntitiesOfClass(Player.class, searchBox);
            nearbyPlayers.remove(pPlayer);

            if (!nearbyPlayers.isEmpty()) {
                for (Player victim : nearbyPlayers) {
                    LightningBolt firstBolt = EntityType.LIGHTNING_BOLT.create(serverLevel);
                    if (firstBolt != null) {
                        firstBolt.moveTo(victim.position());
                        serverLevel.addFreshEntity(firstBolt);
                    }

                    DelayHandler.scheduleSecondStrike(serverLevel, victim.position(), 100);
                }
            } else {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1));
                pPlayer.addEffect(new MobEffectInstance(MobEffects.SATURATION, 600, 0));
            }

            pPlayer.getCooldowns().addCooldown(this, 300);
            return InteractionResultHolder.success(mainHand);
        }

        return InteractionResultHolder.sidedSuccess(mainHand, pLevel.isClientSide());
    }
}
