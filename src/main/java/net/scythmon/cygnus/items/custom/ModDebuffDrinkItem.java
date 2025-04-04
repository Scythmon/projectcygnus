package net.scythmon.cygnus.items.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.scythmon.cygnus.init.ModEffects;
import net.scythmon.cygnus.init.ModItems;

public class ModDebuffDrinkItem extends Item {
    private static final int DRINK_DURATION = 40;

    public ModDebuffDrinkItem(Properties pProperties) {super(pProperties);}

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        if (pEntityLiving instanceof ServerPlayer $$3) {
            CriteriaTriggers.CONSUME_ITEM.trigger($$3, pStack);
            $$3.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!pLevel.isClientSide && pStack.is(ModItems.ONEH_MOTER.get())) {
            pEntityLiving.removeEffect(MobEffects.REGENERATION);
            pEntityLiving.removeEffect(MobEffects.ABSORPTION);
            pEntityLiving.removeEffect(MobEffects.DAMAGE_RESISTANCE);
        }

        if (!pLevel.isClientSide && pStack.is(ModItems.BOTTLED_BLOOD.get()) && pEntityLiving instanceof Player player) {
            player.addEffect(new MobEffectInstance(ModEffects.COAGULATION.get(), 200, 0, false, false, true));
        }

        if (pStack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (pEntityLiving instanceof Player && !((Player) pEntityLiving).getAbilities().instabuild) {
                ItemStack $$4 = new ItemStack(Items.GLASS_BOTTLE);
                Player $$5 = (Player) pEntityLiving;
                if (!$$5.getInventory().add($$4)) {
                    $$5.drop($$4, false);
                }
            }

            return pStack;
        }
    }
    public int getUseDuration(ItemStack pStack) {
        return 40;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }
}
