package entity;

public class SelectedItem extends Item {
    private int quantity;
    private int amount;

    public SelectedItem() {
    }

    public SelectedItem(int id, String name, String description, int price, int quantity, int amount) {
        super(id, name, description, price);
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
