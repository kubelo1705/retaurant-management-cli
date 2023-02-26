package service.implement;

import entity.Drink;
import filehandler.JsonHandler;
import mapper.DefaultMapper;

import java.util.LinkedList;

public class DrinkService extends AbstractItemService<Drink> {
    private static DrinkService instance;

    public DrinkService() {
        super();
        fileHandler = new JsonHandler(Drink.class);
        mapper = new DefaultMapper<>(Drink.class);
        cache = new LinkedList<>();
    }

    public static AbstractItemService<Drink> getInstance() {
        if (instance == null)
            instance = new DrinkService();
        return instance;
    }
}
