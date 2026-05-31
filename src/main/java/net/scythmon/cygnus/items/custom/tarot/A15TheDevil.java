package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.scythmon.cygnus.init.ModEffects;

import java.util.Random;

public class A15TheDevil extends Item {
    public A15TheDevil(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainhand = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide && pLevel instanceof ServerLevel){
            pPlayer.addEffect(new MobEffectInstance(MobEffects.SATURATION, 900,0));
            pPlayer.addEffect(new MobEffectInstance(ModEffects.DEVIL.get(), 6000, 0));

            if (pPlayer.getHealth() > pPlayer.getMaxHealth()) {
                pPlayer.setHealth(pPlayer.getMaxHealth());
            }
            mainhand.shrink(1);

            return InteractionResultHolder.success(mainhand);
        }
        return InteractionResultHolder.sidedSuccess(mainhand, pLevel.isClientSide);
    }
}
