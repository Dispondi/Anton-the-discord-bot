package org.anton.utils.registry.interaction.commands;

import net.dv8tion.jda.api.interactions.InteractionType;
import org.anton.utils.event.factory.RegistryFactory;
import org.anton.utils.registry.Registry;
import org.anton.utils.registry.interaction.InteractionHandlersRegistry;

public final class InteractionRegistryFactory implements RegistryFactory<InteractionRegistryFactory.Type> {

    // TODO: Create classes for all types and create Registrables for them of course

    public enum Type {
        SLASH (new SlashCommandsRegistry()),
        CONTEXT (new CommandsRegistry()),
        COMPONENT (null),
        MENU (null),
        MODALS (null);

        private final InteractionHandlersRegistry<?> registry;

        Type(InteractionHandlersRegistry<?> registry) {
            this.registry = registry;
        }
    }

    @Override
    public InteractionHandlersRegistry<?> getRegistry(Type type) {
        return switch (type) {
            case SLASH, MODALS, MENU, COMPONENT, CONTEXT -> type.registry;
        };
    }
}
