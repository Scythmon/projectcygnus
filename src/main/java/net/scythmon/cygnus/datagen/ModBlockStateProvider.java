package net.scythmon.cygnus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ProjectCygnus.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.BLOOD_STEEL_BLOCK);
        blockWithItem(ModBlocks.ANGEL_GOLD_BLOCK);
        blockWithItem(ModBlocks.CRYSTAL_OAK_LEAVES);
        blockWithItem(ModBlocks.SOUND_BLOCK);

        logBlock(((RotatedPillarBlock) ModBlocks.CRYSTAL_OAK_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.CRYSTAL_OAK_WOOD.get()), blockTexture(ModBlocks.CRYSTAL_OAK_LOG.get()), blockTexture(ModBlocks.CRYSTAL_OAK_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get()), blockTexture(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get()),
                    new ResourceLocation(ProjectCygnus.MOD_ID, "block/stripped_crystal_oak_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD.get()), blockTexture(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get()));

        blockItem(ModBlocks.CRYSTAL_OAK_LOG);
        blockItem(ModBlocks.CRYSTAL_OAK_WOOD);
        blockItem(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG);
        blockItem(ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD);

        leavesBlock(ModBlocks.CRYSTAL_OAK_LEAVES);

        blockWithItem(ModBlocks.CRYSTAL_OAK_PLANKS);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));

    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(ProjectCygnus.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
