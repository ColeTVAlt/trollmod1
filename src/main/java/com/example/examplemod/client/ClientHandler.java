package com.example.examplemod.client;

import com.example.examplemod.menu.TrollPanelMenu;
import com.example.examplemod.registries.ModMenus;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientHandler {
    public static void register() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        var fmlBus = MinecraftForge.EVENT_BUS;

        modBus.addListener(ClientHandler::clientSetup);
    }

    private static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
           setRenderLayers();
            MenuScreens.register(ModMenus.TROLL_PANEL_MENU.get(), trollpanelscreen::new);
        });
    }

    private static void setRenderLayers() {

    }
}
