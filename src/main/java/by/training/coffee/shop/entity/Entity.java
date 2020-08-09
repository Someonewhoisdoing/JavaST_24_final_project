package by.training.coffee.shop.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable, Cloneable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
            this.id = id;
    }

    @Override
    public String toString() {
        return "id= " + id;
    }
}
