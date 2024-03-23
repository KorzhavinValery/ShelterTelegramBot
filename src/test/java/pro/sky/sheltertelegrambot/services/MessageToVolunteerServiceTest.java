package pro.sky.sheltertelegrambot.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.sheltertelegrambot.entity.MessageToVolunteer;
import pro.sky.sheltertelegrambot.entity.User;
import pro.sky.sheltertelegrambot.exception.MessageToVolunteerNotFoundException;
import pro.sky.sheltertelegrambot.repository.MessageToVolunteerRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageToVolunteerServiceTest {
    @Mock
    private MessageToVolunteerRepository messageToVolunteerRepository;
    @Mock
    private TelegramBot telegramBot;
    @InjectMocks
    private MessageToVolunteerService messageToVolunteerService;
    private MessageToVolunteer messageToVolunteer;
    private MessageToVolunteer messageToVolunteer1;

    @BeforeEach
    public void beforeEach() {
        User user = new User();
        User user1 = new User();
        messageToVolunteer = new MessageToVolunteer();
        messageToVolunteer1 = new MessageToVolunteer();

        messageToVolunteer.setId(1);
        messageToVolunteer.setUser(user);
        messageToVolunteer.setQuestionTime(LocalDateTime.now());
        messageToVolunteer.setQuestion("Вопрос 1");
        messageToVolunteer.setAnswerTime(null);
        messageToVolunteer.setAnswer(null);

        messageToVolunteer1.setId(2);
        messageToVolunteer1.setUser(user1);
        messageToVolunteer1.setQuestionTime(LocalDateTime.now());
        messageToVolunteer1.setQuestion("Вопрос 2");
        messageToVolunteer1.setAnswerTime(null);
        messageToVolunteer1.setAnswer(null);
    }
    @Test
    public void findAllWithoutAnswerTest() {
        List<MessageToVolunteer> messageToVolunteers = List.of(messageToVolunteer, messageToVolunteer1);
        when(messageToVolunteerRepository.findAllByAnswerIsNull()).thenReturn(messageToVolunteers);
        assertThat(messageToVolunteerService.findAllWithoutAnswer())
                .isNotNull()
                .isNotEmpty()
                .containsExactlyInAnyOrder(messageToVolunteer, messageToVolunteer1);

    }

    @Test
    public void updateAnswerTest() {
        int id = 1;
        String answer = "answer";
        boolean answerToMessage = true;
        when(messageToVolunteerRepository.findById(any())).thenReturn(Optional.of(messageToVolunteer));
        messageToVolunteerService.writeAnswer(id, answer, answerToMessage);
        verify(messageToVolunteerRepository, atLeast(1)).save(messageToVolunteer);

    }

    @Test
    public void updateAnswerNegativeTest() {
        int id = 1;
        String answer = "answer";
        boolean answerToMessage = true;
        when(messageToVolunteerRepository.findById(any())).thenReturn(Optional.empty());
        assertThatExceptionOfType(MessageToVolunteerNotFoundException.class)
                .isThrownBy(() -> messageToVolunteerService.writeAnswer(id, answer, answerToMessage));
        verify(messageToVolunteerRepository, atLeast(0)).save(messageToVolunteer);
    }
}
