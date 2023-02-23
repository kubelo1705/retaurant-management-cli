package command;

import exception.RestaurantException;

import java.io.OutputStream;
import java.util.TreeSet;

public abstract class CommandProcessor {
    private TreeSet<CommandProcessor> subCommands= new TreeSet<>();
    protected String name="";

    public abstract void process(String command, OutputStream out);

    public abstract void validate(String command) throws RestaurantException;

    public String getName(){
        return name;
    };

    public void setName(String name){
        this.name=name;
    }

    public TreeSet<CommandProcessor> getSubCommands() {
        return subCommands;
    }
}
