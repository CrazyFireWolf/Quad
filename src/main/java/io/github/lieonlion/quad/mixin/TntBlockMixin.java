package io.github.lieonlion.quad.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.lieonlion.quad.enchantment.QuadEnchantmentHelper;
import io.github.lieonlion.quad.tags.QuadEnchantmentTags;
import io.github.lieonlion.quad.tags.QuadItemTags;
import io.github.lieonlion.quad.util.QuadUtil;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TntBlock.class)
public abstract class TntBlockMixin {
    @ModifyReturnValue(method = "onUse", at = @At(value = "RETURN"))
    private ActionResult applyTagFireLighters(ActionResult original, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getStackInHand(hand);
        if (QuadUtil.isFireLighter(stack)) {
            TntBlockInvoker.callPrimeTnt(world, pos, player);
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
            QuadUtil.usedFireLighter(world, state, pos, player, hand, stack);
            return ActionResult.success(world.isClient);
        } return original;
    }
}