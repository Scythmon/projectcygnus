package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.scythmon.cygnus.init.ModEffects;

public class A13Death extends Item {
    public A13Death(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getMainHandItem();
        if (!pLevel.isClientSide()) {
            spawnEffectCloud(pLevel, pPlayer);
            mainHand.shrink(1);
        }
        return InteractionResultHolder.success(mainHand);
    }

    private void spawnEffectCloud(Level level, Player player) {
        MobEffect effect = ModEffects.SECOND_DEATH.get();;
        AreaEffectCloud cloud = new AreaEffectCloud(level, player.getX(), player.getY(), player.getZ());
        cloud.setRadius(2.5F);
        cloud.setRadiusOnUse(-0.5F);
        cloud.setWaitTime(10);
        cloud.setDuration(600);
        cloud.addEffect(new MobEffectInstance(effect, 300, 1));
        level.addFreshEntity(cloud);
    }
}
