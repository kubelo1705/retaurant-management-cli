package entity;

import java.util.Date;
import java.util.List;

public class Bill {
    private int id;
    private int total;
    private Date date;
    private List<Item> items;
    private BillStatus billStatus;

    enum BillStatus{
        PAID,
        UN_PAID
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
