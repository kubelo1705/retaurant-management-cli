package entity;

public class Drink extends Item{
    private DrinkType type;

    enum DrinkType{
        SOFTDRINK,
        WINE
    }

    public DrinkType getType() {
        return type;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }
}
