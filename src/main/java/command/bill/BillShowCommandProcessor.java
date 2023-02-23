package command.bill;

import exception.RestaurantException;

import java.io.OutputStream;

public class BillShowCommandProcessor extends BillCommandProcessor{
    public BillShowCommandProcessor() {
        setName("show");
    }

    @Override
    public void process(String command, OutputStream out) {
        super.process(command, out);
    }

    @Override
    public void validate(String command) throws RestaurantException {
        super.validate(command);
    }
}
