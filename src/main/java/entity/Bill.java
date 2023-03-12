package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Bill {
    private int id;
    private int total;
    private String date;
    private List<SelectedItem> items;
    private BillStatus status;

    public Bill() {
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        this.items = new LinkedList<>();
        this.status = BillStatus.UNPAID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<SelectedItem> getItems() {
        return items;
    }

    public void setItems(List<SelectedItem> items) {
        this.items = items;
    }

    public enum BillStatus {
        PAID,
        UNPAID
    }
}
