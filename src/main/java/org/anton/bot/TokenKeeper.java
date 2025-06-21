package org.anton.bot;

public enum TokenKeeper {
    BOT_TOKEN ("your token");

    private final String token;

    TokenKeeper(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
