package net.scythmon.cygnus.util;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.scythmon.cygnus.items.custom.crowns.ESpeedCrownArmorItem;
import net.scythmon.cygnus.items.custom.crowns.EStrengthCrownArmorItem;

public class PlayerTickHandler {
    @SubscribeEvent
    public void onEntityAttacked(LivingAttackEvent event) {
        LivingEntity entity = event.getEntity();
        ItemStack helmetStack = entity.getItemBySlot(EquipmentSlot.HEAD);
        if (event.getAmount() <= 0
                || !entity.isAlive()) {
            return;
        }

        if (event.getSource().is(DamageTypeTags.IS_LIGHTNING)) {
            if (!helmetStack.isEmpty() && helmetStack.getItem()instanceof ESpeedCrownArmorItem) {
                event.setCanceled(true);
            }
        }

        if (event.getSource().is(DamageTypeTags.IS_FIRE)) {
            if (!helmetStack.isEmpty() && helmetStack.getItem()instanceof EStrengthCrownArmorItem) {
                event.setCanceled(true);
            }
        }

    }
}
