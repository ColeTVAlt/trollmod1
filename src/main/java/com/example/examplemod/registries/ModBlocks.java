package com.example.examplemod.registries;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blocks.TrollPanelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MODID);

    public static final RegistryObject<Block> TROLL_PANEL_BLOCK = BLOCKS.register("troll_panel_block", () -> new TrollPanelBlock(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST).strength(5f, 100)));
}
