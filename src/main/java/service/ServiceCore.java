package service;

import entity.Bill;

import java.util.List;

public interface ServiceCore<T> {
    void add(T object);
    void update(T object);
    void delete(T object);
    T findById(int id);
    List<T> findAllBill();
}
