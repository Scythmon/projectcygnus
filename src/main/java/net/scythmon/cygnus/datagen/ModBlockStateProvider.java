package net.scythmon.cygnus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.init.ModBlocks;
import net.scythmon.cygnus.block.custom.ModCropBlock;
import net.scythmon.cygnus.block.custom.onetimeclasses.ModLeafCropBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ProjectCygnus.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.ATTUNED_CRYSTAL_ORE);
        blockWithItem(ModBlocks.ATTUNED_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.BLOOD_STEEL_BLOCK);
        blockWithItem(ModBlocks.ANGEL_GOLD_BLOCK);
        blockWithItem(ModBlocks.CRYSTAL_OAK_LEAVES);
        blockWithItem(ModBlocks.BUDDING_CRYSTAL_OAK_LEAVES);
        blockWithItem(ModBlocks.TEST_BLOCK_RED);
        blockWithItem(ModBlocks.BUDDING_ATTUNED_AMETHYST);


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

        saplingBlock(ModBlocks.CRYSTAL_VINES);
        saplingBlock(ModBlocks.CRYSTAL_VINES_PLANT);

        saplingBlock(ModBlocks.CRYSTAL_OAK_SAPLING);

        blockWithItem(ModBlocks.CRYSTAL_OAK_PLANKS);

        stairsBlock(((StairBlock) ModBlocks.CRYSTAL_OAK_STAIRS.get()), blockTexture(ModBlocks.CRYSTAL_OAK_PLANKS.get()));
        slabBlock(((SlabBlock) ModBlocks.CRYSTAL_OAK_SLAB.get()), blockTexture(ModBlocks.CRYSTAL_OAK_PLANKS.get()), blockTexture(ModBlocks.CRYSTAL_OAK_PLANKS.get()));

        buttonBlock(((ButtonBlock) ModBlocks.CRYSTAL_OAK_BUTTON.get()), blockTexture(ModBlocks.CRYSTAL_OAK_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CRYSTAL_OAK_PRESSURE_PLATE.get()), blockTexture(ModBlocks.CRYSTAL_OAK_PLANKS.get()));

        fenceBlock(((FenceBlock) ModBlocks.CRYSTAL_OAK_FENCE.get()), blockTexture(ModBlocks.CRYSTAL_OAK_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.CRYSTAL_OAK_FENCE_GATE.get()), blockTexture(ModBlocks.CRYSTAL_OAK_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.CRYSTAL_OAK_DOOR.get()), modLoc("block/crystal_oak_door_bottom"), modLoc("block/crystal_oak_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.CRYSTAL_OAK_TRAPDOOR.get()), modLoc("block/crystal_oak_trapdoor"), true, "cutout");

        makeCoffeeCrop((CropBlock) ModBlocks.COFFEE_CROP.get(), "coffee_crop_stage", "coffee_crop_stage");

        makeFlowerCrop((CropBlock) ModBlocks.FLOWERING_CRYSTAL_OAK_LEAVES.get(), "flower_crop_stage", "flower_crop_stage");


        simpleBlockWithItem(ModBlocks.CRYSTAL_LILY.get(), models().cross(blockTexture(ModBlocks.CRYSTAL_LILY.get()).getPath(),
                blockTexture(ModBlocks.CRYSTAL_LILY.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_CRYSTAL_LILY.get(), models().singleTexture("potted_crystal_lily", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.CRYSTAL_LILY.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.BLOOD_CARDINAL.get(), models().cross(blockTexture(ModBlocks.BLOOD_CARDINAL.get()).getPath(),
                blockTexture(ModBlocks.BLOOD_CARDINAL.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_BLOOD_CARDINAL.get(), models().singleTexture("potted_blood_cardinal", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.BLOOD_CARDINAL.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.JUDGES_LILIES.get(), models().cross(blockTexture(ModBlocks.JUDGES_LILIES.get()).getPath(),
                blockTexture(ModBlocks.JUDGES_LILIES.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_JUDGES_LILIES.get(), models().singleTexture("potted_judges_lilies", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.JUDGES_LILIES.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.FESTERED_PIMPERNEL.get(), models().cross(blockTexture(ModBlocks.FESTERED_PIMPERNEL.get()).getPath(),
                blockTexture(ModBlocks.FESTERED_PIMPERNEL.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_FESTERED_PIMPERNEL.get(), models().singleTexture("potted_festered_pimpernel", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.FESTERED_PIMPERNEL.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.CHOIRS_GEM.get(), models().cross(blockTexture(ModBlocks.CHOIRS_GEM.get()).getPath(),
                blockTexture(ModBlocks.CHOIRS_GEM.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_CHOIRS_GEM.get(), models().singleTexture("potted_choirs_gem", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.CHOIRS_GEM.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.SPECKLED_BUSH.get(), models().cross(blockTexture(ModBlocks.SPECKLED_BUSH.get()).getPath(),
                blockTexture(ModBlocks.SPECKLED_BUSH.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_SPECKLED_BUSH.get(), models().singleTexture("potted_speckled_bush", new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.SPECKLED_BUSH.get())).renderType("cutout"));


        simpleBlockWithItem(ModBlocks.STAR_FORGE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/star_forge")));
        simpleBlockWithItem(ModBlocks.STAR_FORGE_PILLAR.get(),
               new ModelFile.UncheckedModelFile(modLoc("block/star_forge_pillar")));
        simpleBlockWithItem(ModBlocks.CARNAGE_ALTAR.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/carnage_altar")));
        simpleBlockWithItem(ModBlocks.LIFE_ALTAR.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/life_altar")));
        simpleBlockWithItem(ModBlocks.STARS_ALTAR.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/stars_altar")));
        simpleBlockWithItem(ModBlocks.ANGELIC_ALTAR.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/angelic_altar")));
    }

    //All the stoff down here is just custom methods to make life a bit easier, probably an easier way to do it but this is what works for me

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

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
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
