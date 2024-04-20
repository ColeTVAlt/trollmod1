package com.example.examplemod.registries;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.menu.TrollPanelMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ExampleMod.MODID);

    public static final RegistryObject<MenuType<TrollPanelMenu>> TROLL_PANEL_MENU = MENU_TYPES.register("troll_panel_menu", () -> IForgeMenuType.create(TrollPanelMenu::new));
}
