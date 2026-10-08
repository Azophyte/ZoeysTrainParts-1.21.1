package net.azophyte.zoeys_train_parts;

import net.azophyte.zoeys_train_parts.Model.GangwayFrameModel;
import net.azophyte.zoeys_train_parts.entity.ModBlockEntities;
import net.azophyte.zoeys_train_parts.entity.renderer.GangwayBlockEntityRenderer;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = ZoeysTrainParts.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = ZoeysTrainParts.MODID, value = Dist.CLIENT)
public class ZoeysTrainPartsClient {
    public ZoeysTrainPartsClient(ModContainer container) {
        // Allows NeoForge to create a config screen for this mod's configs.
        // The config screen is accessed by going to the Mods screen > clicking on your mod > clicking on config.
        // Do not forget to add translations for your config options to the en_us.json file.
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);


    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        ZoeysTrainParts.LOGGER.info("HELLO FROM CLIENT SETUP");
        ZoeysTrainParts.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.GANGWAY_BE.get(), GangwayBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerGangwayFrameModel(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GangwayFrameModel.LAYER_LOCATION, GangwayFrameModel::createBodyLayer);
    }
}
