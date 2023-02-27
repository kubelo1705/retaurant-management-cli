package command.menu;

import constants.CommandConstants;
import exception.ApplicationException;
import service.implement.AbstractItemService;

import java.util.Map;

public class MenuDeleteCommand extends ModifyMenuCommand {
    public MenuDeleteCommand() {
        setName(CommandConstants.DELETE);
        getRequiredParam().add(CommandConstants.ID_PREFIX);
    }

    @Override
    public void process() {
        try {
            Map<String, String> params = preProcess();
            AbstractItemService itemService = getItemService(getOptionCommand());

            String id = params.get(CommandConstants.ID_PREFIX);
            if (id == null)
                throw new ApplicationException(ApplicationException.Reason.NOT_ENOUGH_PARAM);

            itemService.deleteById(Integer.parseInt(id));

        } catch (ApplicationException e) {
            System.out.println(e.toString());
        }

    }
}
