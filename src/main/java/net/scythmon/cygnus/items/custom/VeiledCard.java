package net.scythmon.cygnus.items.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.init.ModItems;
import net.scythmon.cygnus.init.ModTags;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class VeiledCard extends Item {
    public VeiledCard(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide()) {
            var optionalTag = pLevel.registryAccess()
                    .registryOrThrow(Registries.ITEM)
                    .getTag(ModTags.Items.TAROT_CARD);

            if (optionalTag.isPresent() && !optionalTag.get().unwrapKey().isEmpty()) {

                Item randomCard = optionalTag.get().getRandomElement(pLevel.random).get().value();

                pPlayer.addItem(new ItemStack(randomCard));
                itemstack.shrink(1);

                pLevel.playSound(null, pPlayer.blockPosition(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS, 1.0f, 1.0f);
            } else {
                ProjectCygnus.LOGGER.warn("If you're seeing this you broke something! Check the datagen!");
            }
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}

