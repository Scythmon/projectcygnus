package net.scythmon.cygnus.items;

import com.google.common.eventbus.EventBus;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.block.ModBlocks;

import javax.security.auth.login.Configuration;
import javax.swing.*;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectCygnus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CYGNUS_ITEMS = CREATIVE_MODE_TABS.register("cygnus_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STAR.get()))
                    .title(Component.translatable("creativetab.cygnus_items_tab"))
                    .displayItems(((pParameters, pOutput) -> {
            //Item progression can be found in the comments of the ModItems class, this is formatted as such to make the creative tab more appealing to look at

                        //Placeholder spot
                        pOutput.accept(ModItems.STARFLAME.get());
                        pOutput.accept(ModItems.BROWNIE.get());
                        pOutput.accept(ModItems.COFFEE.get());
                        //Crystal Items
                        pOutput.accept(ModItems.TRUE_CRYSTAL.get());
                        pOutput.accept(ModItems.STAR.get());
                        pOutput.accept(ModItems.CRYSTAL_FLOWER.get());
                        pOutput.accept(ModItems.CRYSTAL_BERRIES.get());
                        pOutput.accept(ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get());

                        //Metal?
                        pOutput.accept(ModItems.BLOOD_STEEL.get());
                        pOutput.accept(ModItems.ANGEL_GOLD.get());
                        pOutput.accept(ModItems.ALTAR_CORE.get());

                        //Concentrates
                        pOutput.accept(ModItems.WITHER_CONCENTRATE.get());
                        pOutput.accept(ModItems.LIFE_CONCENTRATE.get());
                        pOutput.accept(ModItems.UNDEAD_CONCENTRATE.get());
                        pOutput.accept(ModItems.SPEED_CONCENTRATE.get());
                        pOutput.accept(ModItems.STRENGTH_CONCENTRATE.get());
                        pOutput.accept(ModItems.STAR_CONCENTRATE.get());

                        //Tears
                        pOutput.accept(ModItems.CHERUB_TEAR.get());
                        pOutput.accept(ModItems.DOMINION_TEAR.get());
                        pOutput.accept(ModItems.THRONE_TEAR.get());

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

                    }))
                    .build());
    public static final RegistryObject<CreativeModeTab> CYGNUS_BLOCKS = CREATIVE_MODE_TABS.register("cygnus_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get()))
                    .title(Component.translatable("creativetab.cygnus_blocks_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        //Crystal
                        pOutput.accept(ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_LOG.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_CRYSTAL_OAK_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_CRYSTAL_OAK_WOOD.get());

                        pOutput.accept(ModBlocks.CRYSTAL_OAK_PLANKS.get());
                        pOutput.accept(ModBlocks.CRYSTAL_OAK_LEAVES.get());
                        //Misc
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {

        CREATIVE_MODE_TABS.register(eventBus);
    }
}
