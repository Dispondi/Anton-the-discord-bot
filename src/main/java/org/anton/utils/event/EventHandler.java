package org.anton.utils.event;


import net.dv8tion.jda.api.events.Event;

public interface EventHandler<T extends Event> {
    void execute(T e);
}
