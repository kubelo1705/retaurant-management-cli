package factory;

import command.CommandProcessor;
import command.bill.BillAddCommandProcessor;
import command.bill.BillCommandProcessor;
import command.menu.MenuCommandProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandFactory {
    private List<CommandProcessor> listCommand=new ArrayList<>();

    public CommandFactory(){
        listCommand.add(new BillCommandProcessor());
        listCommand.add(new MenuCommandProcessor());
    }

    public String getCommand(String inputCommand){
        String[] commands=inputCommand.strip().split("\\s+",2);
//        Optional<CommandProcessor> command=listCommand.stream().filter(command -> command.getName());
        return commands[0];
    }

}
