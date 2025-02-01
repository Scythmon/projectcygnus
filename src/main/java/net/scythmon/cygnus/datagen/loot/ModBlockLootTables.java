package net.scythmon.cygnus.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get());
        this.dropSelf(ModBlocks.BLOOD_STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.ANGEL_GOLD_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.dropSelf(ModBlocks.CRYSTAL_OAK_LOG.get());
        this.dropSelf(ModBlocks.CRYSTAL_OAK_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD.get());
        this.dropSelf(ModBlocks.CRYSTAL_OAK_PLANKS.get());

        this.add(ModBlocks.CRYSTAL_OAK_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.CRYSTAL_OAK_WOOD.get(), NORMAL_LEAVES_SAPLING_CHANCES)); // TODO: Change to a sapling!

        this.add(ModBlocks.FLOWERING_CRYSTAL_OAK_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.CRYSTAL_OAK_WOOD.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.BUDDING_CRYSTAL_OAK_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.CRYSTAL_OAK_WOOD.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
