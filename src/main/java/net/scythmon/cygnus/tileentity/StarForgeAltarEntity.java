package net.scythmon.cygnus.tileentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.scythmon.cygnus.block.custom.tileentity.StarForgeBlock;
import net.scythmon.cygnus.init.ModBlockEntities;
import net.scythmon.cygnus.util.recipies.AltarRecipe;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StarForgeAltarEntity extends BlockEntity {
    private final ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        public int getSlotLimit(int slot) {
            return 1;
        }

        @Override
        public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
            if (!getStackInSlot(slot).isEmpty()) {
                return stack;
            }

            ItemStack allowedCopy = stack.copy();
            allowedCopy.setCount(1);

            if (!simulate) {
                super.insertItem(slot, allowedCopy, false);
            }

            ItemStack remainder = stack.copy();
            remainder.shrink(1);
            return remainder;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
            }
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public StarForgeAltarEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STAR_FORGE_BE.get(), pos, state);
    }

    public ItemStackHandler getInventory() {
        return this.inventory;
    }

    public void attemptCraft() {
        if (this.level == null || this.level.isClientSide() || this.craftTime > 0) return;

        SimpleContainer container = getContainerFromStructure();

        Optional<AltarRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(AltarRecipe.Type.INSTANCE, container, level);

        if (recipe.isPresent()) {
            this.craftTime = 1;
            this.level.playSound(null, worldPosition, SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS, 1.0F, 1.0F);

            BlockState state = this.getBlockState();
            if (state.hasProperty(StarForgeBlock.CRAFTING)) {
                this.level.setBlock(this.worldPosition, state.setValue(StarForgeBlock.CRAFTING, true), 3);
            }

            setChanged();
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    private void finishCraft() {
        SimpleContainer container = getContainerFromStructure();
        Optional<AltarRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(AltarRecipe.Type.INSTANCE, container, level);

        if (recipe.isPresent()) {
            ItemStack result = recipe.get().assemble(container, level.registryAccess());

            List<BlockPos> pedestalPositions = getExactPedestalPositions();
            for (BlockPos pPos : pedestalPositions) {
                BlockEntity be = level.getBlockEntity(pPos);
                if (be != null && be.getType() == ModBlockEntities.STAR_FORGE_PILLAR_BE.get()) {
                    var handlerOpt = be.getCapability(ForgeCapabilities.ITEM_HANDLER).resolve();
                    if (handlerOpt.isPresent()) {
                        handlerOpt.get().extractItem(0, 1, false);
                    }
                }
            }

            inventory.setStackInSlot(0, result.copy());
            level.playSound(null, worldPosition, SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.BLOCKS, 0.8F, 1.5F);
        }

        this.craftTime = 0;

        BlockState state = this.getBlockState();
        if (state.hasProperty(StarForgeBlock.CRAFTING)) {
            this.level.setBlock(this.worldPosition, state.setValue(StarForgeBlock.CRAFTING, false), 3);
        }

        setChanged();
        level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
    }

    private SimpleContainer getContainerFromStructure() {
        SimpleContainer container = new SimpleContainer(9);
        container.setItem(0, inventory.getStackInSlot(0));

        List<BlockPos> pedestalPositions = getExactPedestalPositions();
        for (int i = 0; i < pedestalPositions.size(); i++) {
            BlockPos pPos = pedestalPositions.get(i);
            BlockEntity be = level.getBlockEntity(pPos);
            ItemStack pedestalItem = ItemStack.EMPTY;

            if (be != null && be.getType() == ModBlockEntities.STAR_FORGE_PILLAR_BE.get()) {
                var handlerOpt = be.getCapability(ForgeCapabilities.ITEM_HANDLER).resolve();
                if (handlerOpt.isPresent()) {
                    ItemStack stack = handlerOpt.get().getStackInSlot(0);
                    if (!stack.isEmpty()) {
                        pedestalItem = stack;
                    }
                }
            }
            container.setItem(i + 1, pedestalItem);
        }
        return container;
    }

    public List<BlockPos> getExactPedestalPositions() {
        List<BlockPos> positions = new ArrayList<>();
        positions.add(worldPosition.offset(0, 0, 3));   // Index 0 (Container Slot 1) - North
        positions.add(worldPosition.offset(0, 0, -3));  // Index 1 (Container Slot 2) - South
        positions.add(worldPosition.offset(3, 0, 0));   // Index 2 (Container Slot 3) - East
        positions.add(worldPosition.offset(-3, 0, 0));  // Index 3 (Container Slot 4) - West
        positions.add(worldPosition.offset(2, 0, 2));   // Index 4 (Container Slot 5) - North-East
        positions.add(worldPosition.offset(-2, 0, 2));  // Index 5 (Container Slot 6) - North-West
        positions.add(worldPosition.offset(2, 0, -2));  // Index 6 (Container Slot 7) - South-East
        positions.add(worldPosition.offset(-2, 0, -2)); // Index 7 (Container Slot 8) - South-West
        return positions;
    }

    @Override
    public net.minecraft.world.phys.AABB getRenderBoundingBox() {
        // Expands the bounding box 4 blocks outward in every horizontal direction
        // and 2 blocks up so it doesnt stop rendering pedestals too early
        return new net.minecraft.world.phys.AABB(worldPosition).inflate(4.0D, 2.0D, 4.0D);
    }


    private int craftTime = 0;
    private int maxCraftTime = 200;

    public boolean isCrafting() {
        return this.craftTime > 0;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, StarForgeAltarEntity altar) {
        if (level.isClientSide()) {
            if (state.hasProperty(StarForgeBlock.CRAFTING) && state.getValue(StarForgeBlock.CRAFTING)) {
                float craftProgress = altar.getCraftProgress();

                float curve = (float) Math.pow(craftProgress, 2);

                float rotationSpeed = 1.0F + (curve * 90.0F); // 1x to 28x speed
                altar.currentRotation = (altar.currentRotation + rotationSpeed) % 360f;

                float targetRiseY = curve * 0.5f;
                altar.currentRiseY += (targetRiseY - altar.currentRiseY) * 0.1f;

                altar.spawnCraftingParticles();
            } else {
                altar.currentRiseY += (0f - altar.currentRiseY) * 0.1f;
            }
            return;
        }

        if (altar.craftTime > 0) {
            altar.craftTime++;

            // Sync to client every 5 ticks so renderer can track progress
            if (altar.craftTime % 5 == 0) {
                level.sendBlockUpdated(pos, state, state, 3);
            }

            if (altar.craftTime >= altar.maxCraftTime) {
                altar.finishCraft();
            }
            altar.setChanged();
        }
    }

    private void spawnCraftingParticles() {
        if (this.level == null) return;

        double centerX = this.worldPosition.getX() + 0.5D;
        double centerY = this.worldPosition.getY() + 1.2D;
        double centerZ = this.worldPosition.getZ() + 0.5D;

        RandomSource random = this.level.random;

        for (BlockPos pPos : getExactPedestalPositions()) {
            BlockEntity be = level.getBlockEntity(pPos);
            if (be == null || be.getType() != ModBlockEntities.STAR_FORGE_PILLAR_BE.get()) continue;

            var handlerOpt = be.getCapability(ForgeCapabilities.ITEM_HANDLER).resolve();
            if (handlerOpt.isEmpty()) continue;

            ItemStack pedestalStack = handlerOpt.get().getStackInSlot(0);
            if (pedestalStack.isEmpty()) continue;

            double pedX = pPos.getX() + 0.5D;
            double pedY = pPos.getY() + 1.1D;
            double pedZ = pPos.getZ() + 0.5D;

            double dx = centerX - pedX;
            double dy = centerY - pedY;
            double dz = centerZ - pedZ;

            for (int i = 0; i < 3; i++) {
                double t = random.nextDouble();
                double spawnX = pedX + dx * t * 0.5D + (random.nextDouble() - 0.5D) * 0.15D;
                double spawnY = pedY + dy * t * 0.5D + (random.nextDouble() - 0.5D) * 0.15D;
                double spawnZ = pedZ + dz * t * 0.5D + (random.nextDouble() - 0.5D) * 0.15D;

                double velX = dx * 0.08D;
                double velY = dy * 0.08D;
                double velZ = dz * 0.08D;

                level.addParticle(
                        new ItemParticleOption(ParticleTypes.ITEM, pedestalStack),
                        spawnX,
                        spawnY,
                        spawnZ,
                        velX,
                        velY,
                        velZ
                );
            }
        }
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> inventory);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Inventory", this.inventory.serializeNBT());
        tag.putInt("CraftTime", this.craftTime);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("Inventory")) {
            this.inventory.deserializeNBT(tag.getCompound("Inventory"));
        }
        this.craftTime = tag.getInt("CraftTime");
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(net.minecraft.network.Connection net, net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket pkt) {
        net.minecraft.nbt.CompoundTag tag = pkt.getTag();
        if (tag != null) {
            this.load(tag);
        }
    }

    public float getCraftProgress() {
        return maxCraftTime > 0 ? (float) craftTime / maxCraftTime : 0f;
    }

    public float currentRotation = 0f;
    public float currentRiseY = 0f;

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.put("Inventory", this.inventory.serializeNBT());
        tag.putInt("CraftTime", this.craftTime);
        return tag;
    }

}