package org.anton.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import org.anton.listeners.ListenerManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AntonBot extends ListenerAdapter {

    private static final String TAG = "AntonBot";
    private final Logger logger = LoggerFactory.getLogger(TAG);

    private final JDA api;

    private final List<Command> slashCommands;

    public AntonBot(JDA api) {
        this.api = api;
        this.slashCommands = new ArrayList<>();
        updateSlashCommandsList();
    }

    private void updateSlashCommandsList() {
        slashCommands.clear();

        try {
            this.slashCommands.addAll(getSlashCommandsFromAPI(api));
            logger.debug("Slash commands list filled successfully");
        } catch (Exception e) {
            logger.error("Failed to get slash commands", e);
        }
    }

    private static List<Command> getSlashCommandsFromAPI(JDA api) throws ExecutionException, InterruptedException {
        CompletableFuture<List<Command>> future = new CompletableFuture<>();
        api.retrieveCommands().queue(
                future::complete,
                future::completeExceptionally
        );
        return future.get();
    }

    public void deleteSlashCommands() {
        logger.info("Deleting slash commands");
        for (Command c : slashCommands) {
            c.delete()
                .queue(unused -> logger.debug("Slash command '{}' deleted successfully", c.getName()),
                        throwable -> logger.error("Failed to delete slash command", throwable));
        }
    }

    // TODO: loggin is async, updateSlashCommandsList() is happening before createSlashCommandIfNotExists() will be done. FIX IT
    public void SlashCommandsBrief() {
        logger.info("Slash commands briefing");
        logger.info("Slash command list size BEFORE briefing: {}", slashCommands.size());

        logger.debug("Briefing /{} started", ListenerManager.SlashCommandsData.OPTIONS.getName());
        createSlashCommandIfNotExists(ListenerManager.SlashCommandsData.OPTIONS);

        updateSlashCommandsList();
        logger.info("Slash command list size AFTER briefing: {}", slashCommands.size());
    }

    private void createSlashCommandIfNotExists(ListenerManager.SlashCommandsData command) {
        // creates if not exists
        Runnable callback = () -> api.upsertCommand(command.getName(), command.getDesc())
                .queue(unused -> logger.debug("Slash command '{}' created successfully", command.name()), // logging
                        throwable -> logger.error("Exception while creating slash command", throwable));

        isCommandExists(command, callback); // method's entry point
    }

    private void isCommandExists(ListenerManager.SlashCommandsData commandData, Runnable ifNotExistsCallback) {
        logger.debug("Checking is slash command '{}' exists", commandData.getName());

        // exists
        for (Command c : slashCommands) {
            if (c.getName().equals(commandData.getName())) {
                logger.debug("Response received successfully. Slash command '{}' is exists", commandData.getName());
                return;
            }
        }

        // not exists
        logger.debug("Slash command '{}' not exists. Creating.", commandData.getName());
        ifNotExistsCallback.run();
    }
}
