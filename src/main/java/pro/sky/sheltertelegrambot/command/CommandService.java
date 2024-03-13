package pro.sky.sheltertelegrambot.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CommandService {
    private final Map<String, Command> commandMap;

    public CommandService(List<Command> list) {
        this.commandMap = list.stream().collect(Collectors.toMap(Command::commandName, Function.identity()));
    }

    public SendMessage getSendMessage(Update update) {
        return commandMap.get(update.getMessage().getText()).getSendMessage(update);
    }
}
