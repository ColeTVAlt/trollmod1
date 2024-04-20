package com.example.examplemod.blockEntities;

import com.example.examplemod.menu.TrollPanelMenu;
import com.example.examplemod.registries.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class TrollPanelBlockEntity extends BlockEntity implements MenuProvider {
    public TrollPanelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TROLL_PANEL_BLOCK.get(), pos, state);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(" TrollMod Admin Menu");
    }

    @Nullable
    @Override
    public TrollPanelMenu createMenu(int i, Inventory inventory, Player player) {
        return new TrollPanelMenu(i);
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand p_60507_, BlockHitResult p_60508_) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(this, friendlyByteBuf -> {
            });
        }


        return InteractionResult.CONSUME;
    }
}
