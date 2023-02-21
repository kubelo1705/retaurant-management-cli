package service;

import entity.Bill;
import exception.RestaurantException;

import java.util.List;

public class BillService implements ServiceCore<Bill> {

    @Override
    public void add(Bill object) {

    }

    @Override
    public void update(Bill object) {

    }

    @Override
    public void deleteById(int id) throws RestaurantException {

    }

    @Override
    public void deleteByName(String name) throws RestaurantException {

    }

    @Override
    public Bill findById(int id) {
        return null;
    }

    @Override
    public Bill findByName(String name) throws RestaurantException {
        return null;
    }

    @Override
    public List<Bill> findAll() {
        return null;
    }
}
