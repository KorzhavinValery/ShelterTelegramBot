package pro.sky.sheltertelegrambot.command;

public enum CommandName {
    INFO_SHELTER("/info"),
    INFO_CONTACT("/contact"),
    PASS("/pass"),
    SAFETY("/safety");
    private String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
