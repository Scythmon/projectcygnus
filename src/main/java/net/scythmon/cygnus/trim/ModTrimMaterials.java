package net.scythmon.cygnus.trim;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.init.ModItems;

import java.util.Map;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> CONCENTRATED_CRYSTAL =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(ProjectCygnus.MOD_ID, "concentrated_crystal_cluster"));

    public static void bootstrap(BootstapContext<TrimMaterial> context) {
        register(context, CONCENTRATED_CRYSTAL, ModItems.CONCENTRATED_CRYSTAL_CLUSTER.get(), Style.EMPTY.withColor(TextColor.parseColor("#031cfc")), 0.8F);
    }

    private static void register(BootstapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item,
                                 Style style, float itemModelIndex) {
        TrimMaterial trimmaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex,
                Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
        context.register(trimKey, trimmaterial);
    }
}
