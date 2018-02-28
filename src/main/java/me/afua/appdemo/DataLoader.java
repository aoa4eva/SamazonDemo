package me.afua.appdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

@Autowired
ProductRepository productRepository;

@Autowired
AppUserRepository userRepository;

@Autowired
CartRepository cartRepository;

@Autowired
AppRoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception {

        AppRole aRole = new AppRole();
        aRole.setRoleName("USER");
        roleRepository.save(aRole);

        aRole = new AppRole();
        aRole.setRoleName("ADMIN");
        roleRepository.save(aRole);


        Product p = new Product();
        p.setDescription("A new phone with a whole lot of features that should be outlined lorem ipsum.");
        p.setTitle("Samsung Galaxy 9");
        p.setQuantity(3);
        p.setPrice(719.99);
        p.setImage("https://upload.wikimedia.org/wikipedia/commons/4/47/Samsung_Galaxy_S9.jpg");
        productRepository.save(p);

        Product q = new Product();
        q.setTitle("Another Samsung Galaxy 9");
        q.setDescription("Another phone described in less depth");
        q.setQuantity(2);
        q.setPrice(719.99);
        q.setImage("https://en.wikipedia.org/wiki/Samsung_Galaxy_S9#/media/File:Samsung_Galaxy_S9.png");
        productRepository.save(q);

        AppUser newUser = new  AppUser();
        newUser.setEmail("user@email.com");
        newUser.setPassword("password");
        newUser.getCart().addProduct(p);
        userRepository.save(newUser);

//        newUser = userRepository.findOne(new Long(1));
 //       System.out.println(newUser.getEmail()+"'s products:"+newUser.toString());
 //       System.out.println("Products in cart:"+newUser.getCart().getProducts());

        newUser = userRepository.findOne(new Long(1));
        System.out.println(p);
    }
}
