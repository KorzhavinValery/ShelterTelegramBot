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
     * @param id = id User
     * @return = String
     */
    @Override
    public String getSendMessage(long id, String firstName) {
        if (userService.checkUser(id)) { // проверяем есть ли User в БД
            return  "Добро пожаловать!" + '\n'
                    + firstName
                    + ", Чтобы выбрать приют для кошек введите cat, для собак dog";
        }else {
            String text = "Добро пожаловать!" + '\n'
                    + firstName + '\n'
                    + "Данный бот поможет вам найти своего питомца! И ответит на интересующие вас вопросы" + '\n'
                    + "Чтобы выбрать приют для кошек введите /cat, для собак /dog";
            userService.saveUser(id, firstName); // сохраняем User в БД
            return text;
        }
    }

    @Override
    public String commandName() {
        return CommandName.START.getCommandName();
    }
}
