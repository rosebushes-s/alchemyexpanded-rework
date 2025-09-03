package com.rosebushes.alchemyexpanded.item.shield;

import com.rosebushes.alchemyexpanded.item.AEItemTypes;

public class PogoShieldItem extends AEShieldItem {
    public PogoShieldItem(Properties properties, double attackBonus, double armorRating, double movementSpeedDebuff) {
        super(AEItemTypes.SHIELD_TOOL_TYPE, properties, attackBonus, armorRating, movementSpeedDebuff);
    }
}
