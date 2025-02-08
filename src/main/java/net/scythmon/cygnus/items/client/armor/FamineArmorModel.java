package net.scythmon.cygnus.items.client.armor;

import net.minecraft.resources.ResourceLocation;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.items.custom.armor.FamineArmorItem;
import net.scythmon.cygnus.items.custom.armor.PlagueLordArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class FamineArmorModel extends GeoModel<FamineArmorItem> {
    @Override
    public ResourceLocation getModelResource(FamineArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/famine_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FamineArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/armor/famine_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FamineArmorItem animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/idle.animation.json");
    }
}
