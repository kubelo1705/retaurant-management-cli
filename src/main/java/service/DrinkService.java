package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Drink;
import entity.Food;
import filehandler.JsonHandler;
import mapper.ItemMapper;

import java.util.LinkedList;

public class DrinkService extends ItemService<Drink>{
    public DrinkService() {
        super();
        fileHandler=new JsonHandler(Drink.class);
        mapper= new ItemMapper<>(Drink.class);
        cache=new LinkedList<>();
    }
}
