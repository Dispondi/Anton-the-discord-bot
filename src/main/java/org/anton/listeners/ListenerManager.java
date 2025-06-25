package org.anton.listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public final class ListenerManager {

    private final ArrayList<ListenerAdapter> listeners;

    private static volatile ListenerManager INSTANCE;

    private ListenerManager() {
        listeners = new ArrayList<>();
    }

    public static ListenerManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ListenerManager.class) {
                if (INSTANCE == null) INSTANCE = new ListenerManager();
            }
        }

        return INSTANCE;
    }

    public void registerAllListeners(JDA api) {
        api.addEventListener(listeners);
    }

    public void putListener(ListenerAdapter listener) {
        listeners.add(listener);
    }

    public ArrayList<ListenerAdapter> getListeners() {
        return listeners;
    }
}
