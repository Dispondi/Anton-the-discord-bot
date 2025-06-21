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
        OPTIONS ("0", "options", "Вызвать меню настроек");

        private final String tempId;
        private final String name;
        private final String desc;

        SlashCommandsData(String tempId, String name, String desc) {
            this.name = name;
            this.desc = desc;
            this.tempId = tempId;
        }

        public String getTempId() {
            return tempId;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }
    }
}
