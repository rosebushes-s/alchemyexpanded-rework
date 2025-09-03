package com.rosebushes.alchemyexpanded.util;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.Random;

public class DiceEffectHelper {
    protected static final MobEffectInstance rollTwo = new MobEffectInstance(MobEffects.HARM, 20);
    protected static final MobEffectInstance rollThree = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 1);
    protected static final MobEffectInstance rollFour = new MobEffectInstance(MobEffects.INVISIBILITY, 120);
    protected static final MobEffectInstance rollFive = new MobEffectInstance(MobEffects.HEAL, 20);
    protected static final MobEffectInstance rollSix = new MobEffectInstance(MobEffects.SLOW_FALLING, 120);
    protected static final MobEffectInstance rollSeven = new MobEffectInstance(MobEffects.LEVITATION, 60);
    protected static final MobEffectInstance rollEight = new MobEffectInstance(MobEffects.LUCK, 120, 1);
    protected static final MobEffectInstance rollNine = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 1);
    protected static final MobEffectInstance rollTen = new MobEffectInstance(MobEffects.REGENERATION, 80, 1);
    protected static final MobEffectInstance rollMaxUserDamage = new MobEffectInstance(MobEffects.DAMAGE_BOOST, 80, 2);
    protected static final MobEffectInstance rollMaxUserReduction = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 80, 2);
    protected static final MobEffectInstance rollMaxTarget = new MobEffectInstance(MobEffects.HARM, 20, 4);

    public DiceEffectHelper() {
    }

    public float getDiceDamage(int amount, int value, int damage, LivingEntity user, LivingEntity target, boolean enchanted) {
        Random random = new Random();
        int totalDamage = 0;
        int[] previousRolls = new int[amount];
        ArrayList<MobEffectInstance> rollList = new ArrayList<MobEffectInstance>();
        rollList.add(rollTwo);
        rollList.add(rollThree);
        rollList.add(rollFour);
        rollList.add(rollFive);
        rollList.add(rollSix);
        rollList.add(rollSeven);
        rollList.add(rollEight);
        rollList.add(rollNine);
        rollList.add(rollTen);

        for(int i = 0; i < amount; i++) {
            int roll = random.nextInt(value);

            if(roll < 1) {
                roll = 1;
            }
            if(user.hasEffect(MobEffects.LUCK) && roll < value) {
                int luckBonus = 0;

                luckBonus = (user.getEffect(MobEffects.LUCK).getAmplifier() + 1);
                roll = roll + luckBonus;

                if(roll > value) {
                    roll = value;
                }
            }

            int prev = checkPreviousSameRolls(previousRolls, roll);

            if(enchanted) {
                if(prev == 0) {
                    addRollEffect(user, target, roll, value, random, rollList);
                }
                else {
                    addRollBonusEffect(user, target, roll, value, random, prev, rollList);
                }
                if(prev == value - 1 && roll == value) {
                    addMaxRollAllEffect(user, target);
                }
            }

            totalDamage = totalDamage + (damage * roll);

            if(prev == value - 1 && roll == value) {
                totalDamage = totalDamage * 4;
            }

            previousRolls[i] = roll;
        }

        if(user instanceof Player) {
            sendRollsMessage(previousRolls, (Player)user);
        }

        return (float) totalDamage;
    }

    public void addRollEffect(LivingEntity user, LivingEntity target, int roll, int value, Random random, ArrayList<MobEffectInstance> rollList) {
        if(!target.level().isClientSide()) {
            for(MobEffectInstance i : rollList) {
                if(rollList.get(roll) == i) {
                    if(i == rollTwo) {
                        target.addEffect(new MobEffectInstance(rollTwo));
                    }
                    else if(i == rollThree) {
                        target.addEffect(new MobEffectInstance(rollThree));
                    }
                    else if(i == rollFour) {
                        user.addEffect(new MobEffectInstance(rollFour));
                    }
                    else if(i == rollFive) {
                        user.addEffect(new MobEffectInstance(rollFive));
                    }
                    else if(i == rollSix) {
                        user.addEffect(new MobEffectInstance(rollSix));
                    }
                    else if(i == rollSeven) {
                        target.addEffect(new MobEffectInstance(rollSeven));
                    }
                    else if(i == rollEight) {
                        user.addEffect(new MobEffectInstance(rollEight));
                    }
                    else if(i == rollNine) {
                        user.addEffect(new MobEffectInstance(rollNine));
                    }
                    else if(i == rollTen) {
                        user.addEffect(new MobEffectInstance(rollTen));
                    }
                }
            }
        }
    }

    public void addRollBonusEffect(LivingEntity user, LivingEntity target, int roll, int value, Random random, int prevSame, ArrayList<MobEffectInstance> rollList) {
        if(!target.level().isClientSide()) {
            for(MobEffectInstance i : rollList) {
                if(rollList.get(roll) == i) {
                    if(i == rollTwo) {
                        MobEffectInstance newTwo = new MobEffectInstance(MobEffects.HARM, 20, prevSame);

                        if(target.hasEffect(MobEffects.HARM)) {
                            target.removeEffect(MobEffects.HARM);
                        }
                        target.addEffect(new MobEffectInstance(newTwo));
                    }
                    else if(i == rollThree) {
                        MobEffectInstance newThree = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, prevSame);

                        if(target.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                            target.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                        }
                        target.addEffect(new MobEffectInstance(newThree));
                    }
                    else if(i == rollFour) {
                        MobEffectInstance newFour = new MobEffectInstance(MobEffects.INVISIBILITY, (60 * prevSame) + 60);

                        if(user.hasEffect(MobEffects.INVISIBILITY)) {
                            user.removeEffect(MobEffects.INVISIBILITY);
                        }
                        user.addEffect(new MobEffectInstance(newFour));
                    }
                    else if(i == rollFive) {
                        MobEffectInstance newFive = new MobEffectInstance(MobEffects.HEAL, 20, prevSame);

                        if(user.hasEffect(MobEffects.HEAL)) {
                            user.removeEffect(MobEffects.HEAL);
                        }
                        user.addEffect(new MobEffectInstance(newFive));
                    }
                    else if(i == rollSix) {
                        MobEffectInstance newSix = new MobEffectInstance(MobEffects.SLOW_FALLING, (60 * prevSame) + 60);

                        if(user.hasEffect(MobEffects.SLOW_FALLING)) {
                            user.removeEffect(MobEffects.SLOW_FALLING);
                        }
                        user.addEffect(new MobEffectInstance(newSix));
                    }
                    else if(i == rollSeven) {
                        MobEffectInstance newSeven = new MobEffectInstance(MobEffects.LEVITATION, (30 * prevSame) + 30);

                        if(target.hasEffect(MobEffects.LEVITATION)) {
                            target.removeEffect(MobEffects.LEVITATION);
                        }
                        target.addEffect(new MobEffectInstance(newSeven));
                    }
                    else if(i == rollEight) {
                        MobEffectInstance newEight = new MobEffectInstance(MobEffects.LUCK, 120, prevSame);

                        if(user.hasEffect(MobEffects.LUCK)) {
                            user.removeEffect(MobEffects.LUCK);
                        }
                        user.addEffect(new MobEffectInstance(newEight));
                    }
                    else if(i == rollNine) {
                        MobEffectInstance newNine = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, prevSame);

                        if(user.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                            user.removeEffect(MobEffects.MOVEMENT_SPEED);
                        }
                        user.addEffect(new MobEffectInstance(newNine));
                    }
                    else if(i == rollTen) {
                        MobEffectInstance newTen = new MobEffectInstance(MobEffects.REGENERATION, 120, prevSame);

                        if(user.hasEffect(MobEffects.REGENERATION)) {
                            user.removeEffect(MobEffects.REGENERATION);
                        }
                        user.addEffect(new MobEffectInstance(newTen));
                    }
                }
            }
        }
    }

    public void addMaxRollAllEffect(LivingEntity user, LivingEntity target) {
        if(!user.level().isClientSide()) {
            user.addEffect(new MobEffectInstance(rollMaxUserDamage));
            user.addEffect(new MobEffectInstance(rollMaxUserReduction));
            target.addEffect(new MobEffectInstance(rollMaxTarget));
        }
    }

    protected int checkPreviousSameRolls(int[] prev, int roll) {
        int totalSame = 0;
        for(int i : prev) {
            if(roll == i) {
                totalSame++;
            }
        }

        return totalSame;
    }

    protected void sendRollsMessage(int[] prev, Player user) {
        Component component = Component.translatable("info.alchemyexpanded.dice.roll");
        for(int i : prev) {
            Component comp = component;
            component = comp.copy().append(Component.literal(String.valueOf(i)  + " "));
        }
        Component comp = component;
        component = comp.copy().append(Component.literal("."));
        user.sendSystemMessage(component);
    }
}