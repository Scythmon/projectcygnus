package net.scythmon.cygnus.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectCygnus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CYGNUS_ITEMS = CREATIVE_MODE_TABS.register("cygnus_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STAR.get()))
                    .title(Component.translatable("creativetab.cygnus_items_tab"))
                    .displayItems(((pParameters, pOutput) -> {
            //Item progression can be found in the comments of the ModItems class, this is formatted as such to make the creative tab more appealing to look at

                        //Placeholder spot
                        pOutput.accept(ModItems.STAR.get());
                        pOutput.accept(ModItems.BOOK_OF_ENOCH.get());
                        pOutput.accept(ModItems.PRAYER_BOOK.get());
                        pOutput.accept(ModItems.CULTIST_KNIFE.get());
                        pOutput.accept(ModItems.BOTTLED_BLOOD.get());
                        pOutput.accept(ModItems.HOLY_WATER.get());
                        pOutput.accept(ModItems.CRYSTAL_BUDS.get());
                        pOutput.accept(ModItems.CRYSTAL_BLOOM.get());
                        pOutput.accept(ModItems.CRYSTAL_BERRIES.get());
                        pOutput.accept(ModBlocks.CRYSTAL_VINES.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_SAPLING.get());
                        pOutput.accept(ModBlocks.CRYSTAL_LILY.get());
                        pOutput.accept(ModBlocks.BLOOD_CARDINAL.get());
                        pOutput.accept(ModBlocks.JUDGES_LILIES.get());
                        pOutput.accept(ModBlocks.FESTERED_PIMPERNEL.get());
                        pOutput.accept(ModBlocks.CHOIRS_GEM.get());
                        pOutput.accept(ModBlocks.FERRO_CLOVERS.get());
                        pOutput.accept(ModBlocks.ARCHITECT_CORPSE.get());
                        pOutput.accept(ModBlocks.SPECKLED_BUSH.get());

                        pOutput.accept(ModItems.ONEH_MOTER.get());
                        pOutput.accept(ModItems.COFFEE_SEEDS.get());

                        //Crystal Items
                        pOutput.accept(ModItems.ATTUNED_CRYSTAL.get());



                        //Metal?
                        pOutput.accept(ModItems.BLOOD_STEEL.get());
                        pOutput.accept(ModItems.ANGEL_GOLD.get());
                        pOutput.accept(ModItems.ALTAR_CORE.get());


                        pOutput.accept(ModItems.CHERUB_TEAR.get());
                        pOutput.accept(ModItems.DOMINION_TEAR.get());
                        pOutput.accept(ModItems.THRONE_TEAR.get());
                        pOutput.accept(ModItems.WITHER_CONCENTRATE.get());
                        pOutput.accept(ModItems.LIFE_CONCENTRATE.get());
                        pOutput.accept(ModItems.UNDEAD_CONCENTRATE.get());
                        pOutput.accept(ModItems.SPEED_CONCENTRATE.get());
                        pOutput.accept(ModItems.STRENGTH_CONCENTRATE.get());
                        pOutput.accept(ModItems.STAR_CONCENTRATE.get());
                        pOutput.accept(ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get());
                        pOutput.accept(ModItems.STARFLAME.get());



                        //Plates
                        pOutput.accept(ModItems.FELL_STAR_PLATE.get());
                        pOutput.accept(ModItems.AFTERLIFE_PLATE.get());
                        pOutput.accept(ModItems.ANGEL_PLATE.get());
                        pOutput.accept(ModItems.CARNAGE_PLATE.get());

                        //Singularities/Wishing
                        pOutput.accept(ModItems.SINGULARITY_SHARD.get());
                        pOutput.accept(ModItems.UNSTABLE_SINGULARITY.get());
                        pOutput.accept(ModItems.SINGULARITY_STONE.get());
                        pOutput.accept(ModItems.WISHING_CORE.get());
                        pOutput.accept(ModItems.WISHING_TOKEN.get());


                        //Empty Talismans
                        pOutput.accept(ModItems.EMPTY_ANGELIC_TALISMAN.get());
                        pOutput.accept(ModItems.EMPTY_CELESTIAL_TALISMAN.get());
                        pOutput.accept(ModItems.EMPTY_HARBINGER_TALISMAN.get());
                        pOutput.accept(ModItems.EMPTY_FETID_TALISMAN.get());
                        pOutput.accept(ModItems.EMPTY_WATCHING_TALISMAN.get());

                        //Filled Celestial Talismans
                        pOutput.accept(ModItems.DAMNED_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.VITALITY_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.WITHER_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.LIGHTNING_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.ENFLAMED_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.STAR_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.DOMINION_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.CHERUB_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.THRONE_CONJURE_TALISMAN.get());

                        //Filled Carnage Talismans
                        pOutput.accept(ModItems.WATCHING_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.DEATH_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.FAMINE_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.CONQUEST_CONJURE_TALISMAN.get());
                        pOutput.accept(ModItems.PESTILENCE_CONJURE_TALISMAN.get());

                        //Boss Drops
                        pOutput.accept(ModItems.UNDEAD_ESSENCE.get());
                        pOutput.accept(ModItems.VITALITY_ESSENCE.get());
                        pOutput.accept(ModItems.WITHER_ESSENCE.get());
                        pOutput.accept(ModItems.LIGHTNING_ESSENCE.get());
                        pOutput.accept(ModItems.ENFLAMED_ESSENCE.get());
                        pOutput.accept(ModItems.STAR_ESSENCE.get());
                        pOutput.accept(ModItems.SOUL_OF_FLAMING_CHOIRS.get());
                        pOutput.accept(ModItems.SOUL_OF_GODLY_JUDGEMENT.get());
                        pOutput.accept(ModItems.SOUL_OF_CRUMBLING_HEAVENS.get());

                        //Misc
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.BROWNIE.get());
                        pOutput.accept(ModItems.COFFEE.get());

                    }))
                    .build());
    public static final RegistryObject<CreativeModeTab> CYGNUS_BLOCKS = CREATIVE_MODE_TABS.register("cygnus_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get()))
                    .title(Component.translatable("creativetab.cygnus_blocks_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        //Crystal
                        pOutput.accept(ModBlocks.ATTUNED_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.BUDDING_ATTUNED_AMETHYST.get());
                        pOutput.accept(ModBlocks.ATTUNED_CRYSTAL_BLOCK.get());
                        pOutput.accept(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get());
                        pOutput.accept(ModBlocks.BLOOD_STEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.ANGEL_GOLD_BLOCK.get());
                        pOutput.accept(ModBlocks.STAR_FORGE.get());
                        pOutput.accept(ModBlocks.STAR_FORGE_PILLAR.get());

                        pOutput.accept(ModBlocks.CRYSTAL_OAK_LOG.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD.get());

                        pOutput.accept(ModBlocks.CRYSTAL_OAK_PLANKS.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_STAIRS.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_SLAB.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_BUTTON.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_PRESSURE_PLATE.get());

                        pOutput.accept(ModBlocks.CRYSTAL_OAK_FENCE.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_FENCE_GATE.get());

                        pOutput.accept(ModBlocks.CRYSTAL_OAK_DOOR.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_LEAVES.get());
                        pOutput.accept(ModBlocks.BUDDING_CRYSTAL_OAK_LEAVES.get());

                    }))
                    .build());
    public static final RegistryObject<CreativeModeTab> CYGNUS_ARSENAL = CREATIVE_MODE_TABS.register("cygnus_arsenal",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EMPOWERED_CROWN_OF_STARS.get()))
                    .title(Component.translatable("creativetab.cygnus_arsenal_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        //Crystal
                        pOutput.accept(ModItems.MASK_OF_THE_DAMNED.get());
                        pOutput.accept(ModItems.MASK_OF_VITALITY.get());
                        pOutput.accept(ModItems.MASK_OF_WITHERING.get());
                        pOutput.accept(ModItems.AWAKENED_MASK_OF_THE_DAMNED.get());
                        pOutput.accept(ModItems.AWAKENED_MASK_OF_VITALITY.get());
                        pOutput.accept(ModItems.AWAKENED_MASK_OF_WITHERING.get());
                        pOutput.accept(ModItems.STAR_CROWN.get());
                        pOutput.accept(ModItems.STRENGTH_CROWN.get());
                        pOutput.accept(ModItems.SPEED_CROWN.get());
                        pOutput.accept(ModItems.EMPOWERED_CROWN_OF_STARS.get());
                        pOutput.accept(ModItems.EMPOWERED_CROWN_OF_STRENGTH.get());
                        pOutput.accept(ModItems.EMPOWERED_CROWN_OF_SPEED.get());
                        pOutput.accept(ModItems.DEATH_BIRD_HELMET.get());
                        pOutput.accept(ModItems.DEATH_BIRD_CHESTPLATE.get());
                        pOutput.accept(ModItems.DEATH_BIRD_LEGGINGS.get());
                        pOutput.accept(ModItems.DEATH_BIRD_BOOTS.get());
                        pOutput.accept(ModItems.PLAGUED_LORD_HELMET.get());
                        pOutput.accept(ModItems.PLAGUED_LORD_CHESTPLATE.get());
                        pOutput.accept(ModItems.PLAGUED_LORD_LEGGINGS.get());
                        pOutput.accept(ModItems.PLAGUED_LORD_BOOTS.get());
                        pOutput.accept(ModItems.FAMINE_HELMET.get());
                        pOutput.accept(ModItems.FAMINE_CHESTPLATE.get());
                        pOutput.accept(ModItems.FAMINE_LEGGINGS.get());
                        pOutput.accept(ModItems.FAMINE_BOOTS.get());
                        pOutput.accept(ModItems.CONQUEST_HELMET.get());
                        pOutput.accept(ModItems.CONQUEST_CHESTPLATE.get());
                        pOutput.accept(ModItems.CONQUEST_LEGGINGS.get());
                        pOutput.accept(ModItems.CONQUEST_BOOTS.get());
                        pOutput.accept(ModItems.DOMINION_SICKLE.get());
                        pOutput.accept(ModItems.EMPOWERED_DOMINION_SICKLE.get());
                        pOutput.accept(ModItems.THRONE_CLAW.get());
                        pOutput.accept(ModItems.EMPOWERED_THRONE_CLAW.get());
                        pOutput.accept(ModItems.GLAIVE.get());
                        pOutput.accept(ModItems.EMPOWERED_GLAIVE.get());
                        pOutput.accept(ModItems.DEATH_SCYTHE.get());
                        pOutput.accept(ModItems.CONQUEST_HALBERD.get());
                        pOutput.accept(ModItems.PESTILENCE_SWORD.get());
                        pOutput.accept(ModItems.SEER_TRIDENT.get());
                        pOutput.accept(ModItems.ZWEI.get());
                        pOutput.accept(ModItems.SHAME.get());
                    }))
                    .build());

    private static final Logger log = LoggerFactory.getLogger(ModCreativeModeTabs.class);

    public static void register(IEventBus eventBus) {

        CREATIVE_MODE_TABS.register(eventBus);
    }
}
