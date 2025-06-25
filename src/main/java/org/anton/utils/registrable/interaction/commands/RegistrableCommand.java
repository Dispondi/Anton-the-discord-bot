package org.anton.utils.registrable.interaction.commands;

import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.anton.utils.registrable.interaction.RegistrableInteractionEventHandler;

public interface RegistrableCommand extends RegistrableInteractionEventHandler {
    CommandData getData();
}
