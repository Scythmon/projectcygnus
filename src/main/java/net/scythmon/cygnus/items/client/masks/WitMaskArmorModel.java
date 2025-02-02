package net.scythmon.cygnus.items.client.masks;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.masks.WitMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class WitMaskArmorModel extends GeoModel<WitMaskArmorItem> {
    @Override
    public ResourceLocation getModelResource(WitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/mask_of_withering.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/mask_of_withering.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WitMaskArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/defualt_idle.animation.json");
    }
}
