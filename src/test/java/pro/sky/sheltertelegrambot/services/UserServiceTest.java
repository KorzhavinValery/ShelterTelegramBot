package pro.sky.sheltertelegrambot.services;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.sheltertelegrambot.entity.User;
import pro.sky.sheltertelegrambot.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    void getWaitingListTest() {
        User user = new User();
        List<User> users = new ArrayList<>(Collections.singletonList(user));
        when(userRepository.findAll()).thenReturn(users);
        assertThat(userService.getAllUsers()).isEqualTo(users);
        verify(userRepository, times(1)).findAll();


    }
}
