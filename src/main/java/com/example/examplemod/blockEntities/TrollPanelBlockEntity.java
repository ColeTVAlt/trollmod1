package com.example.examplemod.blockEntities;

import com.example.examplemod.menu.TrollPanelMenu;
import com.example.examplemod.registries.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
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
        return new TrollPanelMenu(i, inventory, this);
    }


}
