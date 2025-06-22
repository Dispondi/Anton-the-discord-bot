package org.anton.listeners;

import net.dv8tion.jda.api.JDA;

public class ListenerManager {

    private final JDA api;

    private final SlashListener slashListener;

    public ListenerManager(JDA api) {
        this.api = api;
        slashListener = new SlashListener(api);
    }

    public void registerAllListeners() {
        api.addEventListener(slashListener);
    }
}
