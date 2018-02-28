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

    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean canBuy(int number)
    {
        if(number>this.quantity)
            return false;
        else return true;
    }

    public boolean buy(int number)
    {
        if(canBuy(number))
        {
            this.setQuantity(this.quantity-number);
            return true;
        }
        else return false;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", inCarts=" + inCarts +
                '}';
    }
}
