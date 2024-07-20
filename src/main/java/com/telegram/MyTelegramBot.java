package com.telegram;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegramBot extends TelegramLongPollingBot {

  @Override
    public void onUpdateReceived(Update update) {
        // Check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
      String message_text = update.getMessage().getText();
      long chat_id = update.getMessage().getChatId();
      int message_id = update.getMessage().getMessageId();
      String firstName = update.getMessage().getChat().getFirstName();
             if (message_text.equals ("/show")) {
        SendMessage message = new SendMessage();
          message.setChatId(chat_id+"");
          message.setText("Here is your keyboard");

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
        KeyboardRow row;

       
          row = new KeyboardRow();
          row.add("Order Custom Stickers");
          keyboard.add(row);
          row = new KeyboardRow();
          row.add("Explore Trending Stickers");
          keyboard.add(row);
          row = new KeyboardRow();
          row.add("In Stok Stickers");
          keyboard.add(row);
        

        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);

        delete (chat_id, message_id);

        sendText (message);
      }
      
      else if (message_text.equals("/start")){
        reply(chat_id, "Welcome to PixelStickers,👤 "+firstName+" !\n\n" +
                    "🎉 We're thrilled to have you here. PixelStickers, a branch of PixelLabs, specializes in high-quality physical stickers for phones and laptops. Our stickers are designed to add a touch of personality and protection to your devices. Explore our collection and find the perfect stickers for your gadgets. If you have any questions or need assistance, feel free to ask. Enjoy!");
      }

      else if (message_text.equals("Order Custom Stickers")){
        reply(chat_id, "Comming Soon!");
      }
        }
    }
    boolean reply (long chat_id, String message_text) {
      SendMessage message = new SendMessage();
        message.setChatId(chat_id+"");
        message.setText(message_text);
  
      return sendText (message);
    }
  boolean sendText(SendMessage message) {
    try {
      execute(message);
      return true;
    } catch (TelegramApiException e) {
      e.printStackTrace();
      return false;
    }
  }

  boolean delete(long chat_id, int message_id) {
    DeleteMessage del_message = new DeleteMessage();
    del_message.setChatId(chat_id + "");
    del_message.setMessageId(message_id);
    try {
      execute(del_message);
      return true;
    } catch (TelegramApiException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public String getBotUsername() {
    return "YourBotUsername";
  }

  @Override
  public String getBotToken() {
    return "7488427246:AAEDjeK6omkZgU0X7gI-jNa06qeN9esUoXE";
  }
}
