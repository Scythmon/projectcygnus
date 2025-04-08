package net.scythmon.cygnus.tileentity;

import com.blakebr0.cucumber.inventory.BaseItemStackHandler;
import com.blakebr0.cucumber.inventory.CachedRecipe;
import com.blakebr0.cucumber.item.BaseItem;
import com.blakebr0.cucumber.tileentity.BaseInventoryTileEntity;
import com.blakebr0.cucumber.util.MultiblockPositions;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.scythmon.cygnus.init.ModBlockEntities;
import net.scythmon.cygnus.init.ModRecipeTypes;
import net.scythmon.cygnus.util.AltarRecipie;
import net.scythmon.cygnus.util.IActivatable;
import net.scythmon.cygnus.util.IAltarRecipe;
import net.scythmon.cygnus.util.StarForgingAltar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StarForgeAltarEntity extends BaseInventoryTileEntity implements IActivatable {
    private final BaseItemStackHandler inventory;
    private final BaseItemStackHandler recipeInventory;
    private final MultiblockPositions pedestalLocations = new MultiblockPositions.Builder()
            .pos(3, 0, 0).pos(0, 0, 3).pos(-3, 0, 0).pos(0, 0, -3)
            .pos(2, 0, 2).pos(2, 0, -2).pos(-2, 0, 2).pos(-2, 0, -2).build();
    private final CachedRecipe<IAltarRecipe> recipe;
    private int progress;
    private boolean active;

    public StarForgeAltarEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STAR_FORGE_BE.get(), pos, state);
        this.inventory = createInventoryHandler(this::setChangedFast);
        this.recipeInventory = BaseItemStackHandler.create(9);
        this.recipe = new CachedRecipe<>(ModRecipeTypes.STAR_FORGING.get());
    }


    @Override
    public BaseItemStackHandler getInventory() {
        return this.inventory;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        this.progress = tag.getInt("Progress");
        this.active = tag.getBoolean("Active");
    }

    @Override
    public void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        tag.putInt("Progress", this.progress);
        tag.putBoolean("Active", this.active);
    }

    @Override
    public AABB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }

    @Override
    public boolean isActive() {
        if (!this.active) {
            this.active = this.level != null && this.level.hasNeighborSignal(this.getBlockPos());
        }
        return this.active;
    }

    @Override
    public void activate() {
        this.active = true;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, StarForgeAltarEntity altar) {
        var input = altar.inventory.getStackInSlot(0);

        if (input.isEmpty()) {
            altar.reset();
            altar.dispatchIfChanged();
            return;
        }
        if (altar.isActive()) {
            var recipe = altar.getActiveRecipe();

            if (recipe != null) {
                altar.progress++;

                var pedestals = altar.getPedestals();

                if (altar.progress >= 100) {
                    var remaining = recipe.getRemainingItems(altar.recipeInventory.asRecipeWrapper());

                    for (var i = 0; i < pedestals.size(); i++) {
                        var pedestal = pedestals.get(i);
                        pedestal.getInventory().setStackInSlot(0, remaining.get(i + 1));

                    }

                    var result = recipe.assemble(altar.recipeInventory.asRecipeWrapper(), level.registryAccess());

                    altar.setOutput(result, remaining.get(0));
                    altar.reset();
                    altar.setChangedFast();
                } else {
                    for (var pedestal : pedestals) {
                        var pedestalPos = pedestal.getBlockPos();
                        var stack = pedestal.getInventory().getStackInSlot(0);
                    }
                }
            } else {
                altar.reset();
            }
        } else {
            altar.progress = 0;
        }
        altar.dispatchIfChanged();
    }

    public static BaseItemStackHandler createInventoryHandler(Runnable onContentsChanged) {
        return BaseItemStackHandler.create(2, onContentsChanged, builder -> {
            builder.setDefaultSlotLimit(1);
            builder.setCanInsert((slot, stack) -> builder.getStackInSlot(1).isEmpty());
            builder.setOutputSlots(1);
        });
    }

    public List<BlockPos> getPedestalPositions() {
        return this.pedestalLocations.get(this.getBlockPos());
    }

    public IAltarRecipe getActiveRecipe() {
        if (this.level == null)
            return null;

        this.updateRecipeInventory(this.getPedestals());

        return this.recipe.checkAndGet(this.recipeInventory, this.level);
    }

    public void reset() {
        this.progress = 0;
        this.active = false;
    }

    private void updateRecipeInventory(List<StarForgePillarEntity> pedestals) {
        this.recipeInventory.setSize(StarForgingAltar.RECIPE_SIZE);
        this.recipeInventory.setStackInSlot(0, this.inventory.getStackInSlot(0));

        for (int i = 0; i < pedestals.size(); i++) {
            var stack = pedestals.get(i).getInventory().getStackInSlot(0);

            this.recipeInventory.setStackInSlot(i + 1, stack);
        }
    }

    private List<StarForgePillarEntity> getPedestals() {
        if (this.level == null) {
            return Collections.emptyList();
        }

        List<StarForgePillarEntity> pedestals = new ArrayList<>();

        for (var pos : this.getPedestalPositions()) {
            var tile = this.level.getBlockEntity(pos);
            if (tile instanceof StarForgePillarEntity pedestal)
                pedestals.add(pedestal);
        }

        return pedestals;
    }

    private void setOutput(ItemStack stack, ItemStack remaining) {
        var stacks = this.inventory.getStacks();

        stacks.set(0, remaining);
        stacks.set(1, stack);
    }

}