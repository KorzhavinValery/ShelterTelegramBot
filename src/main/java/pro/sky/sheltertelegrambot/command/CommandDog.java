package pro.sky.sheltertelegrambot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import pro.sky.sheltertelegrambot.entity.TypeAnimal;
import pro.sky.sheltertelegrambot.services.ShelterService;
import pro.sky.sheltertelegrambot.services.UserService;

import static pro.sky.sheltertelegrambot.command.TextMenu.*;

@Component
public class CommandDog implements Command {
    ShelterService service;
    UserService userService;

    @Override
    public SendMessage getSendMessage(Update update) {
        long id = update.getMessage().getChatId();
        userService.updateUser(id, TypeAnimal.DOG);
        return new SendMessage(String.valueOf(id), TEXT_MENU_ONE);
    }

    @Override
    public String commandName() {
        return CommandName.DOG.getCommandName();
    }
}
