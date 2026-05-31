package net.scythmon.cygnus.util.tickhandlers;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.crowns.ESpeedCrownArmorItem;
import net.scythmon.cygnus.items.custom.crowns.EStrengthCrownArmorItem;

@Mod.EventBusSubscriber(modid = ProjectCygnus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ArmorImmunityHandler {
    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {
        LivingEntity entity = event.getEntity();
        ItemStack helmetStack = entity.getItemBySlot(EquipmentSlot.HEAD);

        if (event.getAmount() <= 0 || !entity.isAlive()) {
            return;
        }

        // Lightning Protection
        if (event.getSource().is(DamageTypeTags.IS_LIGHTNING) && event.isCancelable()) {
            if (!helmetStack.isEmpty() && helmetStack.getItem() instanceof ESpeedCrownArmorItem) {
                event.setCanceled(true);
            }
        }

        // Fire Protection
        if (event.getSource().is(DamageTypeTags.IS_FIRE) && event.isCancelable()) {
            if (!helmetStack.isEmpty() && helmetStack.getItem() instanceof EStrengthCrownArmorItem) {
                event.setCanceled(true);
            }
        }
    }
}
