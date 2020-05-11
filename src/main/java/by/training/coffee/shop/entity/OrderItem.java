package by.training.coffee.shop.entity;

import java.util.List;
import java.util.Objects;

public class OrderItem extends Entity {
    private Long menuItemId;
    private List<MenuItem> menuItemList;

    public OrderItem(Long id, Long menuItemId, List<MenuItem> menuItemList) {
        super(id);
        this.menuItemId = menuItemId;
        this.menuItemList = menuItemList;
    }

    public OrderItem(Long menuItemId, List<MenuItem> menuItemList) {
        this.menuItemId = menuItemId;
        this.menuItemList = menuItemList;
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

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        if (menuItemList != null) {
            this.menuItemList = menuItemList;
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
        return Objects.equals(menuItemId, orderItem.menuItemId) &&
                Objects.equals(menuItemList, orderItem.menuItemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuItemId, menuItemList);
    }

    @Override
    public String toString() {
        return "OrderItem: "
                + super.toString()
                + ", menuItemId=" + menuItemId
                + ", menuItemList=" + menuItemList;
    }
}
