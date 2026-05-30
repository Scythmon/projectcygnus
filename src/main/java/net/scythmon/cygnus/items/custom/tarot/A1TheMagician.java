package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class A1TheMagician extends Item {
    public A1TheMagician(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide() && pLevel instanceof ServerLevel serverLevel) {
            double radius = 15.0D;

            AABB searchBox = pPlayer.getBoundingBox().inflate(radius);
            List<Player> nearbyPlayers = serverLevel.getEntitiesOfClass(Player.class, searchBox);
            nearbyPlayers.remove(pPlayer); // Exclude the user from the target list

            if (!nearbyPlayers.isEmpty()) {
                Player targetPlayer = nearbyPlayers.get(pLevel.getRandom().nextInt(nearbyPlayers.size()));

                Vec3 userPos = pPlayer.position();
                Vec3 targetPos = targetPlayer.position();

                pPlayer.teleportTo(targetPos.x, targetPos.y, targetPos.z);

                targetPlayer.teleportTo(userPos.x, userPos.y, userPos.z);

                pLevel.playSound(null, userPos.x, userPos.y, userPos.z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0f, 1.0f);
                pLevel.playSound(null, targetPos.x, targetPos.y, targetPos.z, SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0f, 1.0f);

            } else {

                boolean teleportSuccess = false;


                for (int i = 0; i < 16; i++) {
                    double targetX = pPlayer.getX() + (pPlayer.getRandom().nextDouble() - 0.5D) * 16.0D;
                    // this is here as this fucker voided me lmao
                    double targetY = Mth.clamp(pPlayer.getY() + (pPlayer.getRandom().nextInt(16) - 8), (double)pLevel.getMinBuildHeight(), (double)(pLevel.getMinBuildHeight() + ((ServerLevel) pLevel).getLogicalHeight() - 1));
                    double targetZ = pPlayer.getZ() + (pPlayer.getRandom().nextDouble() - 0.5D) * 16.0D;

                    if (pPlayer.isPassenger()) {
                        pPlayer.stopRiding();
                    }

                    if (pPlayer.randomTeleport(targetX, targetY, targetZ, true)) {
                        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.CHORUS_FRUIT_TELEPORT, SoundSource.PLAYERS, 1.0f, 1.0f);
                        teleportSuccess = true;
                        break;
                    }
                }

                // Only loops 16 times, if it doesnt work it just fizzles
                if (!teleportSuccess) {
                    pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.5f, 1.0f);
                    return InteractionResultHolder.fail(mainHand);
                }
            }

            mainHand.shrink(1);
            pPlayer.getCooldowns().addCooldown(this, 200);
            return InteractionResultHolder.success(mainHand);
        }

        return InteractionResultHolder.sidedSuccess(mainHand, pLevel.isClientSide());
    }
}
