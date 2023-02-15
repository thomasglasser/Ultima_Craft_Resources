package dev.thomasglasser.ultimacraft.ultimacraftresources.world.entity.player;

import dev.thomasglasser.ultimacraft.ultimacraftresources.world.level.storage.SkillsCapabilityAttacher;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;

import java.util.Arrays;

public class UltimaCraftResourcesPlayerEvents {
    public static final String GRAND_MASTER_KEY = "skill.ultimacraftresources.grand_master";
    public static final String ALCHEMY_KEY = "skill.ultimacraftresources.alchemy";

    public static void onPlayerNameFormat(PlayerEvent.NameFormat event)
    {
        event.setDisplayname(appendWithGrandMasterStatuses(event.getPlayer(), event.getDisplayname()));
    }

    public static void onPlayerTabListNameFormat(PlayerEvent.TabListNameFormat event)
    {
        event.setDisplayName(appendWithGrandMasterStatuses(event.getPlayer(), event.getDisplayName()));
    }

    private static Component appendWithGrandMasterStatuses(Player player, Component component)
    {
        if (component == null)
            component = new TextComponent("");

        Component finalComponent = component;
        player.getCapability(SkillsCapabilityAttacher.SKILLS_CAPABILITY).ifPresent(cap ->
        {
            if (cap.getAlchemyLevel() >= 100)
            {
                finalComponent.getSiblings().add(0, addGMStatus(new TranslatableComponent(ALCHEMY_KEY), ChatFormatting.RESET));
            }
        });

        return finalComponent;
    }

    private static Component addGMStatus(Component skill, ChatFormatting formatting)
    {
        return ComponentUtils.formatList(Arrays.asList(new TextComponent(" "), new TextComponent("["), skill, new TextComponent(" "), new TranslatableComponent(GRAND_MASTER_KEY), new TextComponent("]")), new TextComponent("")).copy().setStyle(Style.EMPTY.applyFormat(formatting));
    }
}
