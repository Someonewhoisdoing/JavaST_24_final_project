package by.training.coffee.shop.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderInfo extends Entity {
    private Date date;
    private String userName;
    private String addressDelivery;
    private List<String> orderItems;
    private BigDecimal finalCost;
    private Long userId;
    private Long addressId;
    private Long orderItemId;

    public OrderInfo(Long id, Date date, String userName,
                     String addressDelivery, List<String> orderItems,
                     BigDecimal finalCost, Long userId, Long addressId, Long orderItemId) {
        super(id);
        this.date = date;
        this.userName = userName;
        this.addressDelivery = addressDelivery;
        this.orderItems = orderItems;
        this.finalCost = finalCost;
        this.userId = userId;
        this.addressId = addressId;
        this.orderItemId = orderItemId;
    }

    public OrderInfo(Long id, Date date, String userName,
                     String addressDelivery, List<String> orderItems, BigDecimal finalCost) {
        super(id);
        this.date = date;
        this.userName = userName;
        this.addressDelivery = addressDelivery;
        this.orderItems = orderItems;
        this.finalCost = finalCost;
    }

    public OrderInfo(Date date, String userName, String addressDelivery,
                     List<String> orderItems, BigDecimal finalCost) {
        this.date = date;
        this.userName = userName;
        this.addressDelivery = addressDelivery;
        this.orderItems = orderItems;
        this.finalCost = finalCost;
    }

    public OrderInfo() {
        //empty constructor
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if (date != null) {
            this.date = date;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName != null) {
            this.userName = userName;
        }
    }

    public String getAddressDelivery() {
        return addressDelivery;
    }

    public void setAddressDelivery(String addressDelivery) {
        if (addressDelivery != null) {
            this.addressDelivery = addressDelivery;
        }
    }

    public List<String> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<String> orderItems) {
        if (orderItems != null) {
            this.orderItems = orderItems;
        }
    }

    public BigDecimal getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(BigDecimal finalCost) {
        if (finalCost != null) {
            this.finalCost = finalCost;
        }
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        if (userId != null) {
            this.userId = userId;
        }
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        if (addressId != null) {
            this.addressId = addressId;
        }
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        if (orderItemId != null) {
            this.orderItemId = orderItemId;
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
        OrderInfo orderInfo = (OrderInfo) object;
        return Objects.equals(date, orderInfo.date)
                && Objects.equals(userName, orderInfo.userName)
                && Objects.equals(addressDelivery, orderInfo.addressDelivery)
                && Objects.equals(orderItems, orderInfo.orderItems)
                && Objects.equals(finalCost, orderInfo.finalCost)
                && Objects.equals(userId, orderInfo.userId)
                && Objects.equals(addressId, orderInfo.addressId)
                && Objects.equals(orderItemId, orderInfo.orderItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, userName, addressDelivery,
                orderItems, finalCost, userId, addressId, orderItemId);
    }

    @Override
    public String toString() {
        return "OrderInfo: "
                + super.toString()
                + ", date=" + date
                + ", userName=" + userName
                + ", addressDelivery=" + addressDelivery
                + ", orderItems=" + orderItems
                + ", finalCost=" + finalCost
                + ", userId=" + userId
                + ", addressId=" + addressId
                + ", orderItemId=" + orderItemId;
    }
}
