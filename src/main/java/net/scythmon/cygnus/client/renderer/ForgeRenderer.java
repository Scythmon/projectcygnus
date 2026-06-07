package net.scythmon.cygnus.client.renderer;

import com.blakebr0.cucumber.client.ModRenderTypes;
import com.mojang.blaze3d.vertex.PoseStack;
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
            matrix.translate(0.5D, 1.25D, 0.5D);

            float scale = stack.getItem() instanceof BlockItem ? 0.95F : 0.75F;
            matrix.scale(scale, scale, scale);

            double tick = (System.currentTimeMillis() % 100000D) / 800.0D;
            matrix.translate(0.0D, Math.sin(tick) * 0.065D, 0.0D);
            matrix.mulPose(Axis.YP.rotationDegrees((float) ((tick * 40.0D) % 360)));

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
        var builder = buffer.getBuffer(translucentType);

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
                        builder,
                        false,
                        level.getRandom(),
                        net.minecraftforge.client.model.data.ModelData.EMPTY,
                        translucentType
                );

                matrix.popPose();
            }
        });
    }

    @Override
    public boolean shouldRenderOffScreen(StarForgeAltarEntity pBlockEntity) {
        return true;
    }
}
