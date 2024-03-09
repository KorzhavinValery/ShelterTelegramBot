package pro.sky.sheltertelegrambot.exeption;

/**
 * Исключение для обработки в случае неправильных запросов
 */
public class IncorrectDataException extends RuntimeException{
    public IncorrectDataException(String message) {
        super(message);
    }
}
