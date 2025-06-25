package org.anton.utils.registry.interaction.commands;

import org.anton.utils.registrable.interaction.commands.RegistrableCommand;
import org.anton.utils.registry.Registry;
import org.anton.utils.registry.interaction.InteractionHandlersRegistryImpl;

public class CommandsRegistry extends InteractionHandlersRegistryImpl<RegistrableCommand> {

    CommandsRegistry() {
        super();
    }

    @Override
    public void putObject(RegistrableCommand object) {
        registryMap.putIfAbsent(object.getData().getName(), object);
    }

}
