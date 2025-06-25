package org.anton.utils.registrable.interaction.commands;

import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public interface RegistrableSlashCommand extends RegistrableCommand {

    @Override
    SlashCommandData getData();
}
