package com.axialeaa.pickmoreblocks.mixin;

import com.axialeaa.pickmoreblocks.util.CustomPickLogic;
import net.fabricmc.fabric.api.block.BlockPickInteractionAware;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({AbstractFireBlock.class, NetherPortalBlock.class})
public class AbstractFire_NetherPortalBlockMixin implements BlockPickInteractionAware {

    @Override
    public ItemStack getPickedStack(BlockState state, BlockView view, BlockPos pos, PlayerEntity player, HitResult result) {
        return CustomPickLogic.onPickFire(player);
    }

}
