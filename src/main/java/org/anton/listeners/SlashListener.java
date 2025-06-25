package org.anton.listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.anton.utils.registry.RegistryKeeper;
import org.anton.utils.registry.interaction.commands.SlashCommandsRegistry;
import org.jetbrains.annotations.NotNull;

public class SlashListener extends ListenerAdapter {

    private final JDA api;

    private SlashCommandsRegistry registry;

    public SlashListener(JDA api) {
        this.api = api;
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

    }
}
