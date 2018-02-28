package me.afua.appdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    AppUserRepository user;

    @Autowired
    AppRoleRepository role;

    @Autowired
    OrderRepository orders;

    public void save(AppUser thisUser)
    {
        user.save(thisUser);
    }

    public void saveUser(AppUser thisUser)
    {
        thisUser.addRole(role.findAppRoleByRoleName("USER"));
        System.out.println(thisUser);
        user.save(thisUser);
    }

    public void addToCart(Product p, Authentication auth)
    {
     AppUser thisUser = user.findByEmail(auth.getName());
     thisUser.getCart().addProduct(p);
     save(thisUser);
    }

    public AppUser getCurrentUser(Authentication auth)
    {

        return user.findByEmail(auth.getName());
    }

    public Iterable<Product> listMyProducts(Authentication auth)
    {
        return getCurrentUser(auth).getCart().getProducts();
    }

    public Iterable<Order> orderHistory(Authentication auth)
    {
        AppUser thisUser = getCurrentUser(auth);
        return thisUser.getMyOrders();
    }

    public void buyItems(Authentication auth)
    {
        AppUser thisUser = getCurrentUser(auth);
        //Create an order:
        Order thisOrder = new Order();
        thisOrder.setTheCart(thisUser.getCart());
        thisOrder.setOrderUser(thisUser);
        orders.save(thisOrder);
        thisUser.setCart(new ShoppingCart());
        user.save(thisUser);



    }
}
