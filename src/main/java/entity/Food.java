package entity;

public class Food extends Item {
    private FoodType type;

    public Food() {
    }

    public Food(int id, String name, String description, int price, FoodType type) {
        super(id, name, description, price);
        this.type = type;
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }

    public enum FoodType {
        BREAKFAST,
        LUNCH,
        DINNER,
        FASTFOOD
    }
}
