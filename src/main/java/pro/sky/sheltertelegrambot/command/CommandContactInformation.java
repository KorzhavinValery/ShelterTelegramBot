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
     * @param id = id User
     * @return = String
     */
    @Override
    public String getSendMessage(long id) {
        AnimalShelter animalShelter = SearchShelterByUser.findByTypeAnimal(id);
        return service.receiveContactInformation(animalShelter.getNameShelter());
    }

    @Override
    public String commandName() {
        return CommandName.INFO_CONTACT.getCommandName();
    }
}
