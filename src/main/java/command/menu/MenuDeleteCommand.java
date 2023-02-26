package command.menu;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;

public class MenuDeleteCommand extends ConcreteCompositeCommand {
    public MenuDeleteCommand() {
        setName(CommandConstants.DELETE);
    }
}
