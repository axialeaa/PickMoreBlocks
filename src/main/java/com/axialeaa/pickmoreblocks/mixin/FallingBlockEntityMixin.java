package com.axialeaa.pickmoreblocks.mixin;

import net.fabricmc.fabric.api.entity.EntityPickInteractionAware;
import net.minecraft.block.BlockState;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FallingBlockEntity.class)
public abstract class FallingBlockEntityMixin implements EntityPickInteractionAware {

    @Shadow public abstract BlockState getBlockState();

    @Override
    public ItemStack getPickedStack(PlayerEntity player, HitResult result) {
        return new ItemStack(this.getBlockState().getBlock());
    }

}
