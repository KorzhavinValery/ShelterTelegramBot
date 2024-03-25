package pro.sky.sheltertelegrambot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import pro.sky.sheltertelegrambot.services.ShelterService;
import pro.sky.sheltertelegrambot.services.UserService;

/**
 * Класс выполняет команду старт
 */
@Component
public class CommandStart implements Command{
    UserService userService;

    /**
     * Метод получает команду /start
     * проверяет есть ли данный User в БД
     * если есть - то предлагает выбрать тип животного
     * если нет - сохраняет User в БД, пишет приветственное сообщение о боте и предлагает выбрать тип животного
     * @param update = команда от пользователя
     * @return = SendMessage
     */
    @Override
    public SendMessage getSendMessage(Update update) {
        long id = update.getMessage().getChatId();
        if (userService.checkUser(id)) { // проверяем есть ли User в БД
            String text = "Добро пожаловать!" + '\n'
                    + update.getMessage().getChat().getFirstName()
                    + ", Чтобы выбрать приют для кошек введите cat, для собак dog";
            return new SendMessage(String.valueOf(id), text);
        }else {
            String text = "Добро пожаловать!" + '\n'
                    + update.getMessage().getChat().getFirstName() + '\n'
                    + "Данный бот поможет вам найти своего питомца! И ответит на интересующие вас вопросы" + '\n'
                    + "Чтобы выбрать приют для кошек введите /cat, для собак /dog";
            userService.saveUser(update); // сохраняем User в БД
            return new SendMessage(String.valueOf(id), text);
        }
    }

    @Override
    public String commandName() {
        return CommandName.START.getCommandName();
    }
}
