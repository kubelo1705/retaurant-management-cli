package command;

import exception.ApplicationException;

import java.util.List;

public interface CompositeCommand {
    String getName();

    void setName(String name);

    List<CompositeCommand> getSubCommands();

    void addSubCommand(CompositeCommand subCommand);

    void process();

    void validateCommand(String command, boolean isNeedParam) throws ApplicationException;

    String getCommand();

    void setCommand(String command);
}
