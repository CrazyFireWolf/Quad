package io.github.lieonlion.quad.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.lieonlion.quad.util.QuadUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = CandleBlock.class, priority = 1004)
public abstract class CandleBlockMixin {
    @ModifyReturnValue(method = "useItemOn", at = @At(value = "RETURN"))
    private ItemInteractionResult applyTagFireLighters(ItemInteractionResult original, ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (QuadUtil.isFireLighter(stack) && CandleBlock.canLight(state)) {
            QuadUtil.usedFireLighter(level, state, pos, player, hand, stack);
            return ItemInteractionResult.sidedSuccess(level.isClientSide);
        } return original;
    }
}