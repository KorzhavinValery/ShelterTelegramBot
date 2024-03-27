package pro.sky.sheltertelegrambot.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import pro.sky.sheltertelegrambot.entity.TypeAnimal;
import pro.sky.sheltertelegrambot.entity.User;
import pro.sky.sheltertelegrambot.repository.UserRepository;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * Метод возвращает всех пользователей
     * Используется метод репозитория {@link JpaRepository#findAll()}
     * @return  Получаем список всех пользователей
     * */
    public List<User> getAllUsers() {
        return List.copyOf(userRepository.findAll());
    }

    /**
     * Метод для сохранения User в БД
     */
    public void saveUser(long id, String firstName) {
        userRepository.save(new User(id, firstName));
    }

    /**
     * метод для проверки есть ли User в БД
     */
    public boolean checkUser(long id) {
        return userRepository.existsById(id);
    }

    /**
     * Метод для добавления User типа животного
     */
    public void updateUser(long id, TypeAnimal typeAnimal) {
        User user = userRepository.getById(id);
        user.setTypeAnimal(typeAnimal);
        userRepository.save(user);
    }
}
