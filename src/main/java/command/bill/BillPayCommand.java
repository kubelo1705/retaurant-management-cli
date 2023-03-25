package command.bill;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;
import entity.Bill;
import exception.ApplicationException;

public class BillPayCommand extends ConcreteCompositeCommand {
    public BillPayCommand() {
        setName(CommandConstants.PAY);
        getRequiredParam().add(CommandConstants.ID_PREFIX);
    }

    @Override
    public void process() {
        try {
            validateCommand(getCommand(), true);
            int id = Integer.parseInt(getCommandParams().get(CommandConstants.ID_PREFIX));
            Bill bill = getBillService().findById(id);
            if (bill.getStatus() == Bill.BillStatus.PAID) {
                throw new ApplicationException(ApplicationException.Reason.BILL_PAID);
            }
            bill.setStatus(Bill.BillStatus.PAID);
            getBillService().update(bill);
        } catch (ApplicationException exception) {
            System.out.println(exception.toString());
        }
    }
}
