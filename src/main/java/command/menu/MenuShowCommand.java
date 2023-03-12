package command.menu;

import command.ConcreteCompositeCommand;
import constants.CommandConstants;
import entity.Drink;
import entity.Food;
import exception.ApplicationException;

import java.util.List;

public class MenuShowCommand extends ConcreteCompositeCommand {
    public static final String FORMAT_MENU = "%-5s %-21s %-21s %-15s %-15s%n";

    public MenuShowCommand() {
        setName(CommandConstants.SHOW);
    }

    @Override
    public void process() {
        try {
            validateCommand(getCommand(), false);
            String option = getOptionCommand();

            switch (option) {
                case CommandConstants.ALL:
                    showAll();
                    break;
                case CommandConstants.FOOD:
                    showFood();
                    break;
                case CommandConstants.DRINK:
                    showDrink();
                    break;
                default:
                    throw new ApplicationException(ApplicationException.Reason.INVALID_OPTIONS, option);
            }
        } catch (ApplicationException exception) {
            System.out.println(exception.toString());
        }
    }

    private void showAll() {
        showFood();
        showDrink();
    }

    private void showFood() {
        try {
            List<Food> listFood = getFoodService().findAll();
            System.out.println("=================FOOD=================");
            System.out.printf(FORMAT_MENU, "id", "name", "description", "price", "type");
            listFood.forEach(this::printFood);
        } catch (ApplicationException exception) {
            System.out.println(exception);
        }
    }

    private void showDrink() {
        try {
            List<Drink> listDrink = getDrinkService().findAll();
            System.out.println("=================DRINK=================");
            System.out.printf(FORMAT_MENU, "id", "name", "description", "price", "type");
            listDrink.forEach(this::printDrink);
        } catch (ApplicationException exception) {
            System.out.println(exception);
        }
    }

    private void printFood(Food food) {
        System.out.printf(FORMAT_MENU, food.getId(), food.getName(), food.getDescription(), food.getPrice(), food.getType());
    }

    private void printDrink(Drink drink) {
        System.out.printf(FORMAT_MENU, drink.getId(), drink.getName(), drink.getDescription(), drink.getPrice(), drink.getType());
    }
}
