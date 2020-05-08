package by.training.coffee.shop.entity;

import java.util.Objects;

public class Ingredient extends Entity {
    private String name;

    public Ingredient(Long id, String name) {
        super(id);
        this.name = name;
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(Long id) {
        super(id);
    }

    public Ingredient() {
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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Ingredient that = (Ingredient) object;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Ingredient: "
                + super.toString()
                + ", name= " + name;
    }
}
