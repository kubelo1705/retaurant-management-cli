package service;

import exception.ApplicationException;

import java.util.List;

public interface ServiceCore<T> {
    void add(T object) throws ApplicationException;

    void update(T object) throws ApplicationException;

    T findById(int id) throws ApplicationException;

    List<T> findAll() throws ApplicationException;

    boolean isChange();

    void resetChangeStatus();

}
