package command.menu;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;

public class MenuCommand extends ConcreteCompositeCommand {
    public MenuCommand() {
        getSubCommands().add(new MenuAddCommand());
        getSubCommands().add(new MenuEditCommand());
        getSubCommands().add(new MenuShowCommand());
        getSubCommands().add(new MenuDeleteCommand());
        setName(CommandConstants.MENU);
    }

    @Override
    public void process() {

    }
}
