package net.azophyte.zoeys_train_parts.entity;

import net.azophyte.zoeys_train_parts.ZoeysTrainParts;
import net.azophyte.zoeys_train_parts.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, ZoeysTrainParts.MODID);

    public static final Supplier<BlockEntityType<GangwayBlockEntity>> GANGWAY_BE =
            BLOCK_ENTITIES.register("gangway_be", () -> BlockEntityType.Builder.of(
                    GangwayBlockEntity::new, ModBlocks.GangwayBlock.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
