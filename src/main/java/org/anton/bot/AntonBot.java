package org.anton.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.exceptions.ContextException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.requests.RestAction;
import org.anton.listeners.ListenerManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

public class AntonBot extends ListenerAdapter {

    private static final String TAG = "AntonBot";
    private final Logger logger = LoggerFactory.getLogger(TAG);

    private final JDA api;

    private final List<Command> slashCommands;

    public AntonBot(JDA api) {
        this.api = api;
        this.slashCommands = new ArrayList<>();

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

    public void SlashCommandsBrief() {
        logger.info("Slash commands briefing");

        api.retrieveCommands().queue(new Consumer<List<Command>>() {
            @Override
            public void accept(List<Command> commands) {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                logger.error("Failed to load ");
            }
        });
        createSlashCommand(ListenerManager.SlashCommandsData.OPTIONS);
    }

    private void createSlashCommand(ListenerManager.SlashCommandsData command) {
        // creates if not exists
        Runnable callback = () -> api.upsertCommand(command.getName(), command.getDesc())
                .queue(unused -> logger.debug("Slash command '{}' created successfully", command.name()), // logging
                        throwable -> logger.error("Exception while creating slash command", throwable));

        isCommandExists(command, callback); // function's entry point
    }

    private void isCommandExists(ListenerManager.SlashCommandsData commandData, Runnable ifNotExistsCallback) {
        logger.debug("Checking is slash command '{}' exists", commandData.getName());
        RestAction<Command> request = api.retrieveCommandById(commandData.getTempId());
        request.queue(command -> { // success
                    logger.debug("Response received successfully. Slash command '{}' is exists", command.getName());
                },
                throwable -> { // failure
                    if (throwable.getCause() instanceof ContextException) {
                        logger.debug("Slash command '{}' not exists. Creating.", commandData.getName());
                        ifNotExistsCallback.run();
                    } else logger.error("Exception while checking is slash command exists", throwable);
                });
    }
}
