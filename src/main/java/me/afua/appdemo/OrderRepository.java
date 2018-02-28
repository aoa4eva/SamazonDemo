package me.afua.appdemo;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findAllByOrderUser(AppUser user);
}
