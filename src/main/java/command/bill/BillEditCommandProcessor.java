package command.bill;

import exception.RestaurantException;

import java.io.OutputStream;

public class BillEditCommandProcessor extends BillCommandProcessor {
    public BillEditCommandProcessor() {
        setName("edit");
    }

    @Override
    public void validate(String command) throws RestaurantException {
        super.validate(command);
    }

    @Override
    public void process(String command, OutputStream out) {
        super.process(command, out);
    }
}
