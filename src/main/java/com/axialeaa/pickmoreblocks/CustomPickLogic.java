package com.axialeaa.pickmoreblocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class CustomPickLogic {

    public static ItemStack onPickFire(PlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack getStackAtSlot = player.getInventory().getStack(i);
            if (getStackAtSlot.isOf(Items.FLINT_AND_STEEL) || getStackAtSlot.isOf(Items.FIRE_CHARGE))
                return getStackAtSlot;
        }
        return new ItemStack(Items.FLINT_AND_STEEL);
    }

}
