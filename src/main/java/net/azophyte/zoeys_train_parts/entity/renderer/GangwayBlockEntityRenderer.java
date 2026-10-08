package net.azophyte.zoeys_train_parts.entity.renderer;

import com.mojang.authlib.yggdrasil.response.MinecraftTexturesPayload;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.azophyte.zoeys_train_parts.Model.GangwayFrameModel;
import net.azophyte.zoeys_train_parts.ZoeysTrainParts;
import net.azophyte.zoeys_train_parts.block.GangwayBlock;
import net.azophyte.zoeys_train_parts.block.ModBlocks;
import net.azophyte.zoeys_train_parts.entity.GangwayBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.RenderShape;

public class GangwayBlockEntityRenderer implements BlockEntityRenderer<GangwayBlockEntity> {
    public static final Material FRAME_LOCATION;
    private final GangwayFrameModel gangwayFrameModel;




    //"This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor" - Blockbench java model file GangwayFrameModel
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ZoeysTrainParts.MODID, "gangway_frame"), "main");

    public GangwayBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

        this.gangwayFrameModel = new GangwayFrameModel(context.bakeLayer(LAYER_LOCATION));

    }

    @Override
    public void render(GangwayBlockEntity gangwayBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        //Render the doorway
        //TODO: Good start, it renders *something*!. Now lets make it render a door somehow... Probably good idea to investigate other Renderers?

        /*
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = new ItemStack(ModBlocks.GangwayBlock.asItem());

        poseStack.pushPose();
        poseStack.translate(0.5f, 2f, 0.5f);
        poseStack.scale(2f, 2f, 2f);
        poseStack.mulPose(Axis.YP.rotationDegrees(gangwayBlockEntity.getRenderingRotation()));

        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(gangwayBlockEntity.getLevel(),
                gangwayBlockEntity.getBlockPos()), OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, gangwayBlockEntity.getLevel(), 1);
        */

        //This part is copied directly from enchanttablerenderer

        poseStack.pushPose();
        poseStack.translate(0.5f, 1.5f, 0f);
        //poseStack.scale(2f, 2f, 2f);

        VertexConsumer vertexconsumer = FRAME_LOCATION.buffer(multiBufferSource, RenderType::entitySolid);

        //poseStack.translate(0.5F, 0.75F, 0.5F);
        //this.bookModel.render(poseStack, vertexconsumer, i, i1, -1);
        this.gangwayFrameModel.renderToBuffer(poseStack, vertexconsumer, getLightLevel(gangwayBlockEntity.getLevel(), gangwayBlockEntity.getBlockPos()), i1);
        //poseStack.popPose();

        poseStack.popPose();
    }


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

    static {
        FRAME_LOCATION = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.fromNamespaceAndPath(ZoeysTrainParts.MODID,"entity/gangway/gangway_frame_brass.png"));
    }

}
