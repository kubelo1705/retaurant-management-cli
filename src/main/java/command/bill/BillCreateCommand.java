package command.bill;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;
import entity.Bill;
import entity.Item;
import exception.ApplicationException;
import service.ItemServiceCore;

import java.util.regex.Pattern;

public class BillCreateCommand extends ConcreteCompositeCommand {
    private static final String FOOD = "food";
    private static final String DRINK = "drink";
    private static final Pattern ID_PARAM_NAME = Pattern.compile(CommandConstants.ID_PREFIX + EQUAL + "\\d+$");
    private static final Pattern QUANTITY_PARAM_NAME = Pattern.compile(CommandConstants.QUANTITY_PREFIX + EQUAL + "\\d+$");

    public BillCreateCommand() {
        setName(CommandConstants.CREATE);
        getRequiredParam().add(CommandConstants.ID_PREFIX);
        getRequiredParam().add(CommandConstants.QUANTITY_PREFIX);
    }

    @Override
    public void process() {
        try {
            Bill bill = getBillService().createBill();

            String options = getOptionCommand();
            while (options.length() != 0) {
                String option = options.substring(0, options.indexOf("\\b"));
                options = options.replace(option, "").trim();

                String idString = options.substring(0, options.indexOf("\\b"));
                if (!ID_PARAM_NAME.matcher(idString).matches())
                    throw new ApplicationException(ApplicationException.Reason.INVALID_PARAMS, idString);
                options = options.replace(idString, "").trim();
                int id = Integer.parseInt(idString.split(EQUAL)[1]);

                String quantityString = options.substring(0, options.indexOf("\\b"));
                if (!QUANTITY_PARAM_NAME.matcher(idString).matches())
                    throw new ApplicationException(ApplicationException.Reason.INVALID_PARAMS, quantityString);
                options = options.replace(option, "").trim();
                int quantity = Integer.parseInt(quantityString.split(EQUAL)[1]);

                ItemServiceCore itemServiceCore = getServiceByOption(option);
                Item item = (Item) itemServiceCore.findById(id);

                getBillService().addItemToBill(bill, item, quantity);
            }
            if (bill.getItems().isEmpty())
                throw new ApplicationException(ApplicationException.Reason.NOT_ENOUGH_PARAM);
            getBillService().add(bill);
        } catch (ApplicationException exception) {
            System.out.println(exception.toString());
        }
    }

    private ItemServiceCore getServiceByOption(String option) {
        return option.equalsIgnoreCase(FOOD) ? getFoodService() : getDrinkService();
    }
}
