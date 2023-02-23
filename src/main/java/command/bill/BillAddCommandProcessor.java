package command.bill;

import exception.RestaurantException;

import java.io.OutputStream;

public class BillAddCommandProcessor extends BillCommandProcessor {

    @Override
    public void process(String command, OutputStream out) {
        return;
    }

    @Override
    public void validate(String command) throws RestaurantException {
        return;
    }
}
