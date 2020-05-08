package by.training.coffee.shop.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class MenuItem extends Entity {
    private String name;
    private Integer weight;
    private BigDecimal cost;
    private Long ingredientId;
    private String ingredientName;

    public MenuItem(Long id, String name, Integer weight,
                    BigDecimal cost, Long ingredientId, String ingredientName) {
        super(id);
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }

    public MenuItem(Long id) {
        super(id);
    }

    public MenuItem() {
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        if (weight != null) {
            this.weight = weight;
        }
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        if (cost != null) {
            this.cost = cost;
        }
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        if (ingredientId != null) {
            this.ingredientId = ingredientId;
        }
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        if (ingredientName != null) {
            this.ingredientName = ingredientName;
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
        MenuItem menuItem = (MenuItem) object;
        return Objects.equals(name, menuItem.name)
                && Objects.equals(weight, menuItem.weight)
                && Objects.equals(cost, menuItem.cost)
                && Objects.equals(ingredientId, menuItem.ingredientId)
                && Objects.equals(ingredientName, menuItem.ingredientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, cost, ingredientId, ingredientName);
    }

    @Override
    public String toString() {
        return "MenuItem: "
                + super.toString()
                + ", name= " + name
                + ", weight= " + weight
                + ", cost= " + cost
                + ", ingredientId= " + ingredientId
                + ", ingredientName= " + ingredientName;
    }
}
