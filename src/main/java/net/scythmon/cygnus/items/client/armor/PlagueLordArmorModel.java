package net.scythmon.cygnus.items.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.armor.ConquestArmorItem;
import net.scythmon.cygnus.items.custom.armor.PlagueLordArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class PlagueLordArmorModel extends GeoModel<PlagueLordArmorItem> {
    @Override
    public ResourceLocation getModelResource(PlagueLordArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/plague_lord_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PlagueLordArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/plagued_lord_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PlagueLordArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/dle.animation.json");
    }
}
