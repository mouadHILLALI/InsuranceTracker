package insurancetracker.insurancetracker.controller;

import insurancetracker.insurancetracker.model.User;
import insurancetracker.insurancetracker.service.UserService.UserServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Auth")
@SessionAttributes("user")
public class AuthController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "Auth/login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "Auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, HttpSession session, Model model) {
        try {
            User registeredUser = userServices.Register(user);
            if (registeredUser != null) {
                session.setAttribute("user", registeredUser);
                return "Client/client";
            } else {
                model.addAttribute("error", "Registration failed. Please try again.");
                return "Auth/register";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred during registration.");
            return "Auth/register";
        }
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, HttpSession session, Model model) {
        try {
            User loggedInUser = userServices.Login(user.getEmail(), user.getPassword());
            if (loggedInUser != null) {
                session.setAttribute("user", loggedInUser);
                model.addAttribute("user", loggedInUser);
                return "Client/client";
            } else {
                model.addAttribute("error", "Invalid credentials. Please try again.");
                return "Auth/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred during login.");
            return "Auth/login";
        }
    }

    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            return "redirect:/Auth/login";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/Auth/login";
        }
    }
    @GetMapping("/client")
    public String getClient(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        int activeInsurances = userServices.activeInsurance(user);
        session.setAttribute("activeInsurances", activeInsurances);
        long totalContracts = userServices.getTotalContracts(user);
        session.setAttribute("totalContracts", totalContracts);
        double totalPremium = userServices.totalPremium(user);
        session.setAttribute("totalPremium", totalPremium);
        if (user != null) {
            model.addAttribute("user", user);
            return "Client/client";
        }else{
            return "redirect:/Auth/login";
        }
    }

    @GetMapping("/profile")
    public String getProfile(HttpSession session , Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "Client/profile";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute User updatedUser, HttpSession session, Model model) {
        if(updatedUser == null) {
            session.setAttribute("alertMessage", "Invalid credentials. Please try again.");
        }else if (userServices.validator(updatedUser)){
            User user = userServices.updateUser(updatedUser);
            model.addAttribute("user", user);
        }
        return "Client/profile";
    }
}
