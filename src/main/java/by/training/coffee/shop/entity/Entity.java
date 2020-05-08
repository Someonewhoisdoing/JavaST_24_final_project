package by.training.coffee.shop.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable, Cloneable {
    private Long id;

    public Entity(Long id) {
        if (id != null) {
            this.id = id;
        }
    }

    public Entity() {
        //empty constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id != null) {
            this.id = id;
        }
    }

    @Override
    public String toString() {
        return "id= " + id;
    }
}
