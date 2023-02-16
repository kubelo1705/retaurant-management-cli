package entity;

public class Drink extends Item{
    private boolean isAlcohol;

    public boolean isAlcohol() {
        return isAlcohol;
    }

    public void setAlcohol(boolean alcohol) {
        isAlcohol = alcohol;
    }
}
