package net.scythmon.cygnus.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.Display;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.scythmon.cygnus.ProjectCygnus;

import javax.annotation.Nullable;
import static net.minecraft.nbt.Tag.TAG_COMPOUND;

public class StarForgePillarEntity extends BaseTile {

    private ItemStack cachedItem;

    public StarForgePillarEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STAR_FORGE_PILLAR_BE.get(), pos, state);
        this.cachedItem = ItemStack.EMPTY;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("displayed_item", TAG_COMPOUND)) {
            this.cachedItem = ItemStack.of(tag.getCompound("displayed_item"));
        }
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        tag.put("displayed_item", this.cachedItem.save(new CompoundTag()));

        super.saveAdditional(tag);
    }

    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    //TODO: TEST EXTENSIVELY
    @Override
    @Nullable
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
    }

    @Override
    public boolean onlyOpCanSetNbt() {
        return false;
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        return super.triggerEvent(id, type);
    }

    @Nullable
    @Override
    public Level getLevel() {
        return super.getLevel();
    }

    @Override
    public BlockPos getBlockPos() {
        return super.getBlockPos();
    }

    public ItemStack getItem() {
        return this.cachedItem;
    }

    public void setDisplayItem(ItemStack stack) {
        this.cachedItem = stack;
        this.sendBlockUpdate();
    }

    public void sendBlockUpdate() {
        this.setChanged();
        this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }
}