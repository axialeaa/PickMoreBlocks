package com.axialeaa.pickmoreblocks.util;

import net.fabricmc.fabric.api.event.client.player.ClientPickBlockGatherCallback;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CustomPickLogic {

    /**
     * Iteratively checks every slot in the player's inventory for flint and steel or a fire charge, and gives it to them.
     */
    public static ItemStack onPickFire(PlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack getStackAtSlot = player.getInventory().getStack(i);
            if (getStackAtSlot.isOf(Items.FLINT_AND_STEEL) || getStackAtSlot.isOf(Items.FIRE_CHARGE))
                return getStackAtSlot;
        }
        return new ItemStack(Items.FLINT_AND_STEEL);
    }

    /**
     * Gives the player a bucket containing the liquid they're looking at, unless they're aiming at a block behind the liquid.
     * @implNote This doesn't actually check if you tried to pick a liquid until it decides the hit action was a miss. Its logic isn't mixed into the FluidBlock class (it can't be--liquids can't seem to be targeted) and it's called in the onInitialize() method in the main class. I will not use this for other things if there is an alternative option.
     */
    public static void registerPickFluid() {
        ClientPickBlockGatherCallback.EVENT.register(((player, result) -> {
            if (result instanceof BlockHitResult && result.getType() == HitResult.Type.MISS) {
                World world = player.getEntityWorld();
                BlockPos blockPos = ((BlockHitResult)result).getBlockPos();
                if (world.getBlockState(blockPos).getBlock() instanceof FluidBlock fluidBlock)
                    return new ItemStack(fluidBlock.fluid.getBucketItem());
            }
            return ItemStack.EMPTY;
        }));
    }


}
