package org.anton.utils.registry.interaction;

import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import org.anton.utils.registrable.interaction.RegistrableInteractionEventHandler;
import org.anton.utils.registry.Registry;

public interface InteractionHandlersRegistry<T extends RegistrableInteractionEventHandler>
        extends Registry<String, T> {

}
