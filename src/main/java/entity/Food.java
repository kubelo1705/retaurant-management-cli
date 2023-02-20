package entity;

public class Food extends Item {
    private FoodType type;

    enum FoodType {
        BREAKFAST,
        LUNCH,
        DINNER,
        FASTFOOD
    }

    public FoodType getType() {
        return type;
    }

    public void setType(FoodType type) {
        this.type = type;
    }
}
