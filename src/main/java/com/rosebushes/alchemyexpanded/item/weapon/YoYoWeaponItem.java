package com.rosebushes.alchemyexpanded.item.weapon;

import com.mraof.minestuck.util.MSSoundEvents;
import com.rosebushes.alchemyexpanded.entity.AEEntities;
import com.rosebushes.alchemyexpanded.entity.YoYoProjectileEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.List;

public class YoYoWeaponItem extends Item {
    protected final int damage;
    protected final int cooldown;
    protected final int stringLength;
    protected final Item yoyoProj;

    public YoYoWeaponItem(Properties properties, int dmg, int cooldown, int stringLength,  Item item) {
        super(properties);
        this.damage = dmg;
        this.cooldown = cooldown;
        this.stringLength = stringLength;
        this.yoyoProj = item;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);

        player.startUsingItem(usedHand);
        return InteractionResultHolder.success(stack);
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack item, int remainingUseDuration) {
        if(remainingUseDuration <= 1) {
            if(livingEntity instanceof Player playerIn) {
                level.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), (SoundEvent) MSSoundEvents.ITEM_PROJECTILE_THROW.get(), SoundSource.PLAYERS, 1.0F, 1.2F);
                if (playerIn instanceof ServerPlayer serverPlayer) {
                    yoYo(serverPlayer, level, 1.25F);
                }
                item.hurtAndBreak(1, playerIn, EquipmentSlot.MAINHAND);
                playerIn.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    @Override
    public void releaseUsing(ItemStack item, Level level, LivingEntity livingEntity, int timeCharged) {
        float dmgMod = timeCharged > cooldown ? 0.25F : 0.75F;

        if(timeCharged >= this.getUseDuration(item, livingEntity) - 5) return;

        if(timeCharged <= 1) return;

        if(timeCharged <= 8) {
            dmgMod = 2.0F;
        }

        if(livingEntity instanceof Player playerIn) {
            if(dmgMod == 2.0F) {
                level.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), (SoundEvent) MSSoundEvents.ITEM_MAGIC_CAST.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                if(level.isClientSide) {
                    playerIn.displayClientMessage(Component.translatable("message.alchemyexpanded.yoyo.crit"), true);
                }
            }
            level.playSound((Player) null, playerIn.getX(), playerIn.getY(), playerIn.getZ(), (SoundEvent) MSSoundEvents.ITEM_PROJECTILE_THROW.get(), SoundSource.PLAYERS, 1.0F, 1.2F);
            if (playerIn instanceof ServerPlayer serverPlayer) {
                yoYo(serverPlayer, level, dmgMod);
            }
            item.hurtAndBreak(1, playerIn, EquipmentSlot.MAINHAND);
            playerIn.awardStat(Stats.ITEM_USED.get(this));
        }
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return cooldown * 2;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    public void yoYo(ServerPlayer playerIn, Level level, float damageMod) {
        YoYoProjectileEntity yoyo = new YoYoProjectileEntity((EntityType) AEEntities.YOYO_PROJECTILE.get(), playerIn, level, (this.damage * damageMod), this.stringLength, 20);
        yoyo.setItem(new ItemStack(this.yoyoProj));
        yoyo.shootFromRotation(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 1.0F, 0.1F);
        yoyo.setNoGravity(true);

        level.addFreshEntity(yoyo);
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        DecimalFormat df = new DecimalFormat("#.#");
        double speed = 20.0 / this.cooldown;
        String speedTime = df.format(speed);

        tooltipComponents.add(Component.translatable("info.alchemyexpanded.yoyo.damage", new Object[]{this.damage}).withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(Component.translatable("info.alchemyexpanded.yoyo.speed", new Object[]{speedTime}).withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(Component.translatable("info.alchemyexpanded.yoyo.string", new Object[]{this.stringLength}).withStyle(ChatFormatting.GRAY));
    }

    public int getStringLength() {
        return this.stringLength;
    }
}
