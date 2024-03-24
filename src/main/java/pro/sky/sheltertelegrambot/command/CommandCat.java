package pro.sky.sheltertelegrambot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import pro.sky.sheltertelegrambot.services.ShelterService;

@Component
public class CommandCat implements Command{
    ShelterService service;
    @Override
    public SendMessage getSendMessage(Update update) {
        return null;
    }

    @Override
    public String commandName() {
        return CommandName.CAT.getCommandName();
    }
}
