package me.imtoggle.notsoessentialplus.entrypoint

//#if FABRIC
import net.fabricmc.api.ModInitializer
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.DedicatedServerModInitializer
//#elseif FORGE
//#if MC >= 1.16.5
//$$ import net.minecraftforge.eventbus.api.IEventBus
//$$ import net.minecraftforge.fml.common.Mod
//$$ import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
//$$ import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
//$$ import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
//$$ import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
//#else
//$$ import net.minecraftforge.fml.common.Mod
//$$ import net.minecraftforge.fml.common.Mod.EventHandler
//$$ import net.minecraftforge.fml.common.event.FMLInitializationEvent
//#endif
//#elseif NEOFORGE
//$$ import net.neoforged.bus.api.IEventBus
//$$ import net.neoforged.fml.common.Mod
//$$ import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
//$$ import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
//$$ import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
//#endif

import me.imtoggle.notsoessentialplus.ModTemplate
import me.imtoggle.notsoessentialplus.client.ModTemplateClient
import me.imtoggle.notsoessentialplus.server.ModTemplateServer

//#if FORGE-LIKE
//$$ import me.imtoggle.notsoessentialplus.ModTemplateConstants
//#if MC >= 1.16.5
//$$ @Mod(ModTemplateConstants.ID)
//#else
//$$ @Mod(modid = ModTemplateConstants.ID, version = ModTemplateConstants.VERSION)
//#endif
//#endif
class ModTemplateEntrypoint
    //#if FABRIC
    : ModInitializer, ClientModInitializer, DedicatedServerModInitializer
    //#endif
{

    //#if FORGE && MC >= 1.16.5
    //$$ init {
    //$$     setupForgeEvents(FMLJavaModLoadingContext.get().modEventBus)
    //$$ }
    //#elseif NEOFORGE
    //$$ constructor(modEventBus: IEventBus) {
    //$$     setupForgeEvents(modEventBus)
    //$$ }
    //#endif

    //#if FABRIC
    override
    //#endif
    fun onInitialize(
        //#if FORGE-LIKE
        //#if MC >= 1.16.5
        //$$ event: FMLCommonSetupEvent
        //#else
        //$$ event: FMLInitializationEvent
        //#endif
        //#endif
    ) {
        ModTemplate.onInitializeCommon()
    }

    //#if FABRIC
    override
    //#endif
    fun onInitializeClient(
        //#if FORGE-LIKE
        //#if MC >= 1.16.5
        //$$ event: FMLClientSetupEvent
        //#else
        //$$ event: FMLInitializationEvent
        //#endif
        //#endif
    ) {
        //#if MC <= 1.12.2
        //$$ if (!event.side.isClient) return
        //#endif

        ModTemplateClient.onInitializeClient()
    }

    //#if FABRIC
    override
    //#endif
    fun onInitializeServer(
        //#if FORGE-LIKE
        //#if MC >= 1.16.5
        //$$ event: FMLDedicatedServerSetupEvent
        //#else
        //$$ event: FMLInitializationEvent
        //#endif
        //#endif
    ) {
        //#if MC <= 1.12.2
        //$$ if (!event.side.isServer) return
        //#endif

        ModTemplateServer.onInitializeServer()
    }

    //#if FORGE-LIKE && MC >= 1.16.5
    //$$ fun setupForgeEvents(modEventBus: IEventBus) {
    //$$     modEventBus.addListener(this::onInitialize)
    //$$     modEventBus.addListener(this::onInitializeClient)
    //$$     modEventBus.addListener(this::onInitializeServer)
    //$$ }
    //#endif

}
