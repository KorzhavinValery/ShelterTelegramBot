package pro.sky.sheltertelegrambot.services;

/**
 * Сервис для работы с данными о приюте в репозитории
 */
public interface ShelterService {
    /**
     * метод возвращает String с информацией о приюте
     */
    String receiveGeneralInformation(String name);

    /**
     * метод возвращает String с контактными данными приюта
     */
    String receiveContactInformation(String name);

    /**
     * метод возвращает String с данными охраны для оформления пропуска на машину
     */
    String receiveOrderingAPass(String name);

    /**
     * метод возвращает String с общими рекомендациями о технике безопасности на территории приюта.
     */
    String receiveSafetyRules(String name);
}
