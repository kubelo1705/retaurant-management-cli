package command.menu;

import constants.CommandConstants;
import entity.Item;
import exception.ApplicationException;
import service.implement.AbstractItemService;

import java.util.Map;

public class MenuEditCommand extends ModifyMenuCommand {
    public MenuEditCommand() {
        setName(CommandConstants.EDIT);
        getRequiredParam().add(CommandConstants.ID_PREFIX);
        getRequiredParam().add(CommandConstants.PRICE_PREFIX);
    }

    @Override
    public void process() {
        try {
            Map<String, String> params = getCommandParams();
            AbstractItemService itemService = getItemService(getOptionCommand());

            String id = params.get(CommandConstants.ID_PREFIX);
            String price = params.get(CommandConstants.PRICE_PREFIX);
            if (id == null || price == null)
                throw new ApplicationException(ApplicationException.Reason.NOT_ENOUGH_PARAM);

            Item item = itemService.findById(Integer.parseInt(id));
            item.setPrice(Integer.parseInt(price));
            itemService.update(item);

        } catch (ApplicationException exception) {
            System.out.println(exception.toString());
        }
    }
}
