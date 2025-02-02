package net.scythmon.cygnus.items.client.masks;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.masks.AWitMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class AWitMaskArmorModel extends GeoModel<AWitMaskArmorItem> {
    @Override
    public ResourceLocation getModelResource(AWitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/awakened_mask_of_withering.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AWitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/awakened_mask_of_withering.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AWitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/defualt_idle.animation.json");
    }
}
