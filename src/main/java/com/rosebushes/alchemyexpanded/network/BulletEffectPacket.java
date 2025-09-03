package com.rosebushes.alchemyexpanded.network;

import com.mraof.minestuck.network.MSPacket;
import com.rosebushes.alchemyexpanded.AlchemyExpanded;
import com.rosebushes.alchemyexpanded.client.util.BulletEffect;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record BulletEffectPacket(Vec3 pos, Vec3 lookVec) implements MSPacket.PlayToClient {
    public static final Type<BulletEffectPacket> ID = new Type<>(AlchemyExpanded.id("bullet_effect"));
    public static final StreamCodec<RegistryFriendlyByteBuf, BulletEffectPacket> STREAM_CODEC = StreamCodec.composite(
            AEPayloads.VEC3_STREAM_CODEC,
            BulletEffectPacket::pos,
            AEPayloads.VEC3_STREAM_CODEC,
            BulletEffectPacket::lookVec,
            BulletEffectPacket::new
    );
    
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
    
    @Override
    public void execute(IPayloadContext context) {
        BulletEffect.rangedCollisionEffect(ParticleTypes.CRIT, false, Minecraft.getInstance().level, this.pos);
    }
}
