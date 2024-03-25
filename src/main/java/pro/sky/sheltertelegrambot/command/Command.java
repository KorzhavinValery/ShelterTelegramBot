package pro.sky.sheltertelegrambot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Интерфейс для реализации паттерна команды
 */
public interface Command {
    SendMessage getSendMessage(Update update);

    String commandName();
}
