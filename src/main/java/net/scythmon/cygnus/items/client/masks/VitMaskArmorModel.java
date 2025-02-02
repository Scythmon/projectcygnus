package net.scythmon.cygnus.items.client.masks;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.masks.VitMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class VitMaskArmorModel extends GeoModel<VitMaskArmorItem> {
    @Override
    public ResourceLocation getModelResource(VitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/mask_of_vitality.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/mask_of_vitality.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/defualt_idle.animation.json");
    }
}
