package com.example.examplemod.blocks;

import com.example.examplemod.blockEntities.TrollPanelBlockEntity;
import com.example.examplemod.menu.TrollPanelMenu;
import com.example.examplemod.registries.ModBlockEntities;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkInstance;
import org.jetbrains.annotations.Nullable;

public class TrollPanelBlock extends Block implements EntityBlock {

    private static final Component CONTAINER_TITLE = Component.translatable("container.crafting");

    private BlockEntity blockEntity;
    public TrollPanelBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        blockEntity = ModBlockEntities.TROLL_PANEL_BLOCK.get().create(blockPos, blockState);

        return blockEntity;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand p_60507_, BlockHitResult p_60508_) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }
        DistExecutor.unsafeRunForDist(Dist.CLIENT, () -> () -> Minecraft.getInstance().setScreen(new TrollPanelBlock(blockPos)));


        return InteractionResult.CONSUME;
    }

    @Override
    public MenuProvider getMenuProvider(BlockState p_52240_, Level p_52241_, BlockPos p_52242_) {
        return new SimpleMenuProvider((p_52229_, p_52230_, p_52231_) -> {
            return new TrollPanelMenu(p_52229_, p_52230_, (FriendlyByteBuf) ContainerLevelAccess.create(p_52241_, p_52242_));
        }, CONTAINER_TITLE);
    }
}
