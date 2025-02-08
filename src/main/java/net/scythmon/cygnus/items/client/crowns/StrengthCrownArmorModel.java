package net.scythmon.cygnus.items.client.crowns;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.crowns.StrengthCrownArmorItem;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class StrengthCrownArmorModel extends GeoModel<StrengthCrownArmorItem> {
    @Override
    public ResourceLocation getModelResource(StrengthCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/strength_crown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StrengthCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/strength_crown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StrengthCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/idle.animation.json");
    }
}
