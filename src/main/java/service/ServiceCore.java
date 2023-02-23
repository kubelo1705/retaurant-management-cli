package service;

import entity.Food;
import exception.RestaurantException;

import java.util.List;

public interface ServiceCore<T> {
    void add(T object) throws RestaurantException;

    void update(T object) throws RestaurantException;

    T findById(int id) throws RestaurantException;

    List<T> findAll() throws RestaurantException;

    boolean isChange();

    void resetChangeStatus();

}
