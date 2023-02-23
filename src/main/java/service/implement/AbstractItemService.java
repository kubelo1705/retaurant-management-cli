package service.implement;

import entity.Item;
import exception.RestaurantException;
import filehandler.FileHandler;
import mapper.DefaultMapper;
import service.ItemServiceCore;
import utils.WriteFileWorker;

import java.io.IOException;
import java.util.*;

public abstract class AbstractItemService<T extends Item> implements ItemServiceCore<T> {
    protected List<T> cache;
    protected FileHandler fileHandler;
    protected DefaultMapper<T> mapper;
    protected boolean isChanged;
    protected Timer timer;

    public AbstractItemService(){
        new WriteFileWorker<T>(this,fileHandler,300);
    }

    @Override
    public void add(T object) throws RestaurantException {
        cache.add(object);
        isChanged=true;
    }

    @Override
    public void update(T object) throws RestaurantException {
        deleteByName(object.getName());
        add(object);
        isChanged=true;
    }

    @Override
    public void deleteById(int id) throws RestaurantException {
        removeAndSave(findById(id));
        isChanged=true;
    }

    @Override
    public void deleteByName(String name) throws RestaurantException {
        removeAndSave(findByName(name));
        isChanged=true;
    }

    @Override
    public T findById(int id) throws RestaurantException {
        Optional<T> result = findAll().stream().filter(item -> item.getId() == id).findFirst();
        if (!result.isPresent())
            throw new RestaurantException(RestaurantException.Reason.ITEM_NOT_FOUND, "Can not find item with id=" + id);
        return result.get();
    }

    @Override
    public T findByName(String name) throws RestaurantException {
        Optional<T> result = findAll().stream().filter(item -> item.getName().equals(name)).findFirst();
        if (!result.isPresent())
            throw new RestaurantException(RestaurantException.Reason.ITEM_NOT_FOUND, "Can not find item with name=" + name);
        return result.get();
    }

    @Override
    public List<T> findAll() throws RestaurantException {
        if (cache == null || cache.isEmpty()) {
            try {
                List<Map<String, String>> rawData = fileHandler.read();
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

    private void removeAndSave(T item) throws RestaurantException {
        try {
            cache.remove(item);
            fileHandler.write(cache);
        } catch (IOException ioException) {
            throw new RestaurantException(RestaurantException.Reason.ERROR_WRITING_FILE, ioException.getMessage());
        }
    }

}