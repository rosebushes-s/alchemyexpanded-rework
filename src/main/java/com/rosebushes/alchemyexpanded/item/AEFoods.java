package com.rosebushes.alchemyexpanded.item;

import net.minecraft.world.food.FoodProperties;

public class AEFoods {
    public static final FoodProperties FLAY_DOH = (new FoodProperties.Builder().nutrition(0).saturationModifier(0.1F).build());
    public static final FoodProperties DITO = (new FoodProperties.Builder().nutrition(1).saturationModifier(0.0F).fast().build());
    public static final FoodProperties DITO_DETRITUS = (new FoodProperties.Builder().nutrition(3).saturationModifier(0.4F).alwaysEdible().build());
    public static final FoodProperties WARHEAD = (new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).fast().alwaysEdible().build());
    public static final FoodProperties CHICKEN_CLUB_SALAD = (new FoodProperties.Builder().nutrition(10).saturationModifier(0.5F).build());
    public static final FoodProperties WIZARD_BERRIES = (new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).fast().alwaysEdible().build());
    public static final FoodProperties WIZARDBERRY_GUSHERS = (new FoodProperties.Builder().nutrition(2).saturationModifier(0.2F).fast().alwaysEdible().build());
    public static final FoodProperties HONEY_GUSHERS = (new FoodProperties.Builder().nutrition(2).saturationModifier(0.2F).fast().alwaysEdible().build());
    public static final FoodProperties MILK_GUSHERS = (new FoodProperties.Builder().nutrition(2).saturationModifier(0.2F).fast().alwaysEdible().build());

    public AEFoods() {

    }
}
