package insurancetracker.insurancetracker.controller;

import insurancetracker.insurancetracker.model.User;
import insurancetracker.insurancetracker.service.UserService.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Auth")
public class AuthController {
    @Autowired
    private UserServices userServices;
    @GetMapping("/login")
    public String getLoginPage() {
        return "Auth/login";
    }
    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "Auth/register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        try {
           User registeredUser = userServices.Register(user);
           if (registeredUser != null) {
               return "Client/client";
           }else{
            return "Auth/register";
           }
        } catch (Exception e) {
            e.printStackTrace();
            return "Auth/register";
        }
    }
}
