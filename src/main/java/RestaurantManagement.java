import exception.ApplicationException;
import factory.CommandFactory;

import java.util.Scanner;

public class RestaurantManagement {
    public static void main(String[] args) throws ApplicationException {
        Scanner scanner = new Scanner(System.in);
        CommandFactory commandFactory = new CommandFactory();
        while (true) {
            System.out.print("restaurant-cli>  ");
            String command = scanner.nextLine();
            commandFactory.getCommand(command).process();
        }
    }
}

