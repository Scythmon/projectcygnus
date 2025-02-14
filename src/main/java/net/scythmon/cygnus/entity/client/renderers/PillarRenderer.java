package net.scythmon.cygnus.entity.client.renderers;

import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.scythmon.cygnus.block.entity.StarForgePillarEntity;
import org.jetbrains.annotations.NotNull;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import java.awt.*;

public class PillarRenderer implements BlockEntityRenderer<StarForgePillarEntity> {
    private final BlockEntityRendererProvider.Context context;

    public PillarRenderer(BlockEntityRendererProvider.Context ctx) {
        this.context = ctx;
    }

    @Override
    public void render(@NotNull StarForgePillarEntity pBlockEntity, float pPartialTick, @NotNull PoseStack pPoseStack,
                       @NotNull MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemStack stack = pBlockEntity.getInventory().getStackInSlot(0);
        if(stack.isEmpty())
            return;

        Level level = pBlockEntity.getLevel();
        if(level == null)
            return;

        BlockPos pos = pBlockEntity.getBlockPos().above();

        int packedLight = LightTexture.pack(
                level.getBrightness(LightLayer.BLOCK, pos),
                level.getBrightness(LightLayer.SKY, pos)
        );

        double relativeGameTime = level.getGameTime() + pPartialTick;
        double rotation = Math.sin(relativeGameTime / 20.0) * 40.0;

        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees((float) rotation));
        this.context.getItemRenderer().renderStatic(
                stack,
                ItemDisplayContext.FIXED,
                packedLight,
                OverlayTexture.NO_OVERLAY,
                pPoseStack,
                pBuffer,
                level,
                0
        );
    }
}
