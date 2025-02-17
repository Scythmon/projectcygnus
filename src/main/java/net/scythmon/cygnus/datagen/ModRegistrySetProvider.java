package net.scythmon.cygnus.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.trim.ModTrimMaterials;
import net.scythmon.cygnus.worldgen.ModBiomeModifiers;
import net.scythmon.cygnus.worldgen.ModConfiguredFeatures;
import net.scythmon.cygnus.worldgen.ModPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModRegistrySetProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap);

    public ModRegistrySetProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ProjectCygnus.MOD_ID));
    }
}
