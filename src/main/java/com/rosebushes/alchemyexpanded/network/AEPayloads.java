package com.rosebushes.alchemyexpanded.network;

import com.mraof.minestuck.network.MSPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(modid = "alchemyexpanded")
public final class AEPayloads {
    public static final StreamCodec<FriendlyByteBuf, Vec3> VEC3_STREAM_CODEC;
    
    @SubscribeEvent
    private static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("alchemyexpanded").versioned("2");
        
        registerPlayToClient(registrar, BulletEffectPacket.ID, BulletEffectPacket.STREAM_CODEC);
    }
    
    private static <T extends MSPacket.PlayToServer> void registerPlayToServer(PayloadRegistrar registrar, CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec) {
        registrar.playToServer(type, codec, (t, context) -> t.execute(context, (ServerPlayer) context.player()));
    }
    
    private static <T extends MSPacket.PlayToClient> void registerPlayToClient(PayloadRegistrar registrar, CustomPacketPayload.Type<T> type, StreamCodec<? super RegistryFriendlyByteBuf, T> codec) {
        registrar.playToClient(type, codec, MSPacket.PlayToClient::execute);
    }
    
    static {
        VEC3_STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.DOUBLE, Vec3::x, ByteBufCodecs.DOUBLE, Vec3::y, ByteBufCodecs.DOUBLE, Vec3::z, Vec3::new);
    }
}
