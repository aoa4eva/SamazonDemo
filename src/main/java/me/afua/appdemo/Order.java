package me.afua.appdemo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "theOrder")
    private ShoppingCart theCart;

    @ManyToOne
    private Set <AppUser> orderUser;

    public Order() {
        orderUser = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<AppUser> getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Set<AppUser> orderUser) {
        this.orderUser = orderUser;
    }

    public ShoppingCart getTheCart() {
        return theCart;
    }

    public void setTheCart(ShoppingCart theCart) {
        this.theCart = theCart;
    }
}
