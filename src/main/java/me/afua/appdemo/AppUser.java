package me.afua.appdemo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String email;

    private String password;

    @ManyToMany
    private Set<AppRole> roles;

    @OneToOne(cascade = CascadeType.PERSIST)
    private ShoppingCart cart;

    @OneToMany
    private Set<Order> myOrders;

    public AppUser() {
        this.roles = new HashSet<>();
        this.cart = new ShoppingCart();
        this.myOrders = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public void addRole(AppRole r)
    {
        roles.add(r);
    }

    public Set<Order> getMyOrders() {
        return myOrders;
    }

    public void setMyOrders(Set<Order> myOrders) {
        this.myOrders = myOrders;
    }

    public void addOrder(Order order)
    {
        this.myOrders.add(order);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cart=" + cart +
                '}';
    }
}
