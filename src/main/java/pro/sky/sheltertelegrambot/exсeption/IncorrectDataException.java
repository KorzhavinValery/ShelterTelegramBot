package pro.sky.sheltertelegrambot.exсeption;

/**
 * Исключение для обработки в случае неправильных запросов
 */
public class IncorrectDataException extends RuntimeException{
    public IncorrectDataException(String message) {
        super(message);
    }
}
