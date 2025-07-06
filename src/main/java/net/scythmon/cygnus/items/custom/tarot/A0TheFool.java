package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.core.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.scythmon.cygnus.init.ModItems;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;


public class A0TheFool extends Item {
    public A0TheFool(Properties pProperties) {super(pProperties);}

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.getItemInHand(handIn);

        if (playerIn.getCooldowns().isOnCooldown(ModItems.THE_FOOL.get())
                || worldIn.isClientSide())
            return InteractionResultHolder.fail(stack);

        ServerPlayer serverPlayer = (ServerPlayer) playerIn;

        Pair<ServerLevel, Vec3> data = getHomePos(serverPlayer, false);

        playerIn.startUsingItem(handIn);

        return InteractionResultHolder.pass(stack);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (world.isClientSide() || !(entity instanceof ServerPlayer player))
            return stack;

        Pair<ServerLevel, Vec3> data = getHomePos(player, true);


        Vec3 pos = data.getRight();


        player.teleportTo(data.getLeft(), pos.x() + 0.5F, pos.y() + 1.0F, pos.z() + 0.5F, player.getYRot(), player.getXRot());

        if (!player.isCreative())
            player.getCooldowns().addCooldown(stack.getItem(), (int) Math.round(60 * 20));

        world.playSound(null, player.blockPosition(), SoundEvents.TOTEM_USE, SoundSource.PLAYERS, 1.0F, 1.0F);

        return stack;
    }


    @Nullable
    private Pair<ServerLevel, Vec3> getHomePos(ServerPlayer player, boolean useAnchor) {
        if (player.level().isClientSide())
            return null;

        BlockPos pos = player.getRespawnPosition();

        MinecraftServer server = player.getServer();

        if (server == null)
            return null;

        ServerLevel world = player.getServer().getLevel(player.getRespawnDimension());

        if (world == null || pos == null)
            return null;

        return Player.findRespawnPositionAndUseSpawnBlock(world, pos, player.getRespawnAngle(), true, !useAnchor)
                .map(vec3 -> Pair.of(world, vec3)).orElse(null);
    }



    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 40;
    }

    @Mod.EventBusSubscriber
    public static class ServerEvents {
        @SubscribeEvent
        public static void onLivingHurt(LivingHurtEvent event) {
            Item item = ModItems.THE_FOOL.get();

            if (!(event.getEntity() instanceof Player player) || !player.isUsingItem()
                    || (player.getMainHandItem().getItem() != item && player.getOffhandItem().getItem() != item))
                return;

            player.stopUsingItem();

            player.getCooldowns().addCooldown(item, 20);
        }
    }
}
