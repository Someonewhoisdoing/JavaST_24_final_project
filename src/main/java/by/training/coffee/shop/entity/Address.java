package by.training.coffee.shop.entity;


import java.util.Objects;

public class Address extends Entity {
    private String street;
    private Integer house;
    private Integer flat;
    private Long userId;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Address address = (Address) object;
        return Objects.equals(street, address.street)
                && Objects.equals(house, address.house)
                && Objects.equals(flat, address.flat)
                && Objects.equals(userId, address.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, house, flat, userId);
    }

    @Override
    public String toString() {
        return "Address{"
                + "street=" + street
                + ", house=" + house
                + ", flat=" + flat
                + ", userId=" + userId
                + "}";
    }
}
