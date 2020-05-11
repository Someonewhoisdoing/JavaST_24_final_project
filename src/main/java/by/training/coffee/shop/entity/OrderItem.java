package by.training.coffee.shop.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderItem extends Entity {
    private String name;
    private BigDecimal price;
    private Long menuItemId;

    public OrderItem(Long id, String name, BigDecimal price, Long menuItemId) {
        super(id);
        this.name = name;
        this.price = price;
        this.menuItemId = menuItemId;
    }

    public OrderItem(String name, BigDecimal price, Long menuItemId) {
        this.name = name;
        this.price = price;
        this.menuItemId = menuItemId;
    }

    public OrderItem() {
        //empty constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price != null) {
            this.price = price;
        }
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        if (menuItemId != null) {
            this.menuItemId = menuItemId;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        OrderItem orderItem = (OrderItem) object;
        return Objects.equals(name, orderItem.name)
                && Objects.equals(price, orderItem.price)
                && Objects.equals(menuItemId, orderItem.menuItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, menuItemId);
    }

    @Override
    public String toString() {
        return "OrderItem: "
                + super.toString()
                + ", name=" + name
                + ", price=" + price
                + ", menuItemId=" + menuItemId;
    }
}
