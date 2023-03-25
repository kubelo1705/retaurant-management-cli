package service;

import entity.Bill;
import entity.Item;
import exception.ApplicationException;

public interface BillServiceCore<T> extends ServiceCore<T> {
    Bill createBill() throws ApplicationException;

    void addItemToBill(Bill bill, Item item, int quantity);
}
