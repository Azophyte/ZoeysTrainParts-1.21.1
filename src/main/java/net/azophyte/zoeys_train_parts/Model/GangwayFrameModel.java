package net.azophyte.zoeys_train_parts.Model;// Made with Blockbench 5.2.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.azophyte.zoeys_train_parts.ZoeysTrainParts;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class GangwayFrameModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ZoeysTrainParts.MODID, "gangway_frame"), "main");

	private final ModelPart adjustable;
	private final ModelPart corners;
	private final ModelPart corner1;
	private final ModelPart corner2;
	private final ModelPart corner3;
	private final ModelPart corner4;

	public GangwayFrameModel(ModelPart root) {
		this.adjustable = root.getChild("adjustable");
		this.corners = root.getChild("corners");
		this.corner1 = this.corners.getChild("corner1");
		this.corner2 = this.corners.getChild("corner2");
		this.corner3 = this.corners.getChild("corner3");
		this.corner4 = this.corners.getChild("corner4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition adjustable = partdefinition.addOrReplaceChild("adjustable", CubeListBuilder.create().texOffs(0, 14).addBox(8.0F, -25.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition verticalbar2_r1 = adjustable.addOrReplaceChild("verticalbar2_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -16.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -9.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition corners = partdefinition.addOrReplaceChild("corners", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition corner1 = corners.addOrReplaceChild("corner1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, -1.0F, 0.0F));

		PartDefinition corner_r1 = corner1.addOrReplaceChild("corner_r1", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition strut2_r1 = corner1.addOrReplaceChild("strut2_r1", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition corner2 = corners.addOrReplaceChild("corner2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition corner_r2 = corner2.addOrReplaceChild("corner_r2", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition strut3_r1 = corner2.addOrReplaceChild("strut3_r1", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition corner3 = corners.addOrReplaceChild("corner3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -33.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		PartDefinition corner_r3 = corner3.addOrReplaceChild("corner_r3", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition strut3_r2 = corner3.addOrReplaceChild("strut3_r2", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition corner4 = corners.addOrReplaceChild("corner4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -33.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition corner_r4 = corner4.addOrReplaceChild("corner_r4", CubeListBuilder.create().texOffs(0, 10).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.3562F));

		PartDefinition strut4_r1 = corner4.addOrReplaceChild("strut4_r1", CubeListBuilder.create().texOffs(8, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

    //added by blockbench, copied the other one from BookModel.class lol
	/*@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		adjustable.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		corners.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}*/

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        adjustable.render(poseStack, buffer, packedLight, packedOverlay, color);
        corners.render(poseStack, buffer, packedLight, packedOverlay, color);
        //this.render(poseStack, buffer, packedLight, packedOverlay, color);
    }
}