package net.scythmon.cygnus.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ProjectCygnus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Food Item

        simpleItem(ModItems.BROWNIE);
        simpleItem(ModItems.CRYSTAL_BERRIES);
        simpleItem(ModItems.CRYSTAL_FLOWER);
        simpleItem(ModItems.COFFEE);
        // Tier one crafting items

        simpleItem(ModItems.TRUE_CRYSTAL);
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

        //ignore this

        simpleItem(ModItems.METAL_DETECTOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ProjectCygnus.MOD_ID, "item/" + item.getId().getPath()));
    }
}
