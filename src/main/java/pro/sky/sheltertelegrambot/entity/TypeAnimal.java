package pro.sky.sheltertelegrambot.entity;

/**
 * Класс с перечеслением типов животных содержащихся в приюте
 */
public enum TypeAnimal {
    CAT ("cat"),
    DOG("dog");
    private String typeAnimal;

    TypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }
}
