package pro.sky.sheltertelegrambot.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import pro.sky.sheltertelegrambot.entity.AnimalShelter;
import pro.sky.sheltertelegrambot.services.SearchShelterByUser;
import pro.sky.sheltertelegrambot.services.ShelterService;

/**
 * Класс выполняет команду по выводу информации для оформления пропуска на территорию приюта
 */
@Component
public class CommandOrderingAPass implements Command{
    ShelterService service;

    /**
     * Метод выводит информацию для оформления пропуска на территорию приюта
     * @param id = id User
     * @return = String
     */
    @Override
    public String getSendMessage(long id, String firstName) {
        AnimalShelter animalShelter = SearchShelterByUser.findByTypeAnimal(id);
        return service.receiveOrderingAPass(animalShelter.getNameShelter());
    }

    @Override
    public String commandName() {
        return CommandName.PASS.getCommandName();
    }
}
