package pro.sky.sheltertelegrambot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import pro.sky.sheltertelegrambot.entity.AnimalShelter;
import pro.sky.sheltertelegrambot.services.SearchShelterByUser;
import pro.sky.sheltertelegrambot.services.ShelterService;
import pro.sky.sheltertelegrambot.services.ShelterServiceImpl;

/**
 * Класс выполняет команду по выводу контактной информации о приюте
 */
@Component
public class CommandContactInformation implements Command{
    ShelterService service;

    /**
     * Метод выводит контактную информацию о приюте
     * @param update = команда от пользователя
     * @return = SendMessage
     */
    @Override
    public SendMessage getSendMessage(Update update) {
        AnimalShelter animalShelter = SearchShelterByUser.findByTypeAnimal(update.getMessage().getChatId());
        long id = update.getMessage().getChatId();
        String text = service.receiveContactInformation(animalShelter.getNameShelter());
        return new SendMessage(String.valueOf(id), text);
    }

    @Override
    public String commandName() {
        return CommandName.INFO_CONTACT.getCommandName();
    }
}
