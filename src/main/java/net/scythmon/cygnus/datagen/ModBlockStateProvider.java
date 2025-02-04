package net.scythmon.cygnus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.block.ModBlocks;
import net.scythmon.cygnus.block.custom.ModCropBlock;
import net.scythmon.cygnus.block.custom.ModLeafCropBlock;

import java.util.function.Function;

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
        blockWithItem(ModBlocks.BUDDING_CRYSTAL_OAK_LEAVES);
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
        leavesBlock(ModBlocks.BUDDING_CRYSTAL_OAK_LEAVES);

        blockWithItem(ModBlocks.CRYSTAL_OAK_PLANKS);

        makeCoffeeCrop((CropBlock) ModBlocks.COFFEE_CROP.get(), "coffee_crop_stage", "coffee_crop_stage");

        makeFlowerCrop((CropBlock) ModBlocks.FLOWERING_CRYSTAL_OAK_LEAVES.get(), "flower_crop_stage", "flower_crop_stage");
    }

    public void makeFlowerCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> flowerStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] flowerStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cubeAll(modelName + state.getValue(((ModLeafCropBlock) block).getAgeProperty()),
                new ResourceLocation(ProjectCygnus.MOD_ID, "block/" + textureName + state.getValue(((ModLeafCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeCoffeeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> coffeeStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] coffeeStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((ModCropBlock) block).getAgeProperty()),
                new ResourceLocation(ProjectCygnus.MOD_ID, "block/" + textureName + state.getValue(((ModCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
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
