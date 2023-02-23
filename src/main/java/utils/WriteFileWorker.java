package utils;

import filehandler.FileHandler;
import service.ServiceCore;

import java.util.Timer;
import java.util.TimerTask;

public class WriteFileWorker<T> extends TimerTask {
    private final FileHandler fileHandler;
    private final ServiceCore serviceCore;

    public WriteFileWorker(ServiceCore serviceCore, FileHandler fileHandler, int period) {
        this.serviceCore = serviceCore;
        this.fileHandler = fileHandler;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(this, 0, period);
    }

    @Override
    public void run() {
        try {
            if (serviceCore.isChange()) {
                fileHandler.write(serviceCore.findAll());
            }
            serviceCore.resetChangeStatus();
        } catch (Exception e) {
            // ignore, will write file at the next time
        }
    }
}