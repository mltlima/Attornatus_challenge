package dev.mltlima.management.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;

//public class user with email, name, id and birthday
@Entity
@Table(name = "users")
public class User {
    private @Id @GeneratedValue Long id;
    private String name;
    private String email;
    private String birthday;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Address> addresses;

    public User() {
    }

    public User(String name, String email, String birthday, List addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(birthday, user.birthday) && Objects.equals(addresses, user.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, birthday, addresses);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday='" + birthday + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}