package command.bill;

import command.CommandProcessor;
import exception.RestaurantException;

import java.io.OutputStream;
import java.util.TreeSet;

public class BillCommandProcessor extends CommandProcessor {

    public BillCommandProcessor(){
        addSubCommand(new BillAddCommandProcessor());
        addSubCommand(new BillEditCommandProcessor());
        addSubCommand(new BillShowCommandProcessor());
        setName("bill");
    }

    @Override
    public void process(String command, OutputStream out) {
        //do nothing
    }

    @Override
    public void validate(String command) throws RestaurantException {
        //do nothing
    }

    private void addSubCommand(CommandProcessor subCommand){
        if(!getSubCommands().contains(subCommand))
            getSubCommands().add(subCommand);
    }
}
