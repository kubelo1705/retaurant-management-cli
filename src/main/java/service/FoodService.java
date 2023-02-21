package service;

import entity.Drink;
import entity.Food;
import filehandler.JsonHandler;
import mapper.ItemMapper;

import java.util.LinkedList;

public class FoodService extends ItemService<Food> {
    public FoodService() {
        super();
        fileHandler=new JsonHandler(Drink.class);
        mapper= new ItemMapper<>(Drink.class);
        cache=new LinkedList<>();
    }
}
