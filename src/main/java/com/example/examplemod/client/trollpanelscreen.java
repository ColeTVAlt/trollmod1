package com.example.examplemod.client;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.menu.TrollPanelMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class trollpanelscreen extends AbstractContainerScreen<TrollPanelMenu> {
    private static final ResourceLocation BACKGROUND = new ResourceLocation(ExampleMod.MODID, "textures/gui/troll_panel_block_menu.png");
    protected trollpanelscreen(TrollPanelMenu menu, Inventory playerInv, Component title) {
        super(menu, playerInv,title);

        this.imageHeight = 200;
        this.imageWidth = 200;
    }

    @Override
    protected void init() {
        super.init();


    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }
}
