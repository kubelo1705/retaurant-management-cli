import entity.Drink;
import exception.RestaurantException;
import factory.CommandFactory;
import service.implement.DrinkService;
import service.implement.AbstractItemService;

import java.util.Scanner;

public class RestaurantManagement {
    public static void main(String[] args) throws RestaurantException {
        Scanner scanner=new Scanner(System.in);
        CommandFactory commandFactory=new CommandFactory();
        System.out.println(commandFactory.getCommand(scanner.nextLine()));
    }
}

