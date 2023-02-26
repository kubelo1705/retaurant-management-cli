package command.menu;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;

public class MenuAddCommand extends ConcreteCompositeCommand {
    public MenuAddCommand() {
        setName(CommandConstants.ADD);
    }
}
