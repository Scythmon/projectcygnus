package net.scythmon.cygnus.client.models;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.entity.WitherMaskBoss;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class WitherMaskBossModel extends GeoModel<WitherMaskBoss> {
    @Override
    public ResourceLocation getModelResource(WitherMaskBoss animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "geo/withermask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WitherMaskBoss animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/entity/withermask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WitherMaskBoss animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "animations/withermask.animation.json");
    }

    @Override
    public void setCustomAnimations(WitherMaskBoss animatable, long instanceId, AnimationState<WitherMaskBoss> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
