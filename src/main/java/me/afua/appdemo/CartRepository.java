package me.afua.appdemo;

import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<ShoppingCart, Long> {
}
