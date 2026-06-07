package net.scythmon.cygnus.tileentity;

import com.blakebr0.cucumber.inventory.BaseItemStackHandler;
import com.blakebr0.cucumber.inventory.CachedRecipe;
import com.blakebr0.cucumber.tileentity.BaseInventoryTileEntity;
import com.blakebr0.cucumber.util.MultiblockPositions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.scythmon.cygnus.block.custom.tileentity.StarForgeBlock;
import net.scythmon.cygnus.init.ModBlockEntities;
import net.scythmon.cygnus.init.ModRecipeTypes;
import net.scythmon.cygnus.util.recipies.AltarRecipe;
import net.scythmon.cygnus.util.IActivatable;
import net.scythmon.cygnus.util.IAltarRecipe;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
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
            level.playSound(null, worldPosition, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.0F, 2.0F);
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
    private int maxCraftTime = 100;

    public boolean isCrafting() {
        return this.craftTime > 0;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, StarForgeAltarEntity altar) {
        if (level.isClientSide()) {
            if (state.hasProperty(StarForgeBlock.CRAFTING) && state.getValue(StarForgeBlock.CRAFTING)) {
                altar.spawnCraftingParticles();
            }
            return;
        }

        if (altar.craftTime > 0) {
            altar.craftTime++;

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
            if (!level.isEmptyBlock(pPos)) {

                double pedX = pPos.getX() + 0.5D;
                double pedY = pPos.getY() + 1.1D;
                double pedZ = pPos.getZ() + 0.5D;

                double velX = (centerX - pedX) * 0.05D;
                double velY = (centerY - pedY) * 0.05D;
                double velZ = (centerZ - pedZ) * 0.05D;

                if (random.nextFloat() < 0.4F) {
                    level.addParticle(
                            ParticleTypes.CHERRY_LEAVES,
                            pedX + (random.nextDouble() - 0.5D) * 0.2D,
                            pedY,
                            pedZ + (random.nextDouble() - 0.5D) * 0.2D,
                            velX,
                            velY,
                            velZ
                    );
                }
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
            if (this.level != null && this.level.isClientSide()) {
                this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
            }
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        tag.put("Inventory", this.inventory.serializeNBT());
        tag.putInt("CraftTime", this.craftTime);
        return tag;
    }

}