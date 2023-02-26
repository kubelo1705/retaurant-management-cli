package command.bill;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;

public class BillAddCommand extends ConcreteCompositeCommand {
    public BillAddCommand() {
        setName(CommandConstants.ADD);
    }

    @Override
    public void process() {
        return;
    }
}
