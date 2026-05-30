package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class A8Strength extends Item {
    public A8Strength(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide()) {
            RandomSource random = pLevel.getRandom();
            pPlayer.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0));

            Vec3 lookVec = pPlayer.getLookAngle();
            Vec3 rightVec = lookVec.cross(new Vec3(0, 1, 0)).normalize();

            for (int i = 0; i < 5; i++) {
                double spreadX = lookVec.x + (random.nextDouble() - 0.5D) * 0.35D;
                double spreadY = lookVec.y + (random.nextDouble() - 0.5D) * 0.25D;
                double spreadZ = lookVec.z + (random.nextDouble() - 0.5D) * 0.35D;

                double offsetMultiplier = (i - 2) * 0.4D;

                // Spreads the fireballs out a bit so they dont break each other, also prevents you from combusting
                double spawnX = pPlayer.getX() + lookVec.x * 0.6D + (rightVec.x * offsetMultiplier);
                double spawnY = pPlayer.getEyeY() - 0.2D + (random.nextDouble() - 0.5D) * 0.2D;
                double spawnZ = pPlayer.getZ() + lookVec.z * 0.6D + (rightVec.z * offsetMultiplier);

                if (i == 0) {

                    LargeFireball explosiveBall = new LargeFireball(pLevel, pPlayer, spreadX, spreadY, spreadZ, 1);
                    explosiveBall.setPos(spawnX, spawnY, spawnZ);

                    // Customize the explosion radius (1 = Ghast, 3 = Creeper, 4 = TNT)
                    net.minecraft.nbt.CompoundTag nbt = new net.minecraft.nbt.CompoundTag();
                    explosiveBall.addAdditionalSaveData(nbt);
                    nbt.putInt("ExplosionPower", 2);
                    explosiveBall.readAdditionalSaveData(nbt);

                    pLevel.addFreshEntity(explosiveBall);
                } else {

                    SmallFireball smallBall = new SmallFireball(pLevel, pPlayer, spreadX, spreadY, spreadZ);
                    smallBall.setPos(spawnX, spawnY, spawnZ);

                    pLevel.addFreshEntity(smallBall);
                }
            }

                BlockPos playerPos = pPlayer.blockPosition();
                for (int x = -2; x <= 1; x++) {
                    for (int z = -2; z <= 1; z++) {
                        BlockPos targetPos = playerPos.offset(x, 0, z);

                        if (pLevel.isEmptyBlock(targetPos) && pLevel.getBlockState(targetPos.below()).isSolidRender(pLevel, targetPos.below())) {
                            pLevel.setBlockAndUpdate(targetPos, Blocks.FIRE.defaultBlockState());
                        }
                    }
                }


                pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                        SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.5f, 1.0f);


                return InteractionResultHolder.success(mainHand);
            }
        return InteractionResultHolder.sidedSuccess(mainHand, pLevel.isClientSide);
    }
}
