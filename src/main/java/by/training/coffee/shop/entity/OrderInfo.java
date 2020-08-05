package by.training.coffee.shop.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderInfo extends Entity {
    private Date date;
    private String userName;
    private List<String> orderItems;
    private BigDecimal finalCost;
    private Long userId;
    private Long orderItemId;
    private Address address;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<String> orderItems) {
        this.orderItems = orderItems;
    }

    public BigDecimal getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(BigDecimal finalCost) {
        this.finalCost = finalCost;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInfo orderInfo = (OrderInfo) o;
        return Objects.equals(date, orderInfo.date) &&
                Objects.equals(userName, orderInfo.userName) &&
                Objects.equals(orderItems, orderInfo.orderItems) &&
                Objects.equals(finalCost, orderInfo.finalCost) &&
                Objects.equals(userId, orderInfo.userId) &&
                Objects.equals(orderItemId, orderInfo.orderItemId) &&
                Objects.equals(address, orderInfo.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, userName, orderItems, finalCost, userId, orderItemId, address);
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "date=" + date +
                ", userName='" + userName + '\'' +
                ", orderItems=" + orderItems +
                ", finalCost=" + finalCost +
                ", userId=" + userId +
                ", orderItemId=" + orderItemId +
                ", address=" + address +
                '}';
    }
}
