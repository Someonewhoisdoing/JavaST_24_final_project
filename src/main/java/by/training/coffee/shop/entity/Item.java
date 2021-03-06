package by.training.coffee.shop.entity;

import java.util.Objects;

public class Item extends Entity {
    private String name;
    private int orderId;
    private double cost;
    private double weight;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){ return true;}
        if (object == null || getClass() != object.getClass()) {return false;}
        Item item = (Item) object;
        return orderId == item.orderId
                && Double.compare(item.cost, cost) == 0
                && Double.compare(item.weight, weight) == 0
                && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, orderId, cost, weight);
    }

    @Override
    public String toString() {
        return "Item{"
                + super.getId()
                + ", name=" + name
                + ", orderId=" + orderId
                + ", cost=" + cost
                + ", weight=" + weight
                + "}";
    }
}
