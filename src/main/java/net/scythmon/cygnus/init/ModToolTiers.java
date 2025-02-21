package net.scythmon.cygnus.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.scythmon.cygnus.ProjectCygnus;

import java.util.List;

public class ModToolTiers {
    public static final Tier BOSS_WEAPONS = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 1f, 4f, 25,
                    ModTags.Blocks.PLACEHOLDER, () -> Ingredient.of(ModItems.SINGULARITY_STONE.get())),
            new ResourceLocation(ProjectCygnus.MOD_ID, "boss_weapons"), List.of(Tiers.NETHERITE), List.of());
}
