package pro.sky.sheltertelegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.sheltertelegrambot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
