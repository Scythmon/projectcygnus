package net.scythmon.cygnus.client.renderer;

import com.blakebr0.cucumber.client.ModRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.client.model.data.ModelData;
import net.scythmon.cygnus.init.ModBlocks;
import net.scythmon.cygnus.tileentity.StarForgeAltarEntity;


public class ForgeRenderer implements BlockEntityRenderer<StarForgeAltarEntity> {

    public ForgeRenderer(BlockEntityRendererProvider.Context context) { }

    @Override
    public void render(StarForgeAltarEntity tile, float partialTick, PoseStack matrix, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        var minecraft = Minecraft.getInstance();
        var level = minecraft.level;
        if (level == null) return;

        var inventory = tile.getInventory();
        ItemStack stack = inventory.getStackInSlot(0);

        if (!stack.isEmpty()) {
            matrix.pushPose();

            float craftProgress = tile.getCraftProgress(); // 0.0 to 1.0
            boolean isCrafting = tile.isCrafting();

            double tick = (System.currentTimeMillis() % 100000D) / 800.0D;

            double baseY = 1.25D;
            double bobAmount = isCrafting ? (1.0D - craftProgress) * 0.065D : 0.065D;
            double bobY = Math.sin(tick) * bobAmount;

            matrix.translate(0.5D, baseY + tile.currentRiseY + bobY, 0.5D);

            float scale = stack.getItem() instanceof BlockItem ? 0.95F : 0.75F;
            matrix.scale(scale, scale, scale);

// Use accumulated rotation instead of deriving from time
            float rotation = isCrafting ? tile.currentRotation : (float)((tick * 40.0D) % 360);
            matrix.mulPose(Axis.YP.rotationDegrees(rotation));

            minecraft.getItemRenderer().renderStatic(
                    stack,
                    ItemDisplayContext.GROUND,
                    combinedLight,
                    combinedOverlay,
                    matrix,
                    buffer,
                    level,
                    0
            );
            matrix.popPose();
        }

        var pos = tile.getBlockPos();

        RenderType translucentType = RenderType.translucent();
        var ghostBuilder = new GhostVertexConsumer(buffer.getBuffer(translucentType), 80);

        tile.getExactPedestalPositions().forEach(aoePos -> {
            if (level.isEmptyBlock(aoePos)) {
                matrix.pushPose();

                matrix.translate(
                        aoePos.getX() - pos.getX(),
                        aoePos.getY() - pos.getY(),
                        aoePos.getZ() - pos.getZ()
                );

                matrix.translate(0.5D, 0.5D, 0.5D);
                matrix.scale(0.995F, 0.995F, 0.995F);
                matrix.translate(-0.5D, -0.5D, -0.5D);

                minecraft.getBlockRenderer().renderBatched(
                        ModBlocks.STAR_FORGE_PILLAR.get().defaultBlockState(),
                        aoePos,
                        level,
                        matrix,
                        ghostBuilder,
                        false,
                        level.getRandom(),
                        net.minecraftforge.client.model.data.ModelData.EMPTY,
                        translucentType
                );

                matrix.popPose();
            }
        });
    }

    private static class GhostVertexConsumer implements VertexConsumer {
        private final VertexConsumer inner;
        private final int alpha;

        GhostVertexConsumer(VertexConsumer inner, int alpha) {
            this.inner = inner;
            this.alpha = alpha;
        }

        @Override public VertexConsumer vertex(double x, double y, double z) { inner.vertex(x, y, z); return this; }
        @Override public VertexConsumer color(int r, int g, int b, int a) { inner.color(r, g, b, alpha); return this; }
        @Override public VertexConsumer uv(float u, float v) { inner.uv(u, v); return this; }
        @Override public VertexConsumer overlayCoords(int u, int v) { inner.overlayCoords(u, v); return this; }
        @Override public VertexConsumer uv2(int u, int v) { inner.uv2(u, v); return this; }
        @Override public VertexConsumer normal(float x, float y, float z) { inner.normal(x, y, z); return this; }
        @Override public void endVertex() { inner.endVertex(); }
        @Override public void defaultColor(int r, int g, int b, int a) { inner.defaultColor(r, g, b, alpha); }
        @Override public void unsetDefaultColor() { inner.unsetDefaultColor(); }
    }

    @Override
    public boolean shouldRenderOffScreen(StarForgeAltarEntity pBlockEntity) {
        return true;
    }
}
