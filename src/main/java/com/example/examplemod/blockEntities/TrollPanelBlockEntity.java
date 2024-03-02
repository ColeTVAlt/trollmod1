package com.example.examplemod.blockEntities;

import com.example.examplemod.registries.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TrollPanelBlockEntity extends BlockEntity {
    public TrollPanelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TROLL_PANEL_BLOCK.get(), pos, state);
    }
}
