package entity;

public class Drink extends Item{
    private boolean isAlcohol;
    private DrinkType type;

    enum DrinkType{
        SOFTDRINK,
        WINE
    }

    public boolean isAlcohol() {
        return isAlcohol;
    }

    public void setAlcohol(boolean alcohol) {
        isAlcohol = alcohol;
    }
}
