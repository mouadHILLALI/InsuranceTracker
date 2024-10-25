package insurancetracker.insurancetracker.controller;

import insurancetracker.insurancetracker.model.*;
import insurancetracker.insurancetracker.service.InsuranceService.CarInsuranceServices;
import insurancetracker.insurancetracker.service.InsuranceService.HealthInsuranceServices;
import insurancetracker.insurancetracker.service.InsuranceService.HomeInsuranceServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    private CarInsuranceServices carInsuranceServices;
    @Autowired
    private HealthInsuranceServices healthInsuranceServices;
    @Autowired
    private HomeInsuranceServices homeInsuranceServices;
    @GetMapping("/health")
    public String healthInsurance(Model model) {
        model.addAttribute("healthInsurance", new HealthInsurance());
        return "insurance/health";
    }
    @GetMapping("/car")
    public String carInsurance(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("carInsurance", new AutoInsurance());
        return "insurance/car";
    }
    @GetMapping("/home")
    public String homeInsurance(Model model) {
        model.addAttribute("homeInsurance", new HomeInsurance());
        return "insurance/home";
    }
    @PostMapping("/createCar")
    public String createInsurance(@RequestParam(name = "PolicyHolderName") String PolicyHolderName ,
                                  @RequestParam(name = "startDate") LocalDate startDate ,
                                  @RequestParam(name = "endDate") LocalDate endDate ,
                                  @RequestParam(name = "DriverAge") int DriverAge ,
                                  @RequestParam(name = "VehiculeType") String VehiculeType ,
                                  @RequestParam(name = "isProfessionalUse") String isProfessionalUse ,
                                  @RequestParam(name = "hasAccidents") String hasAccidents,
                                  HttpSession session
            , Model model) {
        try {
            boolean isPro = isProfessionalUse.equals("yes") ? true : false;
            boolean hasAcc = hasAccidents.equals("yes") ? true : false;
            User user = (User) session.getAttribute("user");
            AutoInsurance autoInsurance = new AutoInsurance(PolicyHolderName , startDate, endDate , DriverAge , VehiculeType ,isPro , hasAcc ,user);
            AutoInsurance insurance =  carInsuranceServices.create(autoInsurance);
            if (insurance != null) {
                return "redirect:/Auth/client";
            }else{
                return "redirect:/insurance/car";
            }

            } catch (Exception ex) {
            throw new RuntimeException(ex);
            }
    }

    @PostMapping("/createHome")
    public String createInsurance( @RequestParam(name = "PolicyHolderName") String PolicyHolderName ,
                                   @RequestParam(name = "startDate") LocalDate startDate ,
                                   @RequestParam(name = "endDate") LocalDate endDate ,
                                   @RequestParam(name = "PropertyValue") double PropertyValue,
                                   @RequestParam(name = "isHouse") String isHouse,
                                   @RequestParam(name = "hasSecuritySystem") String hasSecuritySystem,
                                   @RequestParam(name = "isInRiskZone") String isInRiskZone , HttpSession session){

        try {
            User user = (User) session.getAttribute("user");
            boolean hasSecurity = hasSecuritySystem.equals("yes") ? true : false;
            boolean isHous = isHouse.equals("yes") ? true : false;
            boolean isInRisk = isInRiskZone.equals("yes") ? true : false;
            HomeInsurance homeInusrance = new HomeInsurance(PolicyHolderName , startDate , endDate ,PropertyValue,
                    isHous , hasSecurity , isInRisk ,user);
            homeInusrance = homeInsuranceServices.create(homeInusrance);
            if (homeInusrance != null){
                return "redirect:/Auth/client";
            }else{
                return "redirect:/insurance/home";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/insurance/home";
        }
    }

    @PostMapping("/createHealth")
    public String createInsurance(
            @RequestParam(name = "PolicyHolderName") String PolicyHolderName ,
            @RequestParam(name = "startDate") LocalDate startDate ,
            @RequestParam(name = "endDate") LocalDate endDate ,
            @RequestParam(name = "hasChronicCondition") String hasChronicCondition,
            @RequestParam(name = "CoverageType") String CoverageType,
            @RequestParam(name = "age") int age,
            HttpSession session , Model model
    ){
        try {
            User user = (User) session.getAttribute("user");
            boolean hasChronic = hasChronicCondition.equals("yes") ? true : false;
            HealthInsurance healthInsurance = new HealthInsurance (PolicyHolderName ,startDate , endDate , age , CoverageType , hasChronic  , user );
            healthInsurance = healthInsuranceServices.createHealthInsurance(healthInsurance);
            if (healthInsurance != null) {
                return "redirect:/Auth/client";
            }else{
                return "redirect:/insurance/health";
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
