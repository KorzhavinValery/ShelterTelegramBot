package pro.sky.sheltertelegrambot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MessageToVolunteerNotFoundException extends RuntimeException {
    private final int id;
    public MessageToVolunteerNotFoundException(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Сообщений волантеру с ID: " + id + " не найдено!";
    }
}
