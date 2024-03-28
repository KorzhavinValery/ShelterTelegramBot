package pro.sky.sheltertelegrambot.command;

/**
 * Перечень команд
 */
public enum CommandName {
    INFO_SHELTER("/info"),
    INFO_CONTACT("/contact"),
    PASS("/pass"),
    SAFETY("/safety"),
    START("/start"),
    DOG("/dog"),
    CAT("/cat");
    private String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
