package com.rosebushes.alchemyexpanded.item.weapon.gun;

import com.mraof.minestuck.client.util.MagicEffect;
import com.mraof.minestuck.network.MagicRangedEffectPacket;
import com.rosebushes.alchemyexpanded.entity.AEDamage;
import com.rosebushes.alchemyexpanded.util.AESoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LaserGunWeaponItem extends GunWeaponItem {

    protected int distance;
    private static final TargetingConditions visiblePredicate = TargetingConditions.forCombat();

    public LaserGunWeaponItem(Properties properties, float damage, int distance, int rate, int ammoCap, int ammoConsumption, int reload, boolean infinite, boolean dualWield, Item ammo, @Nullable Item iDouble) {
        super(properties, damage, 0, 1, 0, rate, ammoCap, ammoConsumption, reload, infinite, dualWield, ammo, iDouble);
        this.distance = distance;
    }

    @Override
    public void shoot(Level level, Player shooter, ItemStack stack) {
        if(shooter instanceof ServerPlayer) {
            fireLaser(level, (ServerPlayer) shooter, false);
        }
    }

    @Override
    public void shootDouble(Level level, Player shooter, ItemStack stack) {
        if(shooter instanceof ServerPlayer) {
            fireLaser(level, (ServerPlayer) shooter, true);
            fireLaser(level, (ServerPlayer) shooter, true);
        }
    }

    private void fireLaser(Level level, ServerPlayer player, boolean dualWield) {
        Vec3 eyePos = player.getEyePosition(1.0F);
        Vec3 lookVec = player.getLookAngle();

        for(int step = 0; step < this.distance * 2; ++step) {
            Vec3 vecPos = eyePos.add(lookVec.scale((double)step / (double)2.0F));
            boolean hitObstacle = this.checkCollisionInPath(level, player, vecPos, dualWield);
            if (hitObstacle) {
                this.sendEffectPacket(level, eyePos, lookVec, step, true);
                return;
            }
        }

        this.sendEffectPacket(level, eyePos, lookVec, this.distance * 2, false);
    }

    protected void sendEffectPacket(Level level, Vec3 pos, Vec3 lookVec, int length, boolean collides) {
        if(!level.isClientSide) {
            PacketDistributor.sendToPlayersNear((ServerLevel) level, null, pos.x, pos.y, pos.z, 64.0, new MagicRangedEffectPacket(MagicEffect.RangedType.RED, pos, lookVec, length, collides));
        }
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return Mth.hsvToRgb(0.5F, 1.0F, 0.6F);
    }

    @Override
    public void playFireSound(Level level, Entity player) {
        playSound(level, player, AESoundEvents.LASER.get(), 1.0F, 1.0F);
    }

    @Override
    public void addParticles(Level level, Entity player, int amount) {

    }

    private boolean checkCollisionInPath(Level level, ServerPlayer player, Vec3 vecPos, boolean dualWield) {
            BlockPos blockPos = BlockPos.containing(vecPos);
            if(!level.getBlockState(blockPos).isPathfindable(PathComputationType.LAND)) {
                return true;
            }
            else {
                AABB axisAlignedBB = new AABB(blockPos);
                LivingEntity closestTarget = player.level().getNearestEntity(LivingEntity.class, visiblePredicate, player, vecPos.x, vecPos.y, vecPos.z, axisAlignedBB);
                if (closestTarget != null) {
                    boolean bonusDamage = dualWield ? closestTarget.hurt(AEDamage.laser(player.level().registryAccess(), player), (getWeaponDamage() + (Math.round((getWeaponDamage() / 10) * 2) / 2.0F))) : closestTarget.hurt(AEDamage.laser(player.level().registryAccess(), player), getWeaponDamage());
                    onHitEntity(closestTarget);
                    return true;
                } else {
                    return false;
                }
            }
    }

    public void onHitEntity(LivingEntity entity) {

    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int rate = getRate();
        double reloadTime = (double) Math.round((getReload() * 0.05) * 2) / 2.0F;
        int ammoCap = getAmmo();
        int ammoConsumption = getAmmoConsume();
        double timeFireClip = ((rate * 0.05) * ammoCap);
        double ratePerMinuteWithReload = 60 / (timeFireClip + reloadTime);
        double roundsPerMinuteFired =  ratePerMinuteWithReload * ammoCap;
        double damagePerSecond = Math.round(((roundsPerMinuteFired * getWeaponDamage()) / 60) * 2) / 2.0F;
        double ammoEfficiency = (damagePerSecond * 60) / (ratePerMinuteWithReload * ammoConsumption);
        String ammoType = getAmmoType().getDescriptionId();

        tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.damage", new Object[]{damagePerSecond}).withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.reload_time", new Object[]{reloadTime}).withStyle(ChatFormatting.GRAY));
        if(!getInfinite()) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_max", new Object[]{ammoCap}).withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_consume", new Object[]{ammoConsumption}).withStyle(ChatFormatting.GRAY).append(Component.translatable(ammoType).withStyle(ChatFormatting.GRAY)));
        }
        else tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.infinite").withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD));
        if(ammoEfficiency <= 20) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_eff").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.ammo_eff_poor").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD)));
        }
        else if(ammoEfficiency <= 50) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_eff").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.ammo_eff_average").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD)));
        }
        else if(ammoEfficiency <= 75) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_eff").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.ammo_eff_good").withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.BOLD)));
        }
        else {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_eff").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.ammo_eff_great").withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD)));
        }
        if(roundsPerMinuteFired <= 50) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.rate").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.rate_very_slow").withStyle(ChatFormatting.DARK_RED).withStyle(ChatFormatting.BOLD)));
        }
        else if(roundsPerMinuteFired <= 100) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.rate").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.rate_slow").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD)));
        }
        else if(roundsPerMinuteFired <= 150) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.rate").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.rate_medium").withStyle(ChatFormatting.YELLOW).withStyle(ChatFormatting.BOLD)));
        }
        else {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.rate").withStyle(ChatFormatting.GRAY).append(Component.translatable("info.alchemyexpanded.gun.rate_fast").withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD)));
        }
        if(getDualWieldable()) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.dual_wield").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.BOLD));
        }
    }
}
