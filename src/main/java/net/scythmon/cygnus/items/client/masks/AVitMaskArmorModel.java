package net.scythmon.cygnus.items.client.masks;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class AVitMaskArmorModel extends GeoModel<AVitMaskArmorItem> {
    @Override
    public ResourceLocation getModelResource(AVitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/awakened_mask_of_vitality.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AVitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/awakened_mask_of_vitality.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AVitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/dle.animation.json");
    }
}
