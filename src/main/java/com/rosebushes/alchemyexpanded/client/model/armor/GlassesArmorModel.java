package com.rosebushes.alchemyexpanded.client.model.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class GlassesArmorModel {
    public GlassesArmorModel() {
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = HumanoidModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F);
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 40).addBox(-6.0F, -11.0F, -4.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 22.0F, 0.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }
}
