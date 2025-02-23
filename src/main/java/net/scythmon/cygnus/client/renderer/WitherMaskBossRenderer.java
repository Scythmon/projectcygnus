package net.scythmon.cygnus.client.renderer;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import com.mojang.blaze3d.vertex.PoseStack;
import net.scythmon.cygnus.ProjectCygnus;
import net.scythmon.cygnus.client.models.WitherMaskBossModel;
import net.scythmon.cygnus.entity.WitherMaskBoss;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class WitherMaskBossRenderer extends GeoEntityRenderer<WitherMaskBoss> {
    public WitherMaskBossRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WitherMaskBossModel());
    }

    @Override
    public ResourceLocation getTextureLocation(WitherMaskBoss animatable) {
        return new ResourceLocation(ProjectCygnus.MOD_ID, "textures/entity/withermask.png");
    }

    @Override
    public void render(WitherMaskBoss entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
