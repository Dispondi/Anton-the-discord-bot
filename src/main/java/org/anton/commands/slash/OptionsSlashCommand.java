package org.anton.commands.slash;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class OptionsSlashCommand implements AntonSlashCommand {

    private JDA api;

    OptionsSlashCommand(JDA api) {
        this.api = api;
    }

    @Override
    public void atGuildEvent(SlashCommandInteractionEvent event) {

    }

    @Override
    public void atPrivateEvent(SlashCommandInteractionEvent event) {

    }
}
