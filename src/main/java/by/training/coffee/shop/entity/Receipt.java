package by.training.coffee.shop.entity;

import java.util.Date;
import java.util.Objects;

public class Receipt extends Entity {
    private Integer number;
    private Date date;
    private Long userId;
    private Long receiptId;

    public Receipt(Long id, Integer number, Date date, Long userId) {
        super(id);
        this.number = number;
        this.date = date;
        this.userId = userId;
    }

    public Receipt(Integer number, Date date, Long userId) {
        this.number = number;
        this.date = date;
        this.userId = userId;
    }

    public Receipt(Long id) {
        super(id);
    }

    public Receipt() {
        //empty constructor
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        if (number != null) {
            this.number = number;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        if (date != null) {
            this.date = date;
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
        Receipt receipt = (Receipt) object;
        return Objects.equals(number, receipt.number) &&
                Objects.equals(date, receipt.date) &&
                Objects.equals(userId, receipt.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, date, userId);
    }

    @Override
    public String toString() {
        return "Receipt: "
                + super.toString()
                + ", number=" + number
                + ", date=" + date
                + ", userId=" + userId;
    }
}
