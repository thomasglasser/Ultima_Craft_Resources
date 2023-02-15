package dev.thomasglasser.ultimacraft.ultimacraftresources.world.level.block;

import dev.thomasglasser.ultimacraft.ultimacraftresources.world.level.storage.SkillsCapability;
import dev.thomasglasser.ultimacraft.ultimacraftresources.world.level.storage.SkillsCapabilityAttacher;
import net.minecraftforge.event.world.BlockEvent;

public class UltimaCraftResourcesBlockEvents
{
    public static void onBlockBreak(BlockEvent.BreakEvent event)
    {
        if (!event.getPlayer().getAbilities().instabuild)
            event.setCanceled(true);
    }
}
