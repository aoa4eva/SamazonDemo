package me.afua.appdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ProductService {
    @Autowired
    ProductRepository products;

    public Iterable<Product> listProducts()
    {
        return (Iterable<Product>) products.findAll();
    }

    public Product find(long id)
    {
        return products.findOne(id);
    }

    public void save(Product p)
    {
        products.save(p);
    }
}
