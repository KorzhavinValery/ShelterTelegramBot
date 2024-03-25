package pro.sky.sheltertelegrambot.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Сервис реализующий паттерн команды
 */
@Service
public class CommandService {
    private final Map<String, Command> commandMap;

    /**
     * Конструктор создает Мар из классов команд,
     * ключом является имя команды, а объектом сам класс
     * @param list = лист из всех классов команд
     */
    public CommandService(List<Command> list) {
        this.commandMap = list.stream().collect(Collectors.toMap(Command::commandName, Function.identity()));
    }

    /**
     * Метод ищет в Мар необходимый класс по поступившей от пользователя команде
     * и реализует в найденном классе метод getSendMessage()
     * @param update = команда от пользователя
     * @return = SendMessage
     */
    public SendMessage getSendMessage(Update update) {
        return commandMap.get(update.getMessage().getText()).getSendMessage(update);
    }
}
