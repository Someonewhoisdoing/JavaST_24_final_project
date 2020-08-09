package by.training.coffee.shop.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable, Cloneable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id= " + id;
    }
}
