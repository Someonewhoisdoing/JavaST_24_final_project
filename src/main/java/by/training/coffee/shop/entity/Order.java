package by.training.coffee.shop.entity;



import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Order extends Entity {
    private String date = LocalDate.now().toString() ;
    private int userId;
    private List<Item> items;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(date, order.date) &&
                Objects.equals(userId, order.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, userId);
    }
}
