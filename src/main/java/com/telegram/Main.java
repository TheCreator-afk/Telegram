package com.telegram;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        // Instantiate Telegram Bots API
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        // Register our bot
        try {
            botsApi.registerBot(new MyTelegramBot());
            System.out.println("Bot's alive!");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
