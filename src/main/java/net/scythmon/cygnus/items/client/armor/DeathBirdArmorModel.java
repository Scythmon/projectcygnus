package net.scythmon.cygnus.items.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.armor.ConquestArmorItem;
import net.scythmon.cygnus.items.custom.armor.DeathBirdArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class DeathBirdArmorModel extends GeoModel<DeathBirdArmorItem> {
    @Override
    public ResourceLocation getModelResource(DeathBirdArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/death_bird_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DeathBirdArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/death_bird_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DeathBirdArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/defualt_idle.animation.json");
    }
}
