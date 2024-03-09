package pro.sky.sheltertelegrambot.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pro.sky.sheltertelegrambot.entity.AnimalShelter;
import pro.sky.sheltertelegrambot.exeption.IncorrectDataException;
import pro.sky.sheltertelegrambot.repository.AnimalShelterRepository;

/**
 * Класс имплеметируется от ShelterService
 */

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShelterServiceImpl implements ShelterService {
    private AnimalShelterRepository repository;
    private AnimalShelter animalShelter;
    private final Logger LOGGER = LoggerFactory.getLogger(ShelterServiceImpl.class);

    /**
     * метод возвращает String с информацией о приюте
     *
     * @param name - наименование приюта
     */
    @Override
    public String receiveGeneralInformation(String name) {
        try {
            return receiveAnimalShelterByName(name).getGeneralInformation();
        } catch (IncorrectDataException e) {
            return e.getMessage();
        }
    }

    /**
     * метод возвращает String с контактными данными приюта
     *
     * @param name - наименование приюта
     */
    @Override
    public String receiveContactInformation(String name) {
        try {
            return receiveAnimalShelterByName(name).getContactInformation();
        } catch (IncorrectDataException e) {
            return e.getMessage();
        }
    }

    /**
     * метод возвращает String с данными охраны для оформления пропуска на машину
     *
     * @param name - наименование приюта
     */
    @Override
    public String receiveOrderingAPass(String name) {
        try {
            return receiveAnimalShelterByName(name).getOrderingAPass();
        } catch (IncorrectDataException e) {
            return e.getMessage();
        }
    }

    /**
     * метод возвращает String с общими рекомендациями о технике безопасности на территории приюта.
     *
     * @param name - наименование приюта
     */
    @Override
    public String receiveSafetyRules(String name) {
        try {
            return receiveAnimalShelterByName(name).getSafetyRules();
        } catch (IncorrectDataException e) {
            return e.getMessage();
        }
    }

    /**
     * метод возвращает экземпляр AnimalShelter по наименованию
     *
     * @param name - наименование приюта
     * @throws IncorrectDataException - если нет приюта с этим названием кидает ошибку
     */
    private AnimalShelter receiveAnimalShelterByName(String name) throws IncorrectDataException{
        return repository.findById(name).orElseThrow(() -> {
            LOGGER.error("Ошибка IncorrectDataException нет приюта под названием ={}", name);
            return new IncorrectDataException("Приюта с таким названием нет");
        });
    }
}
