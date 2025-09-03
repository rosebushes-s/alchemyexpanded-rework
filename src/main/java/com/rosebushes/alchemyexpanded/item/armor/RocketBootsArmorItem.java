package com.rosebushes.alchemyexpanded.item.armor;

import com.mraof.minestuck.util.MSParticleType;
import com.mraof.minestuck.util.MSSoundEvents;
import com.rosebushes.alchemyexpanded.client.model.armor.RocketBootsArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class RocketBootsArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public RocketBootsArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (entity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RocketBootsArmorItem && player.isShiftKeyDown()) {
                Vec3 look = player.getLookAngle();
                Vec3 movement = player.getDeltaMovement();
                player.level().playSound(player, player.blockPosition(), (SoundEvent) MSSoundEvents.ITEM_JETPACK_FLIGHT.get(), SoundSource.PLAYERS, 1.0F, player.getRandom().nextFloat() + 0.35F);
                player.level().addParticle((ParticleOptions) MSParticleType.EXHAUST.get(), player.getX(), player.getY(), player.getZ(), (double)0.0F, (double)0.0F, (double)0.0F);
                player.level().addParticle((ParticleOptions)MSParticleType.EXHAUST.get(), player.getX() - movement.x / (double)2.0F, player.getY() - movement.y / (double)2.0F, player.getZ() - movement.z / (double)2.0F, (double)0.0F, (double)0.0F, (double)0.0F);
                player.setDeltaMovement(movement.add(look.x * 0.1 + (look.x * (double)1.5F - movement.x) * 0.2, look.y * 0.1 + (look.y * (double)1.5F - movement.y) * 0.2, look.z * 0.1 + (look.z * (double)1.5F - movement.z) * 0.2));
            }

            if (!player.level().isClientSide) {
                if ((player.getFallFlyingTicks() + 1) % 20 == 0) {
                    stack.hurtAndBreak(1, player, EquipmentSlot.CHEST);
                }

                ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);
                if (feet.getItem() instanceof RocketBootsArmorItem && player.isShiftKeyDown() && (player.getFallFlyingTicks() + 1) % 5 == 0) {
                    feet.hurtAndBreak(1, player, EquipmentSlot.FEET);
                }
            }
        }

        return true;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> renderer;

            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null) {
                    this.renderer = new GeoArmorRenderer(new RocketBootsArmorModel());
                }

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController[]{new AnimationController(this, "Fly/Idle", 3, (state) -> {
            Entity entity = (Entity)state.getData(DataTickets.ENTITY);
            if (entity instanceof LivingEntity livingEntity) {
                if (livingEntity.isFallFlying()) {
                    return state.setAndContinue(DefaultAnimations.FLY);
                }
            }

            return state.setAndContinue(DefaultAnimations.IDLE);
        })});
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
