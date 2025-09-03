package com.rosebushes.alchemyexpanded.item.weapon.gun;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rosebushes.alchemyexpanded.entity.ProjectileEntity;
import com.rosebushes.alchemyexpanded.item.components.AEItemComponents;
import com.rosebushes.alchemyexpanded.util.AESoundEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class GunWeaponItem extends Item {
    private float projectileDamage;
    private double projectileSpeed;
    private int projectileAmount;
    private float projectileSpread;
    private int fireRate;
    private int ammoMax;
    private int reloadSpeed;
    private boolean useAmmo;
    private int ammoConsume;
    private boolean canDualWield;
    private Item ammoType;
    private Item innocuousDouble;

    public GunWeaponItem(Properties properties) {
        super(properties);
    }

    public GunWeaponItem(Properties properties, float damage, double speed, int amount, float spread, int rate, int ammoCap, int ammoConsumption, int reload, boolean infinite, boolean dualWield, Item ammo, @Nullable Item iDouble) {
        this(properties);
        this.projectileDamage = damage;
        this.projectileSpeed = speed;
        this.projectileAmount = amount;
        this.projectileSpread = spread;
        this.fireRate = rate;
        this.ammoMax = ammoCap;
        this.ammoConsume = ammoConsumption;
        this.reloadSpeed = reload;
        this.useAmmo = infinite;
        this.canDualWield = dualWield;
        this.ammoType = ammo;
        this.innocuousDouble = iDouble;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F * (float) getAmmoCurrent(stack) / (float) getAmmo());
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 6732543;
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return !getInfinite();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        boolean mainHand = usedHand == InteractionHand.MAIN_HAND;

        ItemStack gun = player.getItemInHand(usedHand);
        ItemStack offHandItem = mainHand ? player.getItemInHand(InteractionHand.OFF_HAND) : player.getItemInHand(InteractionHand.MAIN_HAND);
        boolean offHandEmpty = offHandItem.isEmpty();
        boolean offHandSameItem = offHandItem.getItem() == gun.getItem();

        if(!mainHand && !offHandEmpty && offHandItem.getItem() instanceof GunWeaponItem && !getDualWieldable()) {
            return InteractionResultHolder.fail(gun);
        }

        if(!getInnocuousDouble().isEmpty() && player.isShiftKeyDown() && getAmmoCurrent(gun) > 0) {
            ItemStack newItem = getInnocuousDouble();
            newItem.set(AEItemComponents.GUN_AMMO_COUNT, gun.getOrDefault(AEItemComponents.GUN_AMMO_COUNT, getAmmoCurrent(gun)));
            newItem.set(AEItemComponents.GUN_COOLDOWN_FIRE, gun.getOrDefault(AEItemComponents.GUN_COOLDOWN_FIRE, getLocalFireCooldown(gun)));
            newItem.set(AEItemComponents.GUN_COOLDOWN_RELOAD, gun.getOrDefault(AEItemComponents.GUN_COOLDOWN_RELOAD, getLocalReloadCooldown(gun)));
            return InteractionResultHolder.success(newItem);
        }

        if(getLocalReloadCooldown(gun) > 0) {
            double reloadCooldown = getLocalReloadCooldown(gun) * 0.05;
            int wholeSeconds = (int) Math.rint(reloadCooldown);

            if(!level.isClientSide) {
                MutableComponent message = Component.translatable("message.alchemyexpanded.gun.cooldown", new Object[]{wholeSeconds}).withStyle(ChatFormatting.RED);
                player.displayClientMessage(message, true);
            }
            return InteractionResultHolder.fail(gun);
        }

        if (getAmmoCurrent(gun) <= 0 && !getInfinite() && !player.getAbilities().instabuild && !player.isShiftKeyDown()) {
            if(!level.isClientSide()) {
                    MutableComponent message = Component.translatable("message.alchemyexpanded.gun.empty");
                    player.sendSystemMessage(message.withStyle(ChatFormatting.RED));
            }
            playAmmoEmptySound(level, player);
            return InteractionResultHolder.fail(gun);
        } else if (getAmmoCurrent(gun) <= 0 && player.isShiftKeyDown() && !getInfinite() && !player.getAbilities().instabuild) {
            ItemStack ammoInv = findItem(player, getAmmoType());
            ItemStack ammoSecond = findItemWithCount(player, getAmmoType(), getAmmoConsume());

            if (ammoInv != null && ammoSecond != null) {
                boolean enoughAmmo = getAmmoConsume() <= ammoInv.getCount();
                boolean enoughAmmoSecond = ammoInv.getCount() + ammoSecond.getCount() >= getAmmoConsume();

                if(!enoughAmmo && !enoughAmmoSecond) {
                    if(!level.isClientSide()) {
                        MutableComponent message = Component.translatable("message.alchemyexpanded.gun.need_more_ammo");
                        player.sendSystemMessage(message.withStyle(ChatFormatting.DARK_RED));
                    }
                    playAmmoEmptySound(level, player);
                    return InteractionResultHolder.fail(gun);
                }
                else {
                    if(!level.isClientSide()) {
                        MutableComponent message = Component.translatable("message.alchemyexpanded.gun.reload");
                        player.sendSystemMessage(message.withStyle(ChatFormatting.YELLOW));
                        setAmmoCurrent(gun, getAmmo());
                    }
                    removeItems(player, getAmmoType(), getAmmoConsume());
                    setLocalReloadCooldown(gun, getReload());
                    playReloadSound(level, player);
                    return InteractionResultHolder.pass(gun);
                }
            }
            else {
                if(!level.isClientSide()) {
                    MutableComponent message = Component.translatable("message.alchemyexpanded.gun.no_ammo");
                    player.sendSystemMessage(message.withStyle(ChatFormatting.RED));
                }
                playAmmoEmptySound(level, player);
                return InteractionResultHolder.fail(gun);
            }
        } else {
            int fireCooldown = getLocalFireCooldown(gun);

            if(!mainHand && !offHandSameItem && !offHandEmpty && offHandItem.getItem() instanceof GunWeaponItem) {
                return InteractionResultHolder.fail(gun);
            }

            if(!mainHand && getDualWieldable() && offHandSameItem && getAmmoCurrent(offHandItem) <= 0) {
                if(fireCooldown > 0) {
                    return InteractionResultHolder.fail(gun);
                }
                else {
                    if (!level.isClientSide()) {
                        shoot(level, player, gun);
                        if (!getInfinite() && !player.getAbilities().instabuild) {
                            if (getAmmo() < getAmount()) {
                                setAmmoCurrent(gun, getAmmoCurrent(gun) - 1);
                            } else setAmmoCurrent(gun, getAmmoCurrent(gun) - getAmount());
                        }
                    }

                    addParticles(level, player, 6);                    setLocalFireCooldown(gun, getRate());
                    playFireSound(level, player);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.pass(gun);
                }
            }
            else if(!mainHand && getDualWieldable() && offHandSameItem) {
                if(fireCooldown > 0) {
                    return InteractionResultHolder.fail(gun);
                }
                else {
                    if (!getInfinite() && !player.getAbilities().instabuild) {
                        if (getAmmo() < getAmount()) {
                            setAmmoCurrent(gun, getAmmoCurrent(gun) - 1);
                        } else {
                            setAmmoCurrent(gun, getAmmoCurrent(gun) - getAmount());
                        }
                    }
                    setLocalFireCooldown(gun, getRate());
                    return InteractionResultHolder.pass(gun);
                }
            }
            else if(!offHandSameItem || !getDualWieldable()) {
                if(fireCooldown > 0) {
                    return InteractionResultHolder.fail(gun);
                }
                else {
                    if (!level.isClientSide()) {
                        shoot(level, player, gun);
                        if (!getInfinite() && !player.getAbilities().instabuild) {
                            if (getAmmo() < getAmount()) {
                                setAmmoCurrent(gun, getAmmoCurrent(gun) - 1);
                            } else setAmmoCurrent(gun, getAmmoCurrent(gun) - getAmount());
                        }
                    }

                    addParticles(level, player, 6);                    setLocalFireCooldown(gun, getRate());
                    playFireSound(level, player);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.pass(gun);
                }
            }
            else {
                if(fireCooldown > 0) {
                    return InteractionResultHolder.fail(gun);
                }
                else {
                    if (!level.isClientSide()) {
                        shootDouble(level, player, gun);
                        if (!getInfinite() && !player.getAbilities().instabuild) {
                            if (getAmmo() < getAmount()) {
                                setAmmoCurrent(gun, getAmmoCurrent(gun) - 1);
                            } else {
                                setAmmoCurrent(gun, getAmmoCurrent(gun) - getAmount());
                            }
                        }
                    }

                    setLocalFireCooldown(gun, getRate());
                    addParticles(level, player, 6);
                    playFireSound(level, player);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.pass(gun);
                }
            }
        }
    }

    public void shoot(Level level, Player shooter, ItemStack stack) {
        for (int i = 0; i < getAmount(); i++) {
            ProjectileEntity bullet = new ProjectileEntity(level, shooter);
            bullet.setWeapon(stack);

            bullet.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            bullet.setDamage(getWeaponDamage());

            level.addFreshEntity(bullet);
        }
    }

    public void shootDouble(Level level, Player shooter,ItemStack stack) {
        for (int i = 0; i < getAmount() + getAmount(); i++) {
            float dualWieldBonus = Math.round((getWeaponDamage() / 10) * 2) / 2.0F;
            ProjectileEntity bullet = new ProjectileEntity(level, shooter);
            bullet.setWeapon(stack);

            bullet.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0, (float) getSpeed(), getSpread());
            bullet.setDamage(getWeaponDamage() + dualWieldBonus);

            level.addFreshEntity(bullet);
        }
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @javax.annotation.Nullable
    private static ItemStack findItem(Player player, Item item) {
        for(ItemStack invItem : player.getInventory().items) {
            if (invItem.is(item)) {
                return invItem;
            }
        }

        return null;
    }

    @javax.annotation.Nullable
    private static ItemStack findItemWithCount(Player player, Item item, int count) {
        for(ItemStack invItem : player.getInventory().items) {
            if (invItem.is(item) && invItem.getCount() >= count) {
                return invItem;
            }
        }

        return null;
    }

    private static void removeItems(Player player, Item item, int count) {
        int removeTotal = count;

        for(int i = 0; i < 8; i++) {
            for (ItemStack invItem : player.getInventory().items) {
                if (invItem.is(item)) {
                    if (removeTotal > 0) {
                        player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(invItem), 1);
                        removeTotal--;
                    } else return;
                }
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);

        int fireCooldown = getLocalFireCooldown(stack);
        int reloadCooldown = getLocalReloadCooldown(stack);

        if(fireCooldown <= getRate() && fireCooldown > 0) {
            setLocalFireCooldown(stack, fireCooldown - 1);
        }
        if(reloadCooldown <= getReload() && reloadCooldown > 0) {
            setLocalReloadCooldown(stack, reloadCooldown - 1);
        }
    }

    //override to change particle type
    public void addParticles(Level level, Entity player, int amount) {
        for(int x = 0; x <= amount; x++) {
            Vec3 vecPlayerAngle = player.getLookAngle();
            float offsetX = (level.random.nextFloat() - 0.5F) / 4.0F;
            float offsetY = (level.random.nextFloat() - 0.5F) / 4.0F;
            float offsetZ = (level.random.nextFloat() - 0.5F) / 4.0F;

            level.addAlwaysVisibleParticle(ParticleTypes.FLAME, player.getX() + vecPlayerAngle.x + offsetX, player.getY() + 1.0 + offsetY, player.getZ() + vecPlayerAngle.z + offsetZ, vecPlayerAngle.x / 5, vecPlayerAngle.y / 5, vecPlayerAngle.z / 5);
        }
    }

    public void playSound(Level level, Entity player, SoundEvent sound, float volume, float pitch) {
        level.playSound(null, player.getX(), player.getY(), player.getZ(), sound, SoundSource.PLAYERS, volume, pitch);
    }

    public void playAmmoEmptySound(Level level, Entity player) {
        playSound(level, player, SoundEvents.LEVER_CLICK, 1.0F, 1.0F);
    }

    public void playReloadSound(Level level, Entity player) {
        playSound(level, player, AESoundEvents.BASIC_GUN_RELOAD.get(), 1.0F, 1.0F);
    }

    public void playFireSound(Level level, Entity player) {
        playSound(level, player, AESoundEvents.BASIC_GUNSHOT.get(), 1.0F, 1.0F);
    }

    public void setAmmoCurrent(ItemStack stack, int amount) {
        stack.set(AEItemComponents.GUN_AMMO_COUNT, amount);
    }

    public int getAmmoCurrent(ItemStack stack) {
        return stack.getOrDefault(AEItemComponents.GUN_AMMO_COUNT, this.ammoMax);
    }

    public void setLocalReloadCooldown(ItemStack stack, int amount) {
        stack.set(AEItemComponents.GUN_COOLDOWN_RELOAD, amount);
    }

    public int getLocalReloadCooldown(ItemStack stack) {
        return stack.getOrDefault(AEItemComponents.GUN_COOLDOWN_RELOAD, this.reloadSpeed);
    }

    public void setLocalFireCooldown(ItemStack stack, int amount) {
        stack.set(AEItemComponents.GUN_COOLDOWN_FIRE, amount);
    }

    public int getLocalFireCooldown(ItemStack stack) {
        return stack.getOrDefault(AEItemComponents.GUN_COOLDOWN_FIRE, this.fireRate);
    }

    public float getWeaponDamage() {
        return projectileDamage;
    }

    public double getSpeed() {
        return projectileSpeed;
    }

    public float getSpread() {
        return projectileSpread;
    }

    public int getAmount() {
        return projectileAmount;
    }

    public int getRate() {
        return fireRate;
    }

    public int getAmmo() {
        return ammoMax;
    }

    public int getAmmoConsume() {
        return ammoConsume;
    }

    public int getReload() {
        return reloadSpeed;
    }

    public boolean getInfinite() {
        return useAmmo;
    }

    public boolean getDualWieldable() {
        return canDualWield;
    }

    public Item getAmmoType() {
        return ammoType;
    }

    public ItemStack getInnocuousDouble() {
        if(innocuousDouble != null) {
            return new ItemStack(innocuousDouble);
        }
        else return ItemStack.EMPTY;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        int amount = getAmount();
        int rate = getRate();
        double reloadTime = (double) Math.round((getReload() * 0.05) * 2) / 2.0F;
        int ammoCap = getAmmo();
        int ammoConsumption = getAmmoConsume();
        double timeFireClip = ((rate * 0.05) * ammoCap);
        double ratePerMinuteWithReload = 60 / (timeFireClip + reloadTime);
        double roundsPerMinuteFired =  ratePerMinuteWithReload * ammoCap;
        double damagePerSecond = Math.round(((roundsPerMinuteFired * (amount * getWeaponDamage())) / 60) * 2) / 2.0F;
        double ammoEfficiency = (damagePerSecond * 60) / (ratePerMinuteWithReload * ammoConsumption);
        String ammoType = getAmmoType().getDescriptionId();

        tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.damage", new Object[]{damagePerSecond}).withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.amount", new Object[]{amount}).withStyle(ChatFormatting.GRAY));
        if(!getInfinite()) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.reload_time", new Object[]{reloadTime}).withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_max", new Object[]{ammoCap}).withStyle(ChatFormatting.GRAY));
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.ammo_consume", new Object[]{ammoConsumption}).withStyle(ChatFormatting.GRAY).append(Component.translatable(ammoType).withStyle(ChatFormatting.GRAY)));
        }
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
        if(getInfinite()) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.infinite").withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD));
        }
        if(getDualWieldable()) {
            tooltipComponents.add(Component.translatable("info.alchemyexpanded.gun.dual_wield").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.BOLD));
        }
    }
}
