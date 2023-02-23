package service;

import exception.RestaurantException;

public interface ItemServiceCore<T> extends ServiceCore<T> {
    void deleteById(int id) throws RestaurantException;

    void deleteByName(String name) throws RestaurantException;

    T findByName(String name) throws RestaurantException;
}
