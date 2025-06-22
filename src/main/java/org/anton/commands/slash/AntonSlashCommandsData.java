package org.anton.commands.slash;

public enum AntonSlashCommandsData {
    OPTIONS ("options", "Вызвать меню настроек");

    private final String name;
    private final String desc;

    AntonSlashCommandsData(String name, String desc) {
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