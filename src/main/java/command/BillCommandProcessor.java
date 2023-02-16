package command;

import exception.RestaurantException;

import java.io.OutputStream;

public class BillCommandProcessor extends CommandProcessor{
    @Override
    public void process(String command, OutputStream out) {

    }

    @Override
    public void validate(String command) throws RestaurantException {

    }
}
