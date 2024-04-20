package com.example.examplemod.menu;

import com.example.examplemod.blockEntities.TrollPanelBlockEntity;
import com.example.examplemod.registries.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

public class TrollPanelMenu extends AbstractContainerMenu {

    public TrollPanelMenu(int windowId) {
        super(ModMenus.TROLL_PANEL_MENU.get(), windowId);
    }

    public TrollPanelMenu(int windowId, Inventory playerInv, FriendlyByteBuf extraData) {
        super(ModMenus.TROLL_PANEL_MENU.get(), windowId);
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
