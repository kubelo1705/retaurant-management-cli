import entity.Drink;
import exception.RestaurantException;
import service.DrinkService;
import service.ItemService;

public class RestaurantManagement {
    public static void main(String[] args) throws RestaurantException {
        ItemService<Drink> drinkService = new DrinkService();
        drinkService.findAll().forEach(food-> System.out.println(food.getName()));
    }
}

