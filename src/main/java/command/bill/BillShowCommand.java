package command.bill;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;

public class BillShowCommand extends ConcreteCompositeCommand {
    public BillShowCommand() {
        setName(CommandConstants.SHOW);
    }

    @Override
    public void process() {
        super.process();
    }
}
