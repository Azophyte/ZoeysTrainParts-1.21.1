package net.azophyte.zoeys_train_parts.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.azophyte.zoeys_train_parts.ZoeysTrainParts;
import net.azophyte.zoeys_train_parts.block.GangwayBlock;
import net.azophyte.zoeys_train_parts.block.ModBlocks;
import net.azophyte.zoeys_train_parts.entity.GangwayBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class GangwayBlockEntityRenderer implements BlockEntityRenderer<GangwayBlockEntity> {
    public GangwayBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(GangwayBlockEntity gangwayBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        //Render the doorway

        //TODO: Good start, it renders *something*!. Now lets make it render a door somehow... Probably good idea  to investigate other Renderers?
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = new ItemStack(ModBlocks.GangwayBlock.asItem());

        poseStack.pushPose();
        poseStack.translate(0.5f, 2f, 0.5f);
        poseStack.scale(2f, 2f, 2f);
        poseStack.mulPose(Axis.YP.rotationDegrees(gangwayBlockEntity.getRenderingRotation()));

        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(gangwayBlockEntity.getLevel(),
                gangwayBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, gangwayBlockEntity.getLevel(), 1);
        poseStack.popPose();
    }

    //TODO: This doesn't work. Don't all minecraft entities have a direction they face built in? Figure that out and if so, use it!
    private BlockPos relativePos(Level level, BlockPos pos) {
        pos = pos.above();

        if (!level.getBlockState(pos).getBlock().equals(ModBlocks.GangwayBlock)){
            ZoeysTrainParts.LOGGER.info("TRIED TO GET RELATIVE POSTION WHEN NO BLOCK EXISTED AT " + pos);
            return pos; //Error catcher
        }

        if (level.getBlockState(pos).getValue(GangwayBlock.FACING).equals(Direction.EAST)){
            return pos.east();
        } else if (level.getBlockState(pos).getValue(GangwayBlock.FACING).equals(Direction.SOUTH)){
            return pos.south();
        } else if (level.getBlockState(pos).getValue(GangwayBlock.FACING).equals(Direction.WEST)){
            return pos.west();
        } else {
            return pos.north(); //Defaults to north
        }
    }


    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos.above());
        int sLight = level.getBrightness(LightLayer.SKY, pos.above());
        return LightTexture.pack(bLight, sLight);
    }
}
