package org.anton.listeners;

import net.dv8tion.jda.api.JDA;

public class ListenerManager {

    private final SlashListener slashListener;

    public ListenerManager() {
        slashListener = new SlashListener();
    }

    public void registerAllListeners(JDA api) {
        api.addEventListener(slashListener);
    }

    public enum SlashCommandsData {
        OPTIONS ("options", "Вызвать меню настроек");

        private final String name;
        private final String desc;

        SlashCommandsData(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }
    }
}
