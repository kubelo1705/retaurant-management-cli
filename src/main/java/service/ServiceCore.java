package service;

import entity.Food;
import exception.RestaurantException;

import java.util.List;

public interface ServiceCore<T> {
    void add(T object) throws RestaurantException;

    void update(T object) throws RestaurantException;

    void deleteById(int id) throws RestaurantException;

    void deleteByName(String name) throws RestaurantException;

    T findById(int id) throws RestaurantException;

    T findByName(String name) throws RestaurantException;

    List<T> findAll() throws RestaurantException;

}
