package pro.sky.sheltertelegrambot.entity;

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
