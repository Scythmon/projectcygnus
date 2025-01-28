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

    public static final RegistryObject<CreativeModeTab> CYGNUS = CREATIVE_MODE_TABS.register("cygnus",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STAR.get()))
                    .title(Component.translatable("creativetab.cygnus_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        //Naturals
                        pOutput.accept(ModItems.CRYSTAL_FLOWER.get());
                        pOutput.accept(ModItems.CRYSTAL_BERRIES.get());
                        pOutput.accept(ModItems.BROWNIE.get());


                        //Pre-Crafting Items



                        //Tier 1 Crafting Items


                        pOutput.accept(ModItems.TRUE_CRYSTAL.get());
                        pOutput.accept(ModItems.STARFLAME.get());
                        pOutput.accept(ModItems.BLOOD_STEEL.get());
                        pOutput.accept(ModItems.ANGEL_GOLD.get());
                        pOutput.accept(ModItems.ALTAR_CORE.get());


                        //Tier 2 Crafting Items

                        pOutput.accept(ModItems.WITHER_CONCENTRATE.get());
                        pOutput.accept(ModItems.LIFE_CONCENTRATE.get());
                        pOutput.accept(ModItems.UNDEAD_CONCENTRATE.get());
                        pOutput.accept(ModItems.SPEED_CONCENTRATE.get());
                        pOutput.accept(ModItems.STRENGTH_CONCENTRATE.get());
                        pOutput.accept(ModItems.STAR_CONCENTRATE.get());
                        pOutput.accept(ModItems.CHERUB_TEAR.get());
                        pOutput.accept(ModItems.DOMINION_TEAR.get());
                        pOutput.accept(ModItems.THRONE_TEAR.get());
                        pOutput.accept(ModItems.EMPTY_CELESTIAL_TALISMAN.get());
                        pOutput.accept(ModItems.STAR.get());
                        pOutput.accept(ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get());


                        //Tier 3 Crafting items


                        pOutput.accept(ModItems.EMPTY_ANGELIC_TALISMAN.get());
                        pOutput.accept(ModItems.FELL_STAR_PLATE.get());
                        pOutput.accept(ModItems.AFTERLIFE_PLATE.get());
                        pOutput.accept(ModItems.ANGEL_PLATE.get());
                        pOutput.accept(ModItems.CARNAGE_PLATE.get());
                        pOutput.accept(ModItems.UNSTABLE_SINGULARITY.get());
                        pOutput.accept(ModItems.SINGULARITY_SHARD.get());


                        //Tier4 Crafting Items


                        pOutput.accept(ModItems.SINGULARITY_STONE.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        //Filled Celestial Talismans
                        //Filled Carnage Talismans
                        //Boss Drops
                        //Blocks

                        pOutput.accept((ModBlocks.CONCENTRATED_CRYSTAL_BLOCK.get()));
                        pOutput.accept((ModBlocks.SOUND_BLOCK.get()));
                    }))
                    .build());
    public static void register(IEventBus eventBus) {

        CREATIVE_MODE_TABS.register(eventBus);
    }
}
