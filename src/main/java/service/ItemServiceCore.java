package service;

import exception.ApplicationException;

public interface ItemServiceCore<T> extends ServiceCore<T> {
    void deleteById(int id) throws ApplicationException;

    void deleteByName(String name) throws ApplicationException;

    T findByName(String name) throws ApplicationException;
}
