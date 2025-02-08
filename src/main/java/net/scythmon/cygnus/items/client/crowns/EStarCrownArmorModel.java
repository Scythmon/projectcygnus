package net.scythmon.cygnus.items.client.crowns;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.crowns.EStarCrownArmorItem;
import net.scythmon.cygnus.items.custom.crowns.StarCrownArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class EStarCrownArmorModel extends GeoModel<EStarCrownArmorItem> {
    @Override
    public ResourceLocation getModelResource(EStarCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/empowered_star_crown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EStarCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/empowered_star_crown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EStarCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/dle.animation.json");
    }
}
