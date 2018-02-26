package me.afua.appdemo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String description;

    private long quantity;

    private double price;

    @ManyToMany(mappedBy = "products")
    private Set<ShoppingCart> inCarts;

    public Product() {
        this.inCarts = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<ShoppingCart> getInCarts() {
        return inCarts;
    }

    public void setInCarts(Set<ShoppingCart> inCarts) {
        this.inCarts = inCarts;
    }
}
