package com.rosebushes.alchemyexpanded.client.model.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class SymbolShirtArmorModel {
    public SymbolShirtArmorModel() {
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = HumanoidModel.createMesh(LayerDefinitions.OUTER_ARMOR_DEFORMATION, 0.0F);
        PartDefinition root = mesh.getRoot();
        root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.1F)).texOffs(40, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)).texOffs(40, 49).addBox(-4.0F, 11.85F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.21F)).texOffs(40, 58).addBox(-4.0F, 12.1F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.19F)), PartPose.ZERO);
        return LayerDefinition.create(mesh, 64, 64);
    }
}
