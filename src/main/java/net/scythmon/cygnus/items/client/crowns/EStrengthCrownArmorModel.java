package net.scythmon.cygnus.items.client.crowns;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.crowns.EStrengthCrownArmorItem;
import net.scythmon.cygnus.items.custom.crowns.StrengthCrownArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class EStrengthCrownArmorModel extends GeoModel<EStrengthCrownArmorItem> {
    @Override
    public ResourceLocation getModelResource(EStrengthCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/empowered_strength_crown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EStrengthCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/empowered_strength_crown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EStrengthCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/dle.animation.json");
    }
}
