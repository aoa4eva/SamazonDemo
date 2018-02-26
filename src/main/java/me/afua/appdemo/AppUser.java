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

    @OneToMany(mappedBy = "customer")
    private Set <ShoppingCart> carts;


    public AppUser() {
        this.roles = new HashSet<>();
        this.carts = new HashSet<>();
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

    public Set<ShoppingCart> getCarts() {
        return carts;
    }

    public void setCarts(Set<ShoppingCart> carts) {
        this.carts = carts;
    }
}
