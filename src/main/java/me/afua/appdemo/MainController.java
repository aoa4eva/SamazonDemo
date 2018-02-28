package me.afua.appdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MainController {

@Autowired
UserService user;

@Autowired
ProductService products;
    @RequestMapping("/")
    public String showProductList(Model model, Authentication auth)
    {
        model.addAttribute("me",auth==null?null:user.getCurrentUser(auth));
        model.addAttribute("productList",products.listProducts());
        return "listproducts";
    }

    @PostMapping("/addtocart")
    public String saveItemToCart(HttpServletRequest request, Authentication auth)
    {
        Product p = products.find(new Long(request.getParameter("productid")));
        user.addToCart(p,auth);
        System.out.println(p.getTitle()+"Added to shopping cart");
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model)
    {
        model.addAttribute("newuser",new AppUser());
        return "register";
    }

    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute("newuser") AppUser thisUser, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "register";
        }
        user.saveUser(thisUser);
        return "redirect:/";
    }

    @GetMapping("/showcart")
    public String showCartItems(Authentication auth, Model model)
    {
        AppUser me = user.getCurrentUser(auth);
        model.addAttribute("productList",user.listMyProducts(auth));
        return "listproducts";
    }


}
