package com.axialeaa.pickmoreblocks.mixin;

import net.fabricmc.fabric.api.block.BlockPickInteractionAware;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Block.class)
public abstract class BlockMixin implements BlockPickInteractionAware {

    @Override
    public ItemStack getPickedStack(BlockState state, BlockView view, BlockPos pos, PlayerEntity player, HitResult result) {
        if (state.getBlock() instanceof AbstractFireBlock || state.getBlock() instanceof NetherPortalBlock) {
            for (int i = 0; i < player.getInventory().size(); i++) {
                ItemStack getStackAtSlot = player.getInventory().getStack(i);
                if (getStackAtSlot.isOf(Items.FLINT_AND_STEEL) || getStackAtSlot.isOf(Items.FIRE_CHARGE)) {
                    return getStackAtSlot;
                }
            }
            return new ItemStack(Items.FLINT_AND_STEEL);
        }
        return state.getBlock().getPickStack(player.getEntityWorld(), pos, state);
    }

}