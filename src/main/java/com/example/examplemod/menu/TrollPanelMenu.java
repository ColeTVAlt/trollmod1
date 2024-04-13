package com.example.examplemod.menu;

import com.example.examplemod.blockEntities.TrollPanelBlockEntity;
import com.example.examplemod.registries.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

public class TrollPanelMenu extends AbstractContainerMenu {

    private final TrollPanelBlockEntity blockEntity;
    public TrollPanelMenu(int windowId, Inventory playerInv, FriendlyByteBuf extraData) {
        this(windowId, playerInv, (TrollPanelBlockEntity) playerInv.player.level().getBlockEntity(extraData.readBlockPos()));

    }

    public TrollPanelMenu(int windowId, Inventory playerInv, TrollPanelBlockEntity blockEntity) {
        super(ModMenus.TROLL_PANEL_MENU.get(), windowId);

        this.blockEntity = blockEntity;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int clickedSlot) {
        var leftOver = ItemStack.EMPTY;
        var slot = slots.get(clickedSlot);

        if (slot.hasItem()) {
            var clickedStack = slot.getItem();
            leftOver = clickedStack.copy();

            if (clickedSlot == 0) {
                if (!moveItemStackTo(clickedStack, 1, 37, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(clickedStack, 0, 1, false)) {
                return ItemStack.EMPTY;
            }
        }

        return leftOver;
    }

    @Override
    public boolean stillValid(Player player) {
        //return blockEntity.stillValid(player);
        return true;
    }

    @Override
    public boolean clickMenuButton(Player player, int pId) {


        return true;
    }


}
