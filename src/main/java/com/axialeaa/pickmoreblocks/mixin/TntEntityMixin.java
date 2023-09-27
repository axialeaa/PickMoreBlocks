package com.axialeaa.pickmoreblocks.mixin;

import net.fabricmc.fabric.api.entity.EntityPickInteractionAware;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TntEntity.class)
public abstract class TntEntityMixin implements EntityPickInteractionAware {
    @Override
    public ItemStack getPickedStack(PlayerEntity player, HitResult result) {
        return new ItemStack(Items.TNT);
    }
}
