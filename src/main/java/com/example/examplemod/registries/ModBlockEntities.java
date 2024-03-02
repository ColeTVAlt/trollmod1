package com.example.examplemod.registries;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.blockEntities.TrollPanelBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExampleMod.MODID);

    public static final RegistryObject<BlockEntityType<?>> TROLL_PANEL_BLOCK = BLOCK_ENTITIES.register("troll_panel_block", () -> newType(TrollPanelBlockEntity::new, Set.of(ModBlocks.TROLL_PANEL_BLOCK.get())));

    private static <T extends BlockEntity> BlockEntityType<T> newType(BlockEntityType.BlockEntitySupplier<T> constructor, Set<Block> validBlocks) {
        return new BlockEntityType<>(constructor, validBlocks, null);
    }
}
