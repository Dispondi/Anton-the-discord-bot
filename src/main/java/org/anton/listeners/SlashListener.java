package org.anton.listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.anton.commands.slash.OptionsSlashCommand;
import org.anton.commands.slash.SlashCommandFactory;

public class SlashListener extends ListenerAdapter {

    private SlashCommandFactory commandFactory;

    SlashListener(JDA api) {
        commandFactory = new SlashCommandFactory(api);
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

    }


}
