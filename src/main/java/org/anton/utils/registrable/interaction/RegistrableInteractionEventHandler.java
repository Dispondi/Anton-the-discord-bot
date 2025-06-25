package org.anton.utils.registrable.interaction;

import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import org.anton.utils.event.EventHandler;
import org.anton.utils.registrable.Registrable;

public interface RegistrableInteractionEventHandler
        extends Registrable<String>, EventHandler<GenericInteractionCreateEvent> { }
