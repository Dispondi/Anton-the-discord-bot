package org.anton.utils.registry.interaction.commands;

import org.anton.utils.registrable.interaction.commands.RegistrableSlashCommand;
import org.anton.utils.registry.interaction.InteractionHandlersRegistryImpl;

public class SlashCommandsRegistry extends InteractionHandlersRegistryImpl<RegistrableSlashCommand> {

    SlashCommandsRegistry() {
        super();
    }

    @Override
    public void putObject(RegistrableSlashCommand object) {
        registryMap.putIfAbsent(object.getData().getName(), object);
    }
}
