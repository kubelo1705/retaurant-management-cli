package command.bill;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;

public class BillCommand extends ConcreteCompositeCommand {

    public BillCommand() {
        addSubCommand(new BillAddCommand());
        addSubCommand(new BillEditCommand());
        addSubCommand(new BillShowCommand());
        setName(CommandConstants.BILL);
    }

    @Override
    public void process() {
        //do nothing
    }

}
