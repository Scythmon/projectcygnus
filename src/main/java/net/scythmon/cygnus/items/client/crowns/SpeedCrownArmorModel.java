package net.scythmon.cygnus.items.client.crowns;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.crowns.SpeedCrownArmorItem;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class SpeedCrownArmorModel extends GeoModel<SpeedCrownArmorItem> {
    @Override
    public ResourceLocation getModelResource(SpeedCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/speed_crown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpeedCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/speed_crown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpeedCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/dle.animation.json");
    }
}
