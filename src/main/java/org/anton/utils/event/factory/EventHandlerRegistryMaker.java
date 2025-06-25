package org.anton.utils.event.factory;

import org.anton.utils.registry.interaction.commands.InteractionRegistryFactory;

public class EventHandlerRegistryMaker {

    // TODO: Create more factories

    public enum EventHandlerType {
        INTERACTION
    }

    public static RegistryFactory<?> makeFactory(EventHandlerType type) {
        return switch (type) {
            case INTERACTION -> new InteractionRegistryFactory();
        };
    }
}
