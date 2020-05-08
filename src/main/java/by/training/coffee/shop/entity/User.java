package by.training.coffee.shop.entity;

import java.util.Objects;

public class User extends Entity {
    private String login;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private Integer role;

    public User(Long id, String login, String password, String name,
                String surname, String phone, Integer role) {
        super(id);
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.role = role;
    }

    public User(Long id) {
        super(id);
    }

    public User() {
        //empty constructor
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login != null) {
            this.login = login;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null) {
            this.password = password;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname != null) {
            this.surname = surname;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null) {
            this.phone = phone;
        }
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        if (role != null) {
            this.role = role;
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
        User user = (User) object;
        return Objects.equals(login, user.login)
                && Objects.equals(password, user.password)
                && Objects.equals(name, user.name)
                && Objects.equals(surname, user.surname)
                && Objects.equals(phone, user.phone)
                && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, name, surname, phone, role);
    }

    @Override
    public String toString() {
        return "User: "
                + super.toString()
                + ", login= " + login
                + ", password= " + password
                + ", name= " + name
                + ", surname= " + surname
                + ", phone= " + phone
                + ", role= " + role;
    }
}
