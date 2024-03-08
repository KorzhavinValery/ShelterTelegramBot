package pro.sky.sheltertelegrambot.exeption;

public class IncorrectDataException extends RuntimeException{
    public IncorrectDataException(String message) {
        super(message);
    }
}
