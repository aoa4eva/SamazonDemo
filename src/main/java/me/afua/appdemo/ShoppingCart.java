package me.afua.appdemo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set <Product> products;

    @OneToOne
    AppUser customer;

    @OneToOne
    private Order theOrder;

    public ShoppingCart() {
        this.products = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public AppUser getCustomer() {
        return customer;
    }

    public void setCustomer(AppUser customer) {
        this.customer = customer;
    }

    public void addProduct(Product p)
    {
        this.products.add(p);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                '}';
    }
}
