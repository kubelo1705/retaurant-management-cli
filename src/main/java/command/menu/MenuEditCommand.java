package command.menu;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;

public class MenuEditCommand extends ConcreteCompositeCommand {
    public MenuEditCommand() {
        setName(CommandConstants.EDIT);
    }
}
