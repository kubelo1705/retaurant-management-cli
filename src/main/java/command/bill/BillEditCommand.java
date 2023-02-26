package command.bill;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;
import exception.ApplicationException;

public class BillEditCommand extends ConcreteCompositeCommand {
    public BillEditCommand() {
        setName(CommandConstants.EDIT);
    }

    @Override
    public void validateCommand(String command, boolean isNeedParam) throws ApplicationException {
        super.validateCommand(command, isNeedParam);
    }

    @Override
    public void process() {
        super.process();
    }
}
