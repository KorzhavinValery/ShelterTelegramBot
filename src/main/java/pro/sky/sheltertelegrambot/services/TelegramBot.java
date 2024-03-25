package pro.sky.sheltertelegrambot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import pro.sky.sheltertelegrambot.command.Command;
import pro.sky.sheltertelegrambot.command.CommandService;
import pro.sky.sheltertelegrambot.config.BotConfig;
import pro.sky.sheltertelegrambot.entity.User;

@Service
public class TelegramBot extends TelegramLongPollingBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(TelegramBot.class);
    private final BotConfig botConfig;
    private CommandService command;

    public TelegramBot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }
    /**
     * Получает имя бота, которое будет использоваться при регистрации на платформе Telegram.
     *
     * @return Имя бота.
     */
    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }
    /**
     * Получает токен бота, который будет использоваться для аутентификации на платформе Telegram.
     *
     * @return Токен бота.
     */
    @Override
    public String getBotToken() {
        return botConfig.getBotToken();
    }
    /**
     * Обработка сообщений от юзера
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            try {
                execute(command.getSendMessage(update));
            } catch (TelegramApiException e) {
                LOGGER.error("Error occurred: " + e.getMessage());
            }

//            String text = update.getMessage().getText();
//            long chatId = update.getMessage().getChatId();
//            String firstName = update.getMessage().getChat().getFirstName();
//            switch (text) {
//                case "/start":
//                    startCommandMessage(chatId, firstName);
//                    break;
//                case "cat":
//                    break;
//                default:
//                    sendMessage(chatId, "Извините, команда недоступна");
//            }
        }
    }
    private void startCommandMessage(long chatId, String name) {
        String startMessage = "Добро пожаловать!" +'\n' + name + ", Чтобы выбрать приют для кошек введите cat, для собак dog";
        sendMessage(chatId, startMessage);
    }

    /**
     * Отправляет сообщение указанному чату с заданным текстовым сообщением.
     *
     * @param chatId      Идентификатор чата, куда нужно отправить сообщение.
     * @param textToSend  Текст сообщения, который следует отправить.
     */
    public void sendMessage(long chatId, String textToSend) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(textToSend);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            LOGGER.error("Error occurred: " + e.getMessage());
        }
    }

    public void sendMessageToUser(User user, String text, int replyToMessageId) throws TelegramApiException {
        //задача - послать юзеру текст

    }
}
