package command.bill;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;
import entity.Bill;
import exception.ApplicationException;
import service.implement.DrinkService;
import service.implement.FoodService;

public class BillCreateCommand extends ConcreteCompositeCommand {
    private static final String FOOD = "food";
    private static final String DRINK = "drink";

    public BillCreateCommand() {
        setName(CommandConstants.CREATE);
        getRequiredParam().add(CommandConstants.ID_PREFIX);
        getRequiredParam().add(CommandConstants.QUANTITY_PREFIX);
    }

    @Override
    public void process() {
        try {
            Bill bill = new Bill();
            FoodService foodService = (FoodService) getFoodService();
            DrinkService drinkService = (DrinkService) getDrinkService();
            String options = getOptionCommand();
            while (!options.isBlank()) {
                String option = options.substring(0, options.indexOf(SPACE));
                options = options.replace(option, "").trim();
                if (!option.equals(FOOD) && !option.equals(DRINK))
                    throw new ApplicationException(ApplicationException.Reason.INVALID_OPTIONS, option);
                String param1 = options.substring(0, options.indexOf(SPACE));
                options = options.replace(param1, "").trim();
                String param2 = options.substring(0, options.indexOf(SPACE));
            }

        } catch (ApplicationException exception) {
            System.out.println(exception.toString());
        }
    }
}
