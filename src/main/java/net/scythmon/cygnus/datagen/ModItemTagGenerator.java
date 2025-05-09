package net.scythmon.cygnus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeItemTagsProvider;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.init.ModBlocks;
import net.scythmon.cygnus.init.ModItems;
import net.scythmon.cygnus.init.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ProjectCygnus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.CRYSTAL_OAK_LOG.get().asItem())
                .add(ModBlocks.CRYSTAL_OAK_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get().asItem());
        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.CRYSTAL_OAK_PLANKS.get().asItem());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get());

        this.tag(ModTags.Items.HIGH_TIER_CONCENTRATES)
                .add(ModItems.STAR_CONCENTRATE.get())
                .add(ModItems.UNDEAD_CONCENTRATE.get())
                .add(ModItems.THRONE_TEAR.get());
        }
}
