package dev.thomasglasser.ultimacraft.ultimacraftresources.world.level.storage;

import dev._100media.capabilitysyncer.core.CapabilityAttacher;
import dev.thomasglasser.ultimacraft.ultimacraftresources.UltimaCraftResources;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;

import javax.annotation.Nullable;

public class SkillsCapabilityAttacher extends CapabilityAttacher {
    private static final Class<SkillsCapability> CAPABILITY_CLASS = SkillsCapability.class;
    public static final Capability<SkillsCapability> SKILLS_CAPABILITY = getCapability(new CapabilityToken<>() {});
    public static final ResourceLocation SKILLS_CAPABILITY_RL = UltimaCraftResources.modLoc("skills_capability");

    @Nullable
    public static SkillsCapability getSkillsCapabilityUnwrap(Player player) {
        return getSkillsCapability(player).orElse(null);
    }

    public static LazyOptional<SkillsCapability> getSkillsCapability(Player player) {
        return player.getCapability(SKILLS_CAPABILITY);
    }

    private static void attach(AttachCapabilitiesEvent<Entity> event, Player player) {
        genericAttachCapability(event, new SkillsCapability(player), SKILLS_CAPABILITY, SKILLS_CAPABILITY_RL);
    }

    public static void register() {
        CapabilityAttacher.registerCapability(CAPABILITY_CLASS);
        CapabilityAttacher.registerPlayerAttacher(SkillsCapabilityAttacher::attach, SkillsCapabilityAttacher::getSkillsCapability, true);
    }}
