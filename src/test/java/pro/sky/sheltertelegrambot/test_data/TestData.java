package pro.sky.sheltertelegrambot.test_data;

import pro.sky.sheltertelegrambot.entity.AnimalShelter;

public class TestData {
    public static final AnimalShelter SHELTER = new AnimalShelter("nameShelter",
            "typeAnimal",
            "generalInformation",
            "contactInformation",
            "orderingAPass",
            "safetyRule");
    public static final String INCORRECT_DATA = "null";
    public static final String EXPECTED_MESSAGE = "Приюта с таким названием нет";
}
