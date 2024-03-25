package pro.sky.sheltertelegrambot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import pro.sky.sheltertelegrambot.entity.AnimalShelter;
import pro.sky.sheltertelegrambot.services.SearchShelterByUser;
import pro.sky.sheltertelegrambot.services.ShelterService;

/**
 * Класс выполняет команду по выводу информации о технике безопасности при посещении приюта
 */
@Component
public class CommandSafetyRules implements Command{
    ShelterService service;

    /**
     * Метод выводит информацию о технике безопасности при посещении приюта
     * @param update = команда от пользователя
     * @return = SendMessage
     */
    @Override
    public SendMessage getSendMessage(Update update) {
        AnimalShelter animalShelter = SearchShelterByUser.findByTypeAnimal(update.getMessage().getChatId());
        long id = update.getMessage().getChatId();
        String text = service.receiveSafetyRules(animalShelter.getNameShelter());
        return new SendMessage(String.valueOf(id), text);
    }

    @Override
    public String commandName() {
        return CommandName.SAFETY.getCommandName();
    }
}
