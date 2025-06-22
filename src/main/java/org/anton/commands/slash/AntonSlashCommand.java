package org.anton.commands.slash;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public interface AntonSlashCommand {

    void atGuildEvent(SlashCommandInteractionEvent event);

    void atPrivateEvent(SlashCommandInteractionEvent event);
}
