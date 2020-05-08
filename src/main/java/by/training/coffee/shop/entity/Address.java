package by.training.coffee.shop.entity;

import java.util.Objects;

public class Address extends Entity {
    private String city;
    private String street;
    private Integer house;
    private Integer flat;
    private Long userId;

    public Address(Long id, String city, String street, Integer house,
                   Integer flat, Long userId) {
        super(id);
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
        this.userId = userId;
    }

    public Address(Long id) {
        super(id);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city != null) {
            this.city = city;
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street != null) {
            this.street = street;
        }
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        if (house != null) {
            this.house = house;
        }
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        if (flat != null) {
            this.flat = flat;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Address address = (Address) object;
        return Objects.equals(city, address.city)
                && Objects.equals(street, address.street)
                && Objects.equals(house, address.house)
                && Objects.equals(flat, address.flat)
                && Objects.equals(userId, address.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, flat, userId);
    }

    @Override
    public String toString() {
        return "Address: "
                + super.toString()
                + ", city= " + city
                + ", street= " + street
                + ", house= " + house
                + ", flat= " + flat
                + ", userId= " + userId;
    }
}
