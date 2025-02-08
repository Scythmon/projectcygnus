package net.scythmon.cygnus.items.client.crowns;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.crowns.StarCrownArmorItem;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class StarCrownArmorModel extends GeoModel<StarCrownArmorItem> {
    @Override
    public ResourceLocation getModelResource(StarCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/star_crown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StarCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/star_crown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StarCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/idle.animation.json");
    }
}
