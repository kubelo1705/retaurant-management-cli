package service.implement;

import entity.Bill;
import entity.Item;
import entity.SelectedItem;
import exception.ApplicationException;
import filehandler.FileHandler;
import filehandler.JsonHandler;
import mapper.DefaultMapper;
import service.BillServiceCore;
import utils.WriteFileWorker;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BillService implements BillServiceCore<Bill> {
    private static BillService instance;
    private final FileHandler fileHandler;
    private final DefaultMapper<Bill> mapper;
    private List<Bill> cache;
    private boolean isChanged;

    public BillService() {
        fileHandler = new JsonHandler(Bill.class);
        mapper = new DefaultMapper<>(Bill.class);
        cache = new LinkedList<>();
        new WriteFileWorker<Bill>(this, fileHandler, 300);
    }

    public static BillService getInstance() {
        if (instance == null)
            instance = new BillService();
        return instance;
    }

    @Override
    public void add(Bill object) throws ApplicationException {
        if (object.getTotal() == 0)
            calculateTotal(object);
        cache.add(object);
    }

    @Override
    public void update(Bill object) {
        isChanged = true;
    }

    @Override
    public Bill findById(int id) throws ApplicationException {
        Optional<Bill> result = findAll().stream().filter(item -> item.getId() == id).findFirst();
        if (result.isEmpty())
            throw new ApplicationException(ApplicationException.Reason.BILL_NOT_FOUND, "" + id);
        return result.get();
    }

    @Override
    public List<Bill> findAll() throws ApplicationException {
        if (cache == null || cache.isEmpty()) {
            try {
                List rawData = fileHandler.read();
                cache = mapper.mapToList(rawData);
            } catch (IOException ioException) {
                throw new ApplicationException(ApplicationException.Reason.ERROR_READING_FILE, ioException.getMessage());
            }
        }
        return cache;
    }

    @Override
    public boolean isChange() {
        return isChanged;
    }

    @Override
    public void resetChangeStatus() {
        isChanged = false;
    }

    private void calculateTotal(Bill object) throws ApplicationException {
        int total = object.getItems().stream().mapToInt(Item::getPrice).sum();
        if (total == 0)
            throw new ApplicationException(ApplicationException.Reason.BILL_EMPTY, object.getId() + "");
        object.setTotal(total);
    }

    @Override
    public Bill createBill() throws ApplicationException {
        return new Bill();
    }

    @Override
    public void addItemToBill(Bill bill, Item item, int quantity) {
        bill.getItems().add(new SelectedItem(item, quantity));
    }


}
