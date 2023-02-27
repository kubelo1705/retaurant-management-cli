package command.menu;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;
import exception.ApplicationException;
import service.implement.AbstractItemService;

import java.util.Map;

public class ModifyMenuCommand extends ConcreteCompositeCommand {
    protected AbstractItemService getItemService(String option) throws ApplicationException {
        AbstractItemService itemService = null;
        if (CommandConstants.FOOD.equals(option + " ")) {
            itemService = (AbstractItemService) getFoodService();
        }
        if (CommandConstants.DRINK.equals(option + " ")) {
            itemService = (AbstractItemService) getDrinkService();
        }

        if (itemService == null)
            throw new ApplicationException(ApplicationException.Reason.INVALID_OPTIONS, option);
        return itemService;
    }

    public Map<String, String> preProcess() throws ApplicationException {
        validateCommand(getCommand(), true);
        String option = getOptionCommand();
        return getMapParams(option);
    }
}
