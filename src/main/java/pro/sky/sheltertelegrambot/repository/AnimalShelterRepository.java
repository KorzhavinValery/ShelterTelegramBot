package pro.sky.sheltertelegrambot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pro.sky.sheltertelegrambot.entity.AnimalShelter;

@Repository
public interface AnimalShelterRepository extends CrudRepository<AnimalShelter, String>, PagingAndSortingRepository<AnimalShelter, String> {

}
