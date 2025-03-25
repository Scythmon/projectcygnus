package net.scythmon.cygnus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.init.ModBlocks;
import net.scythmon.cygnus.init.ModItems;
import net.scythmon.cygnus.init.ModTags;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipieProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipieProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get())
                .unlockedBy(getHasName(ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get()), has(ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ANGEL_GOLD_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.ANGEL_GOLD.get())
                .unlockedBy(getHasName(ModItems.ANGEL_GOLD.get()), has(ModItems.ANGEL_GOLD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOOD_STEEL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.BLOOD_STEEL.get())
                .unlockedBy(getHasName(ModItems.BLOOD_STEEL.get()), has(ModItems.BLOOD_STEEL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get())
                .pattern("LFS")
                .pattern("UTE")
                .pattern("WFA")
                .define('L', ModItems.LIFE_CONCENTRATE.get())
                .define('F', ModItems.CRYSTAL_BLOOM.get())
                .define('S', ModItems.SPEED_CONCENTRATE.get())
                .define('U', ModItems.UNDEAD_CONCENTRATE.get())
                .define('T', ModItems.ATTUNED_CRYSTAL.get())
                .define('E', ModItems.STRENGTH_CONCENTRATE.get())
                .define('W', ModItems.WITHER_CONCENTRATE.get())
                .define('A', ModItems.STAR_CONCENTRATE.get())
                .unlockedBy(getHasName(ModItems.ATTUNED_CRYSTAL.get()), has(ModItems.ATTUNED_CRYSTAL.get()))
                .save(pWriter, new ResourceLocation(ProjectCygnus.MOD_ID, "concentrated_crystal_cluster") + "_crafted");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WISHING_CORE.get())
                .pattern("SCS")
                .pattern("TNT")
                .pattern("SCS")
                .define('S', ModItems.SINGULARITY_STONE.get())
                .define('C', ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get())
                .define('T', ModItems.ATTUNED_CRYSTAL.get())
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy(getHasName(ModItems.SINGULARITY_STONE.get()), has(ModItems.SINGULARITY_STONE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ALTAR_CORE.get())
                .pattern(" A ")
                .pattern("ATA")
                .pattern(" A ")
                .define('A', ModItems.ANGEL_GOLD.get())
                .define('T', ModItems.ATTUNED_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.ANGEL_GOLD.get()), has(ModItems.ANGEL_GOLD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_CELESTIAL_TALISMAN.get())
                .pattern("BAB")
                .pattern("ATA")
                .pattern("BAB")
                .define('A', ModItems.ANGEL_GOLD.get())
                .define('T', ModItems.ATTUNED_CRYSTAL.get())
                .define('B', ModItems.CRYSTAL_BUDS.get())
                .unlockedBy(getHasName(ModItems.ANGEL_GOLD.get()), has(ModItems.ANGEL_GOLD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_ANGELIC_TALISMAN.get())
                .pattern("HAH")
                .pattern("TCT")
                .pattern("HAH")
                .define('A', ModItems.ANGEL_GOLD.get())
                .define('T', ModItems.CHERUB_TEAR.get())
                .define('H', ModItems.HOLY_WATER.get())
                .define('C', ModItems.EMPTY_CELESTIAL_TALISMAN.get())
                .unlockedBy(getHasName(ModItems.EMPTY_CELESTIAL_TALISMAN.get()), has(ModItems.EMPTY_CELESTIAL_TALISMAN.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SINGULARITY_STONE.get())
                .pattern("TST")
                .pattern("SCS")
                .pattern("TST")
                .define('T', ModItems.ATTUNED_CRYSTAL.get())
                .define('C', ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get())
                .define('S', ModItems.SINGULARITY_SHARD.get())
                .unlockedBy(getHasName(ModItems.SINGULARITY_SHARD.get()), has(ModItems.SINGULARITY_SHARD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ATTUNED_CRYSTAL.get())
                .pattern("PFQ")
                .pattern("GBE")
                .pattern("ACD")
                .define('P', Items.PRISMARINE_CRYSTALS)
                .define('F', ModItems.CRYSTAL_BLOOM.get())
                .define('Q', Items.QUARTZ)
                .define('G', Items.FLINT)
                .define('B', ModItems.CRYSTAL_BERRIES.get())
                .define('E', Items.EMERALD)
                .define('A', Items.AMETHYST_SHARD)
                .define('C', ModItems.CRYSTAL_BUDS.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.CRYSTAL_BLOOM.get()), has(ModItems.CRYSTAL_BLOOM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_HARBINGER_TALISMAN.get())
                .pattern("BSC")
                .pattern("FTF")
                .pattern("CSB")
                .define('B', ModItems.BOTTLED_BLOOD.get())
                .define('S', ModItems.BLOOD_STEEL.get())
                .define('C', ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get())
                .define('F', ModItems.CRYSTAL_BLOOM.get())
                .define('T', ModItems.EMPTY_CELESTIAL_TALISMAN.get())
                .unlockedBy(getHasName(ModItems.EMPTY_CELESTIAL_TALISMAN.get()), has(ModItems.EMPTY_CELESTIAL_TALISMAN.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_FETID_TALISMAN.get())
                .pattern("BSC")
                .pattern("FTF")
                .pattern("CSB")
                .define('B', ModItems.BOTTLED_BLOOD.get())
                .define('S', ModItems.BLOOD_STEEL.get())
                .define('C', ModItems.CRYSTAL_BERRIES.get())
                .define('F', ModItems.STARFLAME.get())
                .define('T', ModItems.EMPTY_CELESTIAL_TALISMAN.get())
                .unlockedBy(getHasName(ModItems.EMPTY_CELESTIAL_TALISMAN.get()), has(ModItems.EMPTY_CELESTIAL_TALISMAN.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMPTY_WATCHING_TALISMAN.get())
                .pattern("CBC")
                .pattern("FWH")
                .pattern("CBC")
                .define('B', ModItems.BOTTLED_BLOOD.get())
                .define('C', ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get())
                .define('F', ModItems.EMPTY_FETID_TALISMAN.get())
                .define('H', ModItems.EMPTY_HARBINGER_TALISMAN.get())
                .define('W', ModItems.WISHING_CORE.get())
                .unlockedBy(getHasName(ModItems.WISHING_CORE.get()), has(ModItems.WISHING_CORE.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STAR.get())
                .pattern("CUC")
                .pattern("NSN")
                .pattern("CUC")
                .define('C', ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get())
                .define('U', ModItems.UNSTABLE_SINGULARITY.get())
                .define('N', Items.NETHERITE_INGOT)
                .define('S', Items.NETHER_STAR)
                .unlockedBy(getHasName(Items.NETHER_STAR), has(Items.NETHER_STAR))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STARFLAME.get())
                .pattern("FBF")
                .pattern("BTB")
                .pattern("FBF")
                .define('T', ModItems.ATTUNED_CRYSTAL.get())
                .define('F', Items.FIRE_CHARGE)
                .define('B', Items.BLAZE_POWDER)
                .unlockedBy(getHasName(ModItems.ATTUNED_CRYSTAL.get()), has(ModItems.ATTUNED_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VEILED_CARD.get())
                .pattern("CPC")
                .pattern("PTP")
                .pattern("CPC")
                .define('C', ModTags.Items.HIGH_TIER_CONCENTRATES)
                .define('P', Items.PAPER)
                .define('T', ModItems.TAROT_DECK.get())
                .unlockedBy(getHasName(ModItems.TAROT_DECK.get()), has(ModItems.TAROT_DECK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CULTIST_KNIFE.get())
                .pattern("  I")
                .pattern(" E ")
                .pattern("S  ")
                .define('I', Items.IRON_INGOT)
                .define('E', Items.ENDER_EYE)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE))
                .save(pWriter);



        //SHAPELESS ------------------------------------------------------------------------------------

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BROWNIE.get(), 2)
                .requires(Items.COCOA_BEANS)
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COFFEE.get(), 2)
                .requires(Items.GLASS_BOTTLE)
                .requires(ModItems.COFFEE_BEANS.get())
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(Items.GLASS_BOTTLE), has(Items.GLASS_BOTTLE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ONEH_MOTER.get(), 1)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.WITHER_ROSE)
                .unlockedBy(getHasName(Items.WITHER_ROSE), has(Items.WITHER_ROSE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BOOK_OF_ENOCH.get())
                .requires(Items.BOOK)
                .requires(ModItems.STARFLAME.get())
                .unlockedBy(getHasName(ModItems.STARFLAME.get()), has(ModItems.STARFLAME.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PRAYER_BOOK.get())
                .requires(Items.BOOK)
                .requires(Items.ENDER_EYE)
                .requires(Items.GOLDEN_APPLE)
                .unlockedBy(getHasName(Items.ENDER_EYE), has(Items.ENDER_EYE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ANGEL_GOLD.get(), 4)
                .requires(Items.GOLD_INGOT)
                .requires(Items.GOLD_INGOT)
                .requires(Items.GOLD_INGOT)
                .requires(ModItems.HOLY_WATER.get())
                .unlockedBy(getHasName(ModItems.HOLY_WATER.get()), has(ModItems.HOLY_WATER.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLOOD_STEEL.get(), 4)
                .requires(Items.IRON_INGOT)
                .requires(Items.IRON_INGOT)
                .requires(Items.COPPER_INGOT)
                .requires(ModItems.BOTTLED_BLOOD.get())
                .unlockedBy(getHasName(ModItems.BOTTLED_BLOOD.get()), has(ModItems.BOTTLED_BLOOD.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CRYSTAL_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.CRYSTAL_OAK_LOG.get())
                .unlockedBy(getHasName(ModBlocks.CRYSTAL_OAK_LOG.get()), has(ModBlocks.CRYSTAL_OAK_LOG.get()))
                .save(pWriter, new ResourceLocation(ProjectCygnus.MOD_ID, "crystal_oak_planks") + "_from_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CRYSTAL_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get()), has(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get()))
                .save(pWriter, new ResourceLocation(ProjectCygnus.MOD_ID, "crystal_oak_planks") + "_from_stripped_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CRYSTAL_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.CRYSTAL_OAK_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.CRYSTAL_OAK_WOOD.get()), has(ModBlocks.CRYSTAL_OAK_WOOD.get()))
                .save(pWriter, new ResourceLocation(ProjectCygnus.MOD_ID, "crystal_oak_planks") + "_from_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CRYSTAL_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD.get()), has(ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD.get()))
                .save(pWriter, new ResourceLocation(ProjectCygnus.MOD_ID, "crystal_oak_planks") + "_from_stripped_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.NETHER_WART, 9)
                .requires(Blocks.NETHER_WART_BLOCK)
                .unlockedBy(getHasName(Blocks.NETHER_WART_BLOCK), has(Blocks.NETHER_WART_BLOCK))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.AMETHYST_SHARD, 4)
                .requires(Blocks.AMETHYST_BLOCK)
                .unlockedBy(getHasName(Blocks.AMETHYST_BLOCK), has(Blocks.AMETHYST_BLOCK))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PRISMARINE_SHARD, 9)
                .requires(Blocks.PRISMARINE_BRICKS)
                .unlockedBy(getHasName(Blocks.PRISMARINE_BRICKS), has(Blocks.PRISMARINE_BRICKS))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ANGEL_GOLD.get(), 9)
                .requires(ModBlocks.ANGEL_GOLD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ANGEL_GOLD_BLOCK.get()), has(ModBlocks.ANGEL_GOLD_BLOCK.get()))
                .save(pWriter, new ResourceLocation(ProjectCygnus.MOD_ID, "angel_gold") + "_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLOOD_STEEL.get(), 9)
                .requires(ModBlocks.BLOOD_STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BLOOD_STEEL_BLOCK.get()), has(ModBlocks.BLOOD_STEEL_BLOCK.get()))
                .save(pWriter, new ResourceLocation(ProjectCygnus.MOD_ID, "blood_steel") + "_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get(), 9)
                .requires(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get()), has(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get()))
                .save(pWriter, new ResourceLocation(ProjectCygnus.MOD_ID, "concentrated_crystal_cluster") + "_from_block");
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, ProjectCygnus.MOD_ID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
