package org.anton;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.anton.bot.AntonBot;
import org.anton.bot.TokenKeeper;
import org.anton.listeners.ListenerManager;

public class Launcher {

    private static final String BOT_TOKEN = TokenKeeper.BOT_TOKEN.getToken();
    private static final String TAG = "Launcher";

    public static void main(String[] args) throws InterruptedException {

        // init
        JDA api = JDABuilder.createLight(BOT_TOKEN)
                .setEnabledIntents(
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_VOICE_STATES,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_MESSAGE_REACTIONS,
                        GatewayIntent.MESSAGE_CONTENT)
                .build()
                .awaitReady();

        
    }
}