package net.scythmon.cygnus.items.client;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.ConquestArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class ConquestArmorModel extends GeoModel<ConquestArmorItem> {
    @Override
    public ResourceLocation getModelResource(ConquestArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/conquest_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ConquestArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/conquest_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ConquestArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/conquest_armor.animation.json");
    }
}
