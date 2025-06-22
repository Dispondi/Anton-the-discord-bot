package org.anton.commands.slash;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent;

public class SlashCommandFactory {

    private volatile OptionsSlashCommand optionsCommandInstance;

    private final JDA api;

    public SlashCommandFactory(JDA api) {
        this.api = api;
    }

    private OptionsSlashCommand getOptionsCommandInstance() {
        if (optionsCommandInstance == null) {
            synchronized (OptionsSlashCommand.class) {
                if (optionsCommandInstance == null) {
                    optionsCommandInstance = new OptionsSlashCommand(api);
                }
            }
        }

        return optionsCommandInstance;
    }

    public AntonSlashCommand getCommandInstance(AntonSlashCommandsData command) {
        return switch (command) {
            case OPTIONS -> getOptionsCommandInstance();
        };
    }
}
