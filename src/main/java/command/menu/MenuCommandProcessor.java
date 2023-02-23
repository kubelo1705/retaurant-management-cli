package command.menu;

import command.CommandProcessor;
import command.bill.BillAddCommandProcessor;
import command.bill.BillEditCommandProcessor;
import command.bill.BillShowCommandProcessor;
import exception.RestaurantException;

import java.io.OutputStream;

public class MenuCommandProcessor extends CommandProcessor {
    public MenuCommandProcessor(){
        getSubCommands().add(new MenuAddCommandProcessor());
        getSubCommands().add(new MenuEditCommandProcessor());
        getSubCommands().add(new MenuShowCommandProcessor());
        getSubCommands().add(new MenuDeleteCommandProcessor());
        setName("menu");
    }
    @Override
    public void process(String command, OutputStream out) {

    }

    @Override
    public void validate(String command) throws RestaurantException {

    }
}
