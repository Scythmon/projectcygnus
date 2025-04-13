package net.scythmon.cygnus.items.client.masks;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import net.scythmon.cygnus.items.custom.masks.DamMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class DamMaskArmorModel extends GeoModel<DamMaskArmorItem> {
    @Override
    public ResourceLocation getModelResource(DamMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/mask_of_damned.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DamMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/mask_of_damned.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DamMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/idle.animation.json");
    }
}
