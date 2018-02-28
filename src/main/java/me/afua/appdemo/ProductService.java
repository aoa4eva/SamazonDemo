package me.afua.appdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    ProductRepository products;

    public HashSet<Product> listProducts()
    {
        return (HashSet<Product>) products.findAll();
    }
}
