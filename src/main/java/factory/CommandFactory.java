package factory;

import command.CompositeCommand;
import command.bill.BillCommand;
import command.menu.MenuCommand;
import exception.ApplicationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandFactory {
    private List<CompositeCommand> listCommand = new ArrayList<>();

    public CommandFactory() {
        listCommand.add(new BillCommand());
        listCommand.add(new MenuCommand());
    }

    public CompositeCommand getCommand(String inputCommand) throws ApplicationException {
        CompositeCommand command = findCommand(listCommand, format(inputCommand), null);
        if (command == null)
            throw new ApplicationException(ApplicationException.Reason.COMMAND_NOT_FOUND, "Not found command \"" + inputCommand + "\"");
        command.setCommand(format(inputCommand));
        return command;
    }

    private CompositeCommand findCommand(List<CompositeCommand> subCommands, String commandString, CompositeCommand returnCommand) {
        if (subCommands.isEmpty())
            return returnCommand;

        String[] partsOfCommand = commandString.split(" ", 2);
        String command = commandString.split(" ", 2)[0];
        String params = partsOfCommand.length == 2 ? partsOfCommand[1] : null;

        Optional<CompositeCommand> commandOptional = subCommands.stream().filter(compositeCommand -> compositeCommand.getName().equals(command)).findFirst();
        if (commandOptional.isPresent() && params != null) {
            return findCommand(commandOptional.get().getSubCommands(), params, commandOptional.get());
        }

        return returnCommand;
    }

    public String format(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }
}
