package net.scythmon.cygnus.client.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.scythmon.cygnus.tileentity.StarForgePillarEntity;
import org.jetbrains.annotations.NotNull;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;



public class PillarRenderer implements BlockEntityRenderer<StarForgePillarEntity> {
    public PillarRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(StarForgePillarEntity tile, float v, PoseStack matrix, MultiBufferSource buffer, int i, int i1) {
        var stack = tile.getInventory().getStackInSlot(0);
        var minecraft = Minecraft.getInstance();

        if (!stack.isEmpty()) {
            matrix.pushPose();
            matrix.translate(0.5D, 0.75D, 0.5D);
            float scale = stack.getItem() instanceof BlockItem ? 0.95F : 0.75F;
            matrix.scale(scale, scale, scale);
            double tick = System.currentTimeMillis() / 800.0D;
            matrix.translate(0.0D, Math.sin(tick % (2 * Math.PI)) * 0.065D, 0.0D);
            matrix.mulPose(Axis.YP.rotationDegrees((float) ((tick * 40.0D) % 360)));
            minecraft.getItemRenderer().renderStatic(stack, ItemDisplayContext.GROUND, i, i1, matrix, buffer, minecraft.level, 0);
            matrix.popPose();
        }
    }
}