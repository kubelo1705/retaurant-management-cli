package service.implement;

import entity.Bill;
import entity.Item;
import exception.RestaurantException;
import filehandler.FileHandler;
import filehandler.JsonHandler;
import mapper.DefaultMapper;
import service.BillServiceCore;
import utils.WriteFileWorker;

import java.io.IOException;
import java.util.*;

public class BillService implements BillServiceCore<Bill> {
    private List<Bill> cache;
    private  FileHandler fileHandler;
    private DefaultMapper<Bill> mapper;
    private  boolean isChanged;

    public BillService() {
        fileHandler=new JsonHandler(Bill.class);
        mapper= new DefaultMapper<>(Bill.class);
        cache=new LinkedList<>();
        new WriteFileWorker<Bill>(this,fileHandler,300);
    }

    @Override
    public void add(Bill object) throws RestaurantException {
        if(object.getTotal()==0)
            calculateTotal(object);
    }

    @Override
    public void update(Bill object) {

    }

    @Override
    public Bill findById(int id) throws RestaurantException {
        Optional<Bill> result = findAll().stream().filter(item -> item.getId() == id).findFirst();
        if (!result.isPresent())
            throw new RestaurantException(RestaurantException.Reason.BILL_NOT_FOUND, "Can not find item with id=" + id);
        return result.get();
    }

    @Override
    public List<Bill> findAll() throws RestaurantException {
        if (cache == null || cache.isEmpty()) {
            try {
                List rawData = fileHandler.read();
                cache = mapper.mapToList(rawData);
            } catch (IOException ioException) {
                throw new RestaurantException(RestaurantException.Reason.ERROR_READING_FILE, ioException.getMessage());
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
        isChanged=false;
    }

    private void calculateTotal(Bill object) throws RestaurantException {
        int total= object.getItems().stream().mapToInt(Item::getPrice).sum();
        if (total==0)
            throw new RestaurantException(RestaurantException.Reason.BILL_EMPTY,"There is no item in bill.");
        object.setTotal(total);
    }
}
