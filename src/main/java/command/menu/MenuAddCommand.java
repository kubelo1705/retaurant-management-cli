package command.menu;

import constants.CommandConstants;
import entity.Drink;
import entity.Food;
import exception.ApplicationException;
import service.implement.AbstractItemService;
import service.implement.DrinkService;
import service.implement.FoodService;

import java.util.Map;

public class MenuAddCommand extends ModifyMenuCommand {
    public MenuAddCommand() {
        setName(CommandConstants.ADD);
        getRequiredParam().add(CommandConstants.ID_PREFIX);
        getRequiredParam().add(CommandConstants.NAME_PREFIX);
        getRequiredParam().add(CommandConstants.DESCRIPTION_PREFIX);
        getRequiredParam().add(CommandConstants.PRICE_PREFIX);
        getRequiredParam().add(CommandConstants.TYPE_PREFIX);
    }

    @Override
    public void process() {
        try {
            Map<String, String> params = getCommandParams();
            AbstractItemService itemService = getItemService(getOptionCommand());

            String id = params.get(CommandConstants.ID_PREFIX);
            String name = params.get(CommandConstants.NAME_PREFIX);
            String description = params.get(CommandConstants.DESCRIPTION_PREFIX);
            String price = params.get(CommandConstants.PRICE_PREFIX);
            String type = params.get(CommandConstants.TYPE_PREFIX);

            if (id == null || name == null || description == null || price == null || type == null)
                throw new ApplicationException(ApplicationException.Reason.NOT_ENOUGH_PARAM);

            if (itemService instanceof FoodService) {
                Food.FoodType foodType = Food.FoodType.valueOf(type.toUpperCase());
                Food food = new Food(Integer.parseInt(id), name, description, Integer.parseInt(price), foodType);
                itemService.add(food);
            }

            if (itemService instanceof DrinkService) {
                Drink.DrinkType drinkType = Drink.DrinkType.valueOf(type.toUpperCase());
                Drink drink = new Drink(Integer.parseInt(id), name, description, Integer.parseInt(price), drinkType);
                itemService.add(drink);
            }
        } catch (ApplicationException | IllegalArgumentException exception) {
            System.out.println(exception.toString());
        }
    }
}
