package by.training.coffee.shop.entity;

import java.util.Objects;

public class OrderItem extends Entity {
    private Long menuItemId;
    private Long receiptId;

    public OrderItem(Long id, Long menuItemId, Long receiptId) {
        super(id);
        this.menuItemId = menuItemId;
        this.receiptId = receiptId;
    }

    public OrderItem(Long menuItemId, Long receiptId) {
        this.menuItemId = menuItemId;
        this.receiptId = receiptId;
    }

    public OrderItem() {
        //empty constructor
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        if (menuItemId != null) {
            this.menuItemId = menuItemId;
        }
    }

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        if (receiptId != null) {
            this.receiptId = receiptId;
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
        return Objects.equals(menuItemId, orderItem.menuItemId)
                && Objects.equals(receiptId, orderItem.receiptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuItemId, receiptId);
    }

    @Override
    public String toString() {
        return "OrderItem: "
                + super.toString()
                + ", menuItemId=" + menuItemId
                + ", receiptId=" + receiptId;
    }
}
