package service.implement;

import entity.Food;
import filehandler.JsonHandler;
import mapper.DefaultMapper;

import java.util.LinkedList;

public class FoodService extends AbstractItemService<Food> {
    private static FoodService instance;

    public FoodService() {
        super();
        fileHandler = new JsonHandler(Food.class);
        mapper = new DefaultMapper<>(Food.class);
        cache = new LinkedList<>();
    }

    public static AbstractItemService<Food> getInstance() {
        if (instance == null)
            instance = new FoodService();
        return instance;
    }
}
