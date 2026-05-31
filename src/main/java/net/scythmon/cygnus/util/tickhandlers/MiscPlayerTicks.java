package net.scythmon.cygnus.util.tickhandlers;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.scythmon.cygnus.ProjectCygnus;

import java.lang.reflect.Method;

@Mod.EventBusSubscriber(modid = ProjectCygnus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MiscPlayerTicks {
    private static Method setSharedFlagMethod = null;

    private static void forceFlightFlag(Player player, boolean value) {
        try {
            if (setSharedFlagMethod == null) {
                setSharedFlagMethod = ObfuscationReflectionHelper.findMethod(
                        net.minecraft.world.entity.Entity.class,
                        "m_20242_",
                        int.class,
                        boolean.class
                );
                setSharedFlagMethod.setAccessible(true);
            }
            setSharedFlagMethod.invoke(player, 7, value); // 7 is elytra flight
        } catch (Exception e) {
            // Unobfuscated fallback
            try {
                Method fallback = net.minecraft.world.entity.Entity.class.getDeclaredMethod("setSharedFlag", int.class, boolean.class);
                fallback.setAccessible(true);
                fallback.invoke(player, 7, value);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerDamage(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            CompoundTag playerData = player.getPersistentData();

            if (event.getSource().is(DamageTypes.FALL)) {
                if (playerData.contains("Freefall") || playerData.contains("RecentFreefallLanding")) {
                    event.setCanceled(true);
                    playerData.remove("RecentFreefallLanding"); // Cleans up the tag
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        CompoundTag playerData = player.getPersistentData();

        if (playerData.contains("Freefall")) {
            int timeLeft = playerData.getInt("Freefall");

            if (timeLeft > 0) {
                if (event.phase == TickEvent.Phase.START) {
                    timeLeft--;
                    playerData.putInt("Freefall", timeLeft);
                }

                if (timeLeft <= 600) {
                    if (!player.onGround()) {
                        player.startFallFlying();
                        forceFlightFlag(player, true);

                        if (player.getDeltaMovement().y > -0.5) {
                            player.fallDistance = 1.0F;
                        }
                    }

                    if (timeLeft == 600 && event.phase == TickEvent.Phase.START) {
                        Vec3 look = player.getLookAngle();
                        player.setDeltaMovement(new Vec3(look.x * 1.2, -0.05, look.z * 1.2));
                        player.hurtMarked = true;
                    }

                    if (player.onGround() && timeLeft < 595) {
                        // Offset so they don't splat based on shitty ping
                        playerData.putBoolean("RecentFreefallLanding", true);
                        stopCustomGlide(player, playerData);
                    }
                }
            } else {
                playerData.putBoolean("RecentFreefallLanding", true);
                stopCustomGlide(player, playerData);
            }
        }
    }

    private static void stopCustomGlide(Player player, CompoundTag playerData) {
        player.stopFallFlying();
        forceFlightFlag(player, false);
        player.fallDistance = 0.0F;
        playerData.remove("Freefall");
    }
}
