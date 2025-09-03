package com.rosebushes.alchemyexpanded.item.weapon.gun;

import com.mraof.minestuck.client.util.MagicEffect;
import com.mraof.minestuck.network.MagicRangedEffectPacket;
import com.rosebushes.alchemyexpanded.util.AESoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FlamethrowerGunWeaponItem extends LaserGunWeaponItem {
    public FlamethrowerGunWeaponItem(Properties properties, float damage, int distance, int rate, int ammoCap, int ammoConsumption, int reload, boolean infinite, boolean dualWield, Item ammo, @Nullable Item iDouble) {
        super(properties, damage, distance, rate, ammoCap, ammoConsumption, reload, infinite, dualWield, ammo, iDouble);
    }

    @Override
    public void playFireSound(Level level, Entity player) {
        playSound(level, player, SoundEvents.FIRE_AMBIENT, 1.0F, 1.0F);
    }

    @Override
    public void onHitEntity(LivingEntity entity) {
        super.onHitEntity(entity);
        entity.setRemainingFireTicks(80);
    }

    @Override
    protected void sendEffectPacket(Level level, Vec3 pos, Vec3 lookVec, int length, boolean collides) {
        if(!level.isClientSide) {
            PacketDistributor.sendToPlayersNear((ServerLevel) level, null, pos.x, pos.y, pos.z, 64.0, new MagicRangedEffectPacket(MagicEffect.RangedType.FIRE, pos, lookVec, length, collides));
        }
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return Mth.hsvToRgb(0.1F, 1.0F, 1.0F);
    }
}
