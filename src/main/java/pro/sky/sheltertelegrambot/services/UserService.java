package pro.sky.sheltertelegrambot.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
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
}
