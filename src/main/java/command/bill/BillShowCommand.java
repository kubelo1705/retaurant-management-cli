package command.bill;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;
import entity.Bill;
import exception.ApplicationException;

public class BillShowCommand extends ConcreteCompositeCommand {
    public static final String FORMAT_BILL_DETAIL = "%-5s %-20s %-10s %-15s %-15s%n";
    public static final String FORMAT_BILL = "%-4s %-15s %-20s %-10s%n";

    public BillShowCommand() {
        setName(CommandConstants.SHOW);
        getRequiredParam().add(CommandConstants.ID_PREFIX);
    }

    @Override
    public void process() {
        try {
            String option = getOptionCommand();
            if (option.equals(CommandConstants.ALL)) {
                showAllBill();
            } else if (option.contains(CommandConstants.DETAILS)) {
                int id = Integer.parseInt(getCommandParams(option).get(CommandConstants.ID_PREFIX));
                Bill bill = getBillService().findById(id);
                showBillDetail(bill);
            }

        } catch (ApplicationException exception) {
            System.out.println(exception.toString());
        }
    }

    private void showAllBill() throws ApplicationException {
        System.out.println("=================FOOD=================");
        System.out.printf(FORMAT_BILL, "id", "total", "date", "status");
        getBillService().findAll().forEach(bill -> System.out.printf(FORMAT_BILL, bill.getId(), bill.getTotal(), bill.getDate(), bill.getStatus()));
    }

    private void showBillDetail(Bill bill) throws ApplicationException {
        System.out.println("=================FOOD=================");
        System.out.printf(FORMAT_BILL_DETAIL, "id", "name", "quantity", "price", "amount");
        bill.getItems().forEach((o) -> {
            System.out.printf(FORMAT_BILL_DETAIL, o.getId(), o.getName(), o.getQuantity(), o.getPrice(), o.getAmount());
        });
        System.out.println("TOTAL:" + bill.getTotal());
    }
}
