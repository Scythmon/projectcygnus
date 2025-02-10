package net.scythmon.cygnus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.block.ModBlocks;
import net.scythmon.cygnus.items.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ProjectCygnus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        //FLOWERDDSSDF
        simpleBlockItemBlockTexture(ModBlocks.CRYSTAL_LILY);
        simpleBlockItemBlockTexture(ModBlocks.BLOOD_CARDINAL);
        simpleBlockItemBlockTexture(ModBlocks.JUDGES_LILIES);
        simpleBlockItemBlockTexture(ModBlocks.FESTERED_PIMPERNEL);
        simpleBlockItemBlockTexture(ModBlocks.CHOIRS_GEM);
        simpleBlockItemBlockTexture(ModBlocks.FERRO_CLOVERS);
        simpleBlockItemBlockTexture(ModBlocks.ARCHITECT_CORPSE);

        //Food Item

        simpleItem(ModItems.BROWNIE);
        simpleItem(ModItems.CRYSTAL_BERRIES);
        simpleItem(ModItems.CRYSTAL_BLOOM);
        simpleItem(ModItems.COFFEE);
        simpleItem(ModItems.COFFEE_SEEDS);
        simpleItem(ModItems.COFFEE_BEANS);

        saplingItem(ModBlocks.CRYSTAL_OAK_SAPLING);

        simpleItem(ModItems.ONEH_MOTER);

        //Crystal gen

        simpleBlockItem(ModBlocks.CRYSTAL_OAK_DOOR);

        fenceItem(ModBlocks.CRYSTAL_OAK_FENCE, ModBlocks.CRYSTAL_OAK_PLANKS);
        buttonItem(ModBlocks.CRYSTAL_OAK_BUTTON, ModBlocks.CRYSTAL_OAK_PLANKS);

        evenSimplerBlockItem(ModBlocks.CRYSTAL_OAK_STAIRS);
        evenSimplerBlockItem(ModBlocks.CRYSTAL_OAK_SLAB);
        evenSimplerBlockItem(ModBlocks.CRYSTAL_OAK_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.CRYSTAL_OAK_FENCE_GATE);

        trapdoorItem(ModBlocks.CRYSTAL_OAK_TRAPDOOR);

        //Precrafting
        simpleItem(ModItems.CULTIST_KNIFE);
        simpleItem(ModItems.BOTTLED_BLOOD);
        simpleItem(ModItems.HOLY_WATER);
        simpleItem(ModItems.CRYSTAL_BUDS);
        simpleItem(ModItems.BOOK_OF_ENOCH);
        simpleItem(ModItems.PRAYER_BOOK);
        // Tier one crafting items

        simpleItem(ModItems.ATTUNED_CRYSTAL);
        simpleItem(ModItems.STARFLAME);
        simpleItem(ModItems.BLOOD_STEEL);
        simpleItem(ModItems.ANGEL_GOLD);
        simpleItem(ModItems.ALTAR_CORE);

        //Tier two crafting items

        simpleItem(ModItems.WITHER_CONCENTRATE);
        simpleItem(ModItems.UNDEAD_CONCENTRATE);
        simpleItem(ModItems.STRENGTH_CONCENTRATE);
        simpleItem(ModItems.STAR_CONCENTRATE);
        simpleItem(ModItems.SPEED_CONCENTRATE);
        simpleItem(ModItems.LIFE_CONCENTRATE);
        simpleItem(ModItems.THRONE_TEAR);
        simpleItem(ModItems.CHERUB_TEAR);
        simpleItem(ModItems.DOMINION_TEAR);
        simpleItem(ModItems.CONCENTRATED_CRYSTAL_CLUSTER);
        simpleItem(ModItems.EMPTY_CELESTIAL_TALISMAN);
        simpleItem(ModItems.STAR);

        //Tier three crafting items

        simpleItem(ModItems.EMPTY_ANGELIC_TALISMAN);
        simpleItem(ModItems.FELL_STAR_PLATE);
        simpleItem(ModItems.CARNAGE_PLATE);
        simpleItem(ModItems.AFTERLIFE_PLATE);
        simpleItem(ModItems.ANGEL_PLATE);
        simpleItem(ModItems.SINGULARITY_SHARD);
        simpleItem(ModItems.SINGULARITY_STONE);
        simpleItem(ModItems.UNSTABLE_SINGULARITY);


        //Tier 4 crafting

        simpleItem(ModItems.WISHING_CORE);
        simpleItem(ModItems.WISHING_TOKEN);
        simpleItem(ModItems.EMPTY_HARBINGER_TALISMAN);
        simpleItem(ModItems.EMPTY_WATCHING_TALISMAN);
        simpleItem(ModItems.EMPTY_FETID_TALISMAN);

        //Filled celestial talisman

        simpleItem(ModItems.DAMNED_CONJURE_TALISMAN);
        simpleItem(ModItems.VITALITY_CONJURE_TALISMAN);
        simpleItem(ModItems.WITHER_CONJURE_TALISMAN);
        simpleItem(ModItems.LIGHTNING_CONJURE_TALISMAN);
        simpleItem(ModItems.ENFLAMED_CONJURE_TALISMAN);
        simpleItem(ModItems.STAR_CONJURE_TALISMAN);
        simpleItem(ModItems.DOMINION_CONJURE_TALISMAN);
        simpleItem(ModItems.CHERUB_CONJURE_TALISMAN);
        simpleItem(ModItems.THRONE_CONJURE_TALISMAN);

        //Filled Carnage Talismans

        simpleItem(ModItems.WATCHING_CONJURE_TALISMAN);
        simpleItem(ModItems.DEATH_CONJURE_TALISMAN);
        simpleItem(ModItems.CONQUEST_CONJURE_TALISMAN);
        simpleItem(ModItems.FAMINE_CONJURE_TALISMAN);
        simpleItem(ModItems.PESTILENCE_CONJURE_TALISMAN);

        //Boss Drops

        simpleItem(ModItems.UNDEAD_ESSENCE);
        simpleItem(ModItems.VITALITY_ESSENCE);
        simpleItem(ModItems.WITHER_ESSENCE);
        simpleItem(ModItems.LIGHTNING_ESSENCE);
        simpleItem(ModItems.STAR_ESSENCE);
        simpleItem(ModItems.ENFLAMED_ESSENCE);
        simpleItem(ModItems.SOUL_OF_FLAMING_CHOIRS);
        simpleItem(ModItems.SOUL_OF_CRUMBLING_HEAVENS);
        simpleItem(ModItems.SOUL_OF_GODLY_JUDGEMENT);

        //Armor ---------------------------------------------------------------
        simpleItem(ModItems.MASK_OF_THE_DAMNED);
        simpleItem(ModItems.MASK_OF_VITALITY);
        simpleItem(ModItems.MASK_OF_WITHERING);
        simpleItem(ModItems.AWAKENED_MASK_OF_THE_DAMNED);
        simpleItem(ModItems.AWAKENED_MASK_OF_VITALITY);
        simpleItem(ModItems.AWAKENED_MASK_OF_WITHERING);
        simpleItem(ModItems.STAR_CROWN);
        simpleItem(ModItems.STRENGTH_CROWN);
        simpleItem(ModItems.SPEED_CROWN);
        simpleItem(ModItems.EMPOWERED_CROWN_OF_SPEED);
        simpleItem(ModItems.EMPOWERED_CROWN_OF_STARS);
        simpleItem(ModItems.EMPOWERED_CROWN_OF_STRENGTH);
        simpleItem(ModItems.DEATH_BIRD_HELMET);
        simpleItem(ModItems.DEATH_BIRD_CHESTPLATE);
        simpleItem(ModItems.DEATH_BIRD_LEGGINGS);
        simpleItem(ModItems.DEATH_BIRD_BOOTS);
        simpleItem(ModItems.PLAGUED_LORD_HELMET);
        simpleItem(ModItems.PLAGUED_LORD_CHESTPLATE);
        simpleItem(ModItems.PLAGUED_LORD_LEGGINGS);
        simpleItem(ModItems.PLAGUED_LORD_BOOTS);
        simpleItem(ModItems.FAMINE_HELMET);
        simpleItem(ModItems.FAMINE_CHESTPLATE);
        simpleItem(ModItems.FAMINE_LEGGINGS);
        simpleItem(ModItems.FAMINE_BOOTS);
        simpleItem(ModItems.CONQUEST_HELMET);
        simpleItem(ModItems.CONQUEST_CHESTPLATE);
        simpleItem(ModItems.CONQUEST_LEGGINGS);
        simpleItem(ModItems.CONQUEST_BOOTS);

        //No-Creative Items for Stratus' lore
        simpleItem(ModItems.FIRST_RITUAL_KNIFE);
        simpleItem(ModItems.HEART_OF_FLAMES);
        simpleItem(ModItems.NULL_CATALYST_TALISMAN);
        simpleItem(ModItems.POWER_BOOSTER_CANISTER);
        simpleItem(ModItems.POWER_BOOSTER_NEEDLE);
        simpleItem(ModItems.SHATTERED_RELIC);
        simpleItem(ModItems.STARMAN_SIGIL);


        //ignore this
        withExistingParent(ModItems.TIGER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        simpleItem(ModItems.METAL_DETECTOR);
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ProjectCygnus.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ProjectCygnus.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ProjectCygnus.MOD_ID,"block/" + item.getId().getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(ProjectCygnus.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(ProjectCygnus.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ProjectCygnus.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ProjectCygnus.MOD_ID, "item/" + item.getId().getPath()));
    }
}
