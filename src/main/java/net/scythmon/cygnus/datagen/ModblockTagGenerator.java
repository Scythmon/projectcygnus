package net.scythmon.cygnus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.block.ModBlocks;
import net.scythmon.cygnus.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModblockTagGenerator extends BlockTagsProvider {
    public ModblockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ProjectCygnus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.ATTUNED_CRYSTAL_ORE.get()).addTag(Tags.Blocks.ORES);



        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get())
                .add(ModBlocks.BLOOD_STEEL_BLOCK.get())
                .add(ModBlocks.ATTUNED_CRYSTAL_ORE.get())
                .add(ModBlocks.ANGEL_GOLD_BLOCK.get())
                .add(ModBlocks.BUDDING_ATTUNED_AMETHYST.get())
                .add(ModBlocks.ATTUNED_CRYSTAL_BLOCK.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.ATTUNED_CRYSTAL_ORE.get())
                .add(ModBlocks.ATTUNED_CRYSTAL_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get())
                .add(ModBlocks.BLOOD_STEEL_BLOCK.get())
                .add(ModBlocks.ANGEL_GOLD_BLOCK.get())
                .add(ModBlocks.BUDDING_ATTUNED_AMETHYST.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.CRYSTAL_OAK_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.CRYSTAL_OAK_FENCE_GATE.get());


        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRYSTAL_OAK_LOG.get())
                .add(ModBlocks.CRYSTAL_OAK_WOOD.get())
                .add(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get())
                .add(ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD.get());
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.CRYSTAL_OAK_PLANKS.get());

    }
}
