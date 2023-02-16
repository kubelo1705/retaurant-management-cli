package command;

import exception.RestaurantException;

import java.io.OutputStream;
import java.util.TreeSet;

public abstract class CommandProcessor {
    private TreeSet<CommandProcessor> subCommands=new TreeSet<>();

    public abstract void process(String command, OutputStream out);
    public abstract void validate(String command) throws RestaurantException;
}
