package net.azophyte.zoeys_train_parts.item;

import net.azophyte.zoeys_train_parts.ZoeysTrainParts;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ZoeysTrainParts.MODID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
