package net.scythmon.cygnus.items.client.crowns;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.crowns.ESpeedCrownArmorItem;
import net.scythmon.cygnus.items.custom.crowns.SpeedCrownArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class ESpeedCrownArmorModel extends GeoModel<ESpeedCrownArmorItem> {
    @Override
    public ResourceLocation getModelResource(ESpeedCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/empowered_speed_crown.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ESpeedCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/empowered_speed_crown.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ESpeedCrownArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/defualt_idle.animation.json");
    }
}
