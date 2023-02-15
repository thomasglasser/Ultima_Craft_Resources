package dev.thomasglasser.ultimacraft.ultimacraftresources;

import com.mojang.logging.LogUtils;
import dev.thomasglasser.ultimacraft.ultimacraftresources.core.UltimaCraftResourcesCoreEvents;
import dev.thomasglasser.ultimacraft.ultimacraftresources.data.UltimaCraftResourcesDataGenerator;
import dev.thomasglasser.ultimacraft.ultimacraftresources.world.entity.player.UltimaCraftResourcesPlayerEvents;
import dev.thomasglasser.ultimacraft.ultimacraftresources.world.level.block.UltimaCraftResourcesBlockEvents;
import dev.thomasglasser.ultimacraft.ultimacraftresources.world.level.storage.SkillsCapabilityAttacher;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(UltimaCraftResources.MOD_ID)
public class UltimaCraftResources {

    public static final String MOD_ID = "ultimacraftresources";
    public static final Logger LOGGER = LogUtils.getLogger();

    public UltimaCraftResources() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(UltimaCraftResourcesCoreEvents::onCommonSetup);

        addForgeListeners();

        registerCapabilities();

        bus.addListener(UltimaCraftResourcesDataGenerator::onGatherData);
    }

    private void addForgeListeners()
    {
        MinecraftForge.EVENT_BUS.addListener(UltimaCraftResourcesBlockEvents::onBlockBreak);
        MinecraftForge.EVENT_BUS.addListener(UltimaCraftResourcesPlayerEvents::onPlayerNameFormat);
        MinecraftForge.EVENT_BUS.addListener(UltimaCraftResourcesPlayerEvents::onPlayerTabListNameFormat);
    }

    private void registerCapabilities()
    {
        SkillsCapabilityAttacher.register();
    }

    public static ResourceLocation modLoc(String path)
    {
        return new ResourceLocation(MOD_ID, path);
    }
}
