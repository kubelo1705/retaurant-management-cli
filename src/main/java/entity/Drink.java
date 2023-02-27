package entity;

public class Drink extends Item {
    private DrinkType type;

    public Drink(int id, String name, String description, int price, DrinkType type) {
        super(id, name, description, price);
        this.type = type;
    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }

    public enum DrinkType {
        SOFTDRINK,
        WINE
    }
}
