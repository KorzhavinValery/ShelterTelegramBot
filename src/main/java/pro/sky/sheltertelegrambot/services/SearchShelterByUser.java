package pro.sky.sheltertelegrambot.services;

import pro.sky.sheltertelegrambot.entity.AnimalShelter;
import pro.sky.sheltertelegrambot.repository.AnimalShelterRepository;

public class SearchShelterByUser {
    private static AnimalShelterRepository shelterRepository;
    UserRepository repository;

    public static AnimalShelter findByTypeAnimal(long id) {
        User user = repository.findById(id);
        return shelterRepository.findByTypeAnimal(user.getTaypeAnimal);
    }
}
