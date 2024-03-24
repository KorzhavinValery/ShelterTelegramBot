package pro.sky.sheltertelegrambot.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import pro.sky.sheltertelegrambot.entity.MessageToVolunteer;
import pro.sky.sheltertelegrambot.exception.MessageToVolunteerNotFoundException;
import pro.sky.sheltertelegrambot.exception.TelegramException;
import pro.sky.sheltertelegrambot.repository.MessageToVolunteerRepository;
import pro.sky.sheltertelegrambot.entity.User;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageToVolunteerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageToVolunteerService.class);

    private final TelegramBot telegramBot;
    private final MessageToVolunteerRepository messageToVolunteerRepository;

    public MessageToVolunteerService(TelegramBot telegramBot, MessageToVolunteerRepository messageToVolunteerRepository) {
        this.telegramBot = telegramBot;
        this.messageToVolunteerRepository = messageToVolunteerRepository;
    }
    /**
     * Получает список всех объектов MessageToVolunteer из БД, где
     * поле answer равно null.
     *
     * @return список объектов MessageToVolunteer.
     */
    public List<MessageToVolunteer> findAllWithoutAnswer() {
        return List.copyOf(messageToVolunteerRepository.findAllByAnswerIsNull());
    }
    /**
     *  Cоздает запись в БД в таблице "message_to_volunteer".<br>
     *  Используется метод репозитория {@link JpaRepository#save(Object)}
     *  @param messageId идентификатор сообщения, чтобы у волонтера была возможность
     *                   послать ответ на строго определенное сообщение
     *  @param user пользователь
     *  @param question вопрос к волонтеру
     * */
    public void createMessageToVolunteer(int messageId, User user, String question) {
        MessageToVolunteer messageToVolunteer = new MessageToVolunteer();
        messageToVolunteer.setId(messageId);
        messageToVolunteer.setUser(user);
        messageToVolunteer.setQuestionTime(LocalDateTime.now());
        messageToVolunteer.setQuestion(question);
        messageToVolunteerRepository.save(messageToVolunteer);
    }
    /**
     * Находит по id нужный объект MessageToVolunteer в БД,
     * присваивает строку полю answer и заполняет поле answerTime.
     *
     * @param id идентификатор объекта MessageToVolunteer.
     * @param answer строка с ответом.
     * @param answerToMessage если True, то уйдет сообщение с включенным в ответ вопросом
     * @throws MessageToVolunteerNotFoundException если объект не найден.
     */
    // запись ответа
    public void writeAnswer(int id, String answer, boolean answerToMessage) {
        MessageToVolunteer messageToVolunteer = messageToVolunteerRepository.findById(id)
                .orElseThrow(() -> new MessageToVolunteerNotFoundException(id));
        messageToVolunteer.setAnswerTime(LocalDateTime.now());
        messageToVolunteer.setAnswer(answer);
        try {
            telegramBot.sendMessageToUser(messageToVolunteer.getUser(), answer, answerToMessage ? id : 0);
        } catch (TelegramApiException e) {
            LOGGER.error("Ошибка при отправке ответа волонтера " + e.getMessage());
            throw new TelegramException();// в отличие от TelegramApiException: TelegramException - это RunTimeException

        }
        messageToVolunteerRepository.save(messageToVolunteer);
    }
}
