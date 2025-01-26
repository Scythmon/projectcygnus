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

import javax.security.auth.login.Configuration;
import javax.swing.*;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectCygnus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CYGNUS = CREATIVE_MODE_TABS.register("cygnus",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.STARFLAME.get()))
                    .title(Component.translatable("creativetab.cygnus_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        //Naturals



                        //Pre-Crafting Items



                        //Tier 1 Crafting Items


                        output.accept(ModItems.TRUE_CRYSTAL.get());
                        output.accept(ModItems.STARFLAME.get());
                        output.accept(ModItems.BLOOD_STEEL.get());
                        output.accept(ModItems.ANGEL_GOLD.get());
                        output.accept(ModItems.ALTAR_CORE.get());


                        //Tier 2 Crafting Items

                        output.accept(ModItems.WITHER_CONCENTRATE.get());
                        output.accept(ModItems.LIFE_CONCENTRATE.get());
                        output.accept(ModItems.UNDEAD_CONCENTRATE.get());
                        output.accept(ModItems.SPEED_CONCENTRATE.get());
                        output.accept(ModItems.STRENGTH_CONCENTRATE.get());
                        output.accept(ModItems.STAR_CONCENTRATE.get());
                        output.accept(ModItems.CHERUB_TEAR.get());
                        output.accept(ModItems.DOMINION_TEAR.get());
                        output.accept(ModItems.THRONE_TEAR.get());
                        output.accept(ModItems.EMPTY_CELESTIAL_TALISMAN.get());
                        output.accept(ModItems.STAR.get());
                        output.accept(ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get());


                        //Tier 3 Crafting items


                        output.accept(ModItems.EMPTY_ANGELIC_TALISMAN.get());
                        output.accept(ModItems.FELL_STAR_PLATE.get());
                        output.accept(ModItems.AFTERLIFE_PLATE.get());
                        output.accept(ModItems.ANGEL_PLATE.get());
                        output.accept(ModItems.CARNAGE_PLATE.get());
                        output.accept(ModItems.UNSTABLE_SINGULARITY.get());
                        output.accept(ModItems.SINGULARITY_SHARD.get());


                        //Tier4 Crafting Items


                        output.accept(ModItems.SINGULARITY_STONE.get());


                        //Filled Celestial Talismans
                        //Filled Carnage Talismans
                        //Boss Drops
                    }))
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
