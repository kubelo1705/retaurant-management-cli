package service;

import entity.Food;
import exception.RestaurantException;
import filehandler.FileHandler;
import filehandler.JsonHandler;
import mapper.ItemMapper;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FoodService implements ServiceCore<Food> {
    private List<Food> cache;
    private FileHandler fileHandler;
    private ItemMapper<Food> mapper;

    public FoodService() {
        cache = new LinkedList<>();
        fileHandler = new JsonHandler(Food.class.getSimpleName());
        mapper = new ItemMapper(Food.class);
    }

    @Override
    public void add(Food object) throws RestaurantException {

    }

    @Override
    public void update(Food object) throws RestaurantException {

    }

    @Override
    public void delete(Food object) throws RestaurantException {

    }

    @Override
    public Food findById(int id) throws RestaurantException {
        return null;
    }

    @Override
    public List<Food> findAll() throws RestaurantException {
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
}
