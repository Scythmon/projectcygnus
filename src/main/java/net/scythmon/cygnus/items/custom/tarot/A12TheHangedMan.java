package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class A12TheHangedMan extends Item {
    public A12TheHangedMan(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack mainhand = player.getItemInHand(hand);

        if (!level.isClientSide) {
            player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 300, 3));

            CompoundTag playerData = player.getPersistentData();
            playerData.putInt("Freefall", 900);

            mainhand.shrink(1);
            if (!player.isCreative()){
               player.getCooldowns().addCooldown(this, 12000);
           }
        }

        return InteractionResultHolder.sidedSuccess(mainhand, level.isClientSide());
    }
}
