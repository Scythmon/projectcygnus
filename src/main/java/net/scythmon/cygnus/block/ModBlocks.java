package net.scythmon.cygnus.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.block.custom.*;
import net.scythmon.cygnus.items.ModItems;
import net.scythmon.cygnus.worldgen.tree.CrystalTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ProjectCygnus.MOD_ID);
    //Crystalline blocks

    public static final RegistryObject<Block> ATTUNED_CRYSTAL_ORE = registerBlock("attuned_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final  RegistryObject<Block> CONCENTRATED_CRYSTAL_BLOCK = registerBlock("concentrated_crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> BUDDING_ATTUNED_AMETHYST = registerBlock("budding_attuned_amethyst",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    public static final  RegistryObject<Block> TEST_BLOCK_RED = registerBlock("test_block_red",
            () -> new Hi(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).sound(SoundType.AMETHYST)));

    public static final  RegistryObject<Block> BLOOD_STEEL_BLOCK = registerBlock("blood_steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final  RegistryObject<Block> ANGEL_GOLD_BLOCK = registerBlock("angel_gold_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));

    public static final  RegistryObject<Block> ATTUNED_CRYSTAL_BLOCK = registerBlock("attuned_crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> CRYSTAL_OAK_LOG = registerBlock("crystal_oak_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(3.0f)));

    public static final RegistryObject<Block> CRYSTAL_OAK_WOOD = registerBlock("crystal_oak_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(3.0f)));

    public static final RegistryObject<Block> STRIPPED_CRYSTAL_OAK_LOG = registerBlock("stripped_crystal_oak_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(3.0f)));


    public static final RegistryObject<Block> STRIPPED_CRYSTAL_OAK_WOOD = registerBlock("stripped_crystal_oak_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(3.0f)));

    public static final RegistryObject<Block> COFFEE_CROP = BLOCKS.register("coffee_crop",
            () -> new ModCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));

    public static final RegistryObject<Block> FLOWERING_CRYSTAL_OAK_LEAVES = BLOCKS.register("flowering_crystal_oak_leaves",
            () -> new ModLeafCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).destroyTime(0.3f).noOcclusion()));

    public static final RegistryObject<Block> CRYSTAL_OAK_PLANKS = registerBlock("crystal_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0f)));

    public static final RegistryObject<Block> CRYSTAL_OAK_STAIRS = registerBlock("crystal_oak_stairs",
            () -> new StairBlock(() -> ModBlocks.CRYSTAL_OAK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CRYSTAL_OAK_SLAB = registerBlock("crystal_oak_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD)));


    public static final RegistryObject<Block> CRYSTAL_OAK_BUTTON = registerBlock("crystal_oak_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.OAK, 5, true));

    public static final RegistryObject<Block> CRYSTAL_OAK_PRESSURE_PLATE = registerBlock("crystal_oak_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> CRYSTAL_OAK_FENCE = registerBlock("crystal_oak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> CRYSTAL_OAK_FENCE_GATE = registerBlock("crystal_oak_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> CRYSTAL_OAK_SAPLING = registerBlock("crystal_oak_sapling",
            () -> new SaplingBlock(new CrystalTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));



    public static final RegistryObject<Block> CRYSTAL_OAK_DOOR = registerBlock("crystal_oak_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> CRYSTAL_OAK_TRAPDOOR = registerBlock("crystal_oak_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).sound(SoundType.WOOD).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> CRYSTAL_OAK_LEAVES = registerBlock("crystal_oak_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).destroyTime(0.3f).strength(1.0f)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            });




    public static final RegistryObject<Block> BUDDING_CRYSTAL_OAK_LEAVES = registerBlock("budding_crystal_oak_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).destroyTime(0.3f).strength(1.0f)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }



            });

    public static final RegistryObject<Block> STAR_FORGE = registerBlock("star_forge",
            () -> new StarForgeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> STAR_FORGE_PILLAR = registerBlock("star_forge_pillar",
            () -> new StarForgePillar(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));



    //FLOWERS :D, the effect is there as it's required for sus stew

    public static final RegistryObject<Block> CRYSTAL_LILY = registerBlock("crystal_lily",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> BLOOD_CARDINAL = registerBlock("blood_cardinal",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> JUDGES_LILIES = registerBlock("judges_lilies",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> FESTERED_PIMPERNEL = registerBlock("festered_pimpernel",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> CHOIRS_GEM = registerBlock("choirs_gem",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> FERRO_CLOVERS = registerBlock("ferro_clovers",
            () -> new FerroClover(BlockBehaviour.Properties.copy(Blocks.PINK_PETALS).noOcclusion().noCollission()));

    public static final RegistryObject<Block> ARCHITECT_CORPSE = registerBlock("architect_corpse",
            () -> new SporeBlossomBlock(BlockBehaviour.Properties.copy(Blocks.SPORE_BLOSSOM).noOcclusion().noCollission()));




    //IMPORTANT, use the BLOCKS.register method to add the potted versions ot else it will break, also make sure to add the corresponding event to the ProjectCygnus class under CommonSetup

    public static final RegistryObject<Block> POTTED_CRYSTAL_LILY = BLOCKS.register("potted_crystal_lily",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.CRYSTAL_LILY,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));


    public static final RegistryObject<Block> POTTED_BLOOD_CARDINAL = BLOCKS.register("potted_blood_cardinal",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.BLOOD_CARDINAL,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> POTTED_JUDGES_LILIES = BLOCKS.register("potted_judges_lilies",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.JUDGES_LILIES,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> POTTED_FESTERED_PIMPERNEL = BLOCKS.register("potted_festered_pimpernel",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.FESTERED_PIMPERNEL,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));

    public static final RegistryObject<Block> POTTED_CHOIRS_GEM = BLOCKS.register("potted_choirs_gem",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.CHOIRS_GEM,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_ALLIUM).noOcclusion()));


    public static final RegistryObject<Block> CRYSTAL_VINES_PLANT = registerBlock("crystal_vines_plant",
            () -> new CrystalVinesPlantBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN).noCollission().instabreak().sound(SoundType.VINE).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> CRYSTAL_VINES = registerBlock("crystal_vines",
            () -> new CrystalVinesBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN).randomTicks().noCollission().instabreak().sound(SoundType.VINE).pushReaction(PushReaction.DESTROY)));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register((eventBus));
    }
}
