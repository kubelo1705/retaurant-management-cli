package service.implement;

import entity.Item;
import exception.ApplicationException;
import filehandler.FileHandler;
import mapper.DefaultMapper;
import service.ItemServiceCore;
import utils.WriteFileWorker;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Timer;

public abstract class AbstractItemService<T extends Item> implements ItemServiceCore<T> {
    protected List<T> cache;
    protected FileHandler fileHandler;
    protected DefaultMapper<T> mapper;
    protected boolean isChanged;
    protected Timer timer;

    public AbstractItemService() {
        new WriteFileWorker<T>(this, fileHandler, 300);
    }

    @Override
    public void add(T object) throws ApplicationException {
        cache.add(object);
        isChanged = true;
    }

    @Override
    public void update(T object) throws ApplicationException {
        deleteByName(object.getName());
        add(object);
        isChanged = true;
    }

    @Override
    public void deleteById(int id) throws ApplicationException {
        removeAndSave(findById(id));
        isChanged = true;
    }

    @Override
    public void deleteByName(String name) throws ApplicationException {
        removeAndSave(findByName(name));
        isChanged = true;
    }

    @Override
    public T findById(int id) throws ApplicationException {
        Optional<T> result = findAll().stream().filter(item -> item.getId() == id).findFirst();
        if (!result.isPresent())
            throw new ApplicationException(ApplicationException.Reason.FOOD_NOT_FOUND, id + "");
        return result.get();
    }

    @Override
    public T findByName(String name) throws ApplicationException {
        Optional<T> result = findAll().stream().filter(item -> item.getName().equals(name)).findFirst();
        if (!result.isPresent())
            throw new ApplicationException(ApplicationException.Reason.FOOD_NOT_FOUND, name);
        return result.get();
    }

    @Override
    public List<T> findAll() throws ApplicationException {
        if (cache == null || cache.isEmpty()) {
            try {
                List<Map<String, String>> rawData = fileHandler.read();
                cache = mapper.mapToList(rawData);
            } catch (IOException ioException) {
                throw new ApplicationException(ApplicationException.Reason.ERROR_READING_FILE, ioException.getMessage());
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
        isChanged = false;
    }

    private void removeAndSave(T item) throws ApplicationException {
        try {
            cache.remove(item);
            fileHandler.write(cache);
        } catch (IOException ioException) {
            throw new ApplicationException(ApplicationException.Reason.ERROR_WRITING_FILE, ioException.getMessage());
        }
    }

}
