package pro.sky.sheltertelegrambot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import pro.sky.sheltertelegrambot.entity.TypeAnimal;
import pro.sky.sheltertelegrambot.services.ShelterService;
import pro.sky.sheltertelegrambot.services.UserService;

import static pro.sky.sheltertelegrambot.command.TextMenu.*;

/**
 * Класс выполняет команду при выборе cat
 */
@Component
public class CommandCat implements Command{
    ShelterService service;
    UserService userService;

    /**
     * Метод выводит меню один и сохраняет выбранный тип животного у User в БД
     * @param update = команда от пользователя
     * @return = меню с командами
     */
    @Override
    public SendMessage getSendMessage(Update update) {
        long id = update.getMessage().getChatId();
        userService.updateUser(id, TypeAnimal.CAT);
        return new SendMessage(String.valueOf(id), TEXT_MENU_ONE);
    }

    @Override
    public String commandName() {
        return CommandName.CAT.getCommandName();
    }
}
