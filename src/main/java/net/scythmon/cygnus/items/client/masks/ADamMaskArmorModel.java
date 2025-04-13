package net.scythmon.cygnus.items.client.masks;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.masks.ADamMaskArmorItem;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class ADamMaskArmorModel extends GeoModel<ADamMaskArmorItem> {

    @Override
    public ResourceLocation getModelResource(ADamMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/awakened_mask_of_damned.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ADamMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/awakened_mask_of_damned.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ADamMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/idle.animation.json");
    }
}
