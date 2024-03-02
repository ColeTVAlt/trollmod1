package com.example.examplemod.menu;

import com.example.examplemod.blockEntities.TrollPanelBlockEntity;
import com.example.examplemod.registries.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class TrollPanelMenu extends AbstractContainerMenu {

    private final TrollPanelBlockEntity blockEntity;
    public TrollPanelMenu(int windowId, Inventory playerInv, FriendlyByteBuf extraData) {
        this(windowId, playerInv, (TrollPanelBlockEntity) playerInv.player.level().getBlockEntity(extraData.readBlockPos()));

    }

    public TrollPanelMenu(int windowId, Inventory playerInv, TrollPanelBlockEntity blockEntity) {
        super(ModMenus.TROLL_PANEL_MENU.get(), windowId);

        this.blockEntity = blockEntity;
    }

    
}
