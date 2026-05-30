package net.scythmon.cygnus.items.custom.tarot;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;

import java.util.ArrayList;
import java.util.List;

public class A18TheMoon extends Item {
    public A18TheMoon(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack mainHand = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide() && pLevel instanceof ServerLevel serverLevel) {
            BlockPos playerPos = pPlayer.blockPosition();

            var registry = serverLevel.registryAccess().registryOrThrow(Registries.STRUCTURE);
            var biomeSource = serverLevel.getChunkSource().getGenerator().getBiomeSource();
            List<Holder<net.minecraft.world.level.biome.Biome>> possibleDimensionBiomes = biomeSource.possibleBiomes().stream().toList();
            List<Holder<Structure>> searchPool = new ArrayList<>();

            for (Holder.Reference<Structure> structureHolder : registry.holders().toList()) {
                Structure structure = structureHolder.value();
                boolean belongsToDimension = false;
                for (Holder<net.minecraft.world.level.biome.Biome> biomeHolder : possibleDimensionBiomes) {
                    if (structure.biomes().contains(biomeHolder)) {
                        belongsToDimension = true;
                        break;
                    }
                }

                if (belongsToDimension) {
                    String path = structureHolder.key().location().getPath();
                    if (!path.contains("piece") && !path.contains("start") && !path.contains("connector")) {
                        searchPool.add(structureHolder);
                    }
                }
            }

            if (searchPool.isEmpty()) {
                registry.holders().forEach(searchPool::add);
            }

            if (!searchPool.isEmpty()) {
                HolderSet<Structure> multiTargetSet = HolderSet.direct(searchPool);
                var searchResult = serverLevel.getChunkSource().getGenerator()
                        .findNearestMapStructure(serverLevel, multiTargetSet, playerPos, 32, false);

                if (searchResult != null) {
                    BlockPos targetPos = searchResult.getFirst();
                    Holder<Structure> foundStructureHolder = searchResult.getSecond();

                    if (targetPos != null && foundStructureHolder != null) {
                        double distance = Math.sqrt(playerPos.distSqr(new BlockPos(targetPos.getX(), playerPos.getY(), targetPos.getZ())));

                        if (distance <= 500.0D) {
                            var structureKey = foundStructureHolder.unwrapKey().orElse(null);
                            String formattedName = "UNKNOWN STRUCTURE";
                            String modId = "MINECRAFT";

                            if (structureKey != null) {
                                formattedName = structureKey.location().getPath().toUpperCase().replace('_', ' ');
                                modId = structureKey.location().getNamespace().toUpperCase();
                            }

                            // === PATH A: SUCCESS ===
                            pPlayer.sendSystemMessage(Component.literal("§6[The Moon] §ehas revealed a structure from: §b" + modId));
                            pPlayer.sendSystemMessage(Component.literal("§eRevealed a: §d" + formattedName));
                            pPlayer.sendSystemMessage(Component.literal("§7Coordinates: §aX: " + targetPos.getX() + " §7| §aY: " + targetPos.getY() + " §7| §aZ: " + targetPos.getZ()));
                            pPlayer.sendSystemMessage(Component.literal("§7Distance: §f" + (int) distance + " blocks away."));

                            pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                                    SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.PLAYERS, 1.0f, 1.2f);

                            pPlayer.getCooldowns().addCooldown(this, 300);
                            return InteractionResultHolder.success(mainHand);
                        }
                    }
                }
            }

            // === PATH B: RADAR EMPTY ===
            pPlayer.sendSystemMessage(Component.literal("§6[The Moon] §7The Moon could sense no structures within its vision."));
            pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                    SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.5f, 1.0f);

            pPlayer.getCooldowns().addCooldown(this, 100);
            return InteractionResultHolder.success(mainHand);
        }

        return InteractionResultHolder.sidedSuccess(mainHand, pLevel.isClientSide());
    }
}

