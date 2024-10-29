package insurancetracker.insurancetracker.controller;

import insurancetracker.insurancetracker.dtos.CarInsuranceDto;
import insurancetracker.insurancetracker.dtos.ContractDto;
import insurancetracker.insurancetracker.dtos.HealthInsuranceDto;
import insurancetracker.insurancetracker.dtos.HomeInsuranceDto;
import insurancetracker.insurancetracker.model.*;
import insurancetracker.insurancetracker.repository.ContractRepository;
import insurancetracker.insurancetracker.service.ContractService.ContractServices;
import insurancetracker.insurancetracker.service.InsuranceService.CarInsuranceServices;
import insurancetracker.insurancetracker.service.InsuranceService.HealthInsuranceServices;
import insurancetracker.insurancetracker.service.InsuranceService.HomeInsuranceServices;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    @Autowired
    private ContractServices contractServices;
    @GetMapping("/health")
    public String healthInsurance(Model model , HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
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
    public String homeInsurance(Model model , HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("homeInsurance", new HomeInsurance());
        return "insurance/home";
    }
    @PostMapping("/createCar")
    public String createInsurance(@RequestParam(name = "PolicyHolderName") String policyHolderName,
                                  @RequestParam(name = "startDate") LocalDate startDate,
                                  @RequestParam(name = "endDate") LocalDate endDate,
                                  @RequestParam(name = "DriverAge") int driverAge,
                                  @RequestParam(name = "VehiculeType") String vehiculeType,
                                  @RequestParam(name = "isProfessionalUse") String isProfessionalUse,
                                  @RequestParam(name = "hasAccidents") String hasAccidents,
                                  HttpSession session, Model model) {
        try {
            boolean isPro = Boolean.parseBoolean(isProfessionalUse);
            boolean hasAcc = Boolean.parseBoolean(hasAccidents);
            CarInsuranceDto carInsuranceDto = new CarInsuranceDto(policyHolderName, startDate, endDate, driverAge, vehiculeType, isPro, hasAcc);
            boolean flag = carInsuranceServices.validate(carInsuranceDto);
            if (flag) {
                double total = carInsuranceServices.qouteCalc(carInsuranceDto);
                session.setAttribute("carInsuranceDto", carInsuranceDto);
                session.setAttribute("total", total);
                return "insurance/carQuote";
            }else{
                model.addAttribute("error", "An error occurred while creating the insurance. Please try again.");
                return "insurance/car";
            }

        } catch (Exception ex) {
            System.err.println("Error creating insurance: " + ex.getMessage());
            model.addAttribute("error", "An error occurred while creating the insurance. Please try again.");
            return "Auth/client";
        }
    }

    @PostMapping("/carQoute")
    public String handleQoute(Model model , @RequestParam(name = "resp") String resp , HttpSession session) {
        try {
            if (resp.equals("approve")){
                model.addAttribute("type" , "car");
                double total = (double) session.getAttribute("total");
                model.addAttribute("total", total);
                return "Contract/contract";
            } else if (resp.equals("reject")) {
                return "insurance/car";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insurance/car";
    }
    @PostMapping("/homeQoute")
    public String handleHomeQoute(Model model , @RequestParam(name = "resp") String resp , HttpSession session) {
        try {
            if (resp.equals("approve")){
                model.addAttribute("type" , "home");
                double total = (double) session.getAttribute("total");
                model.addAttribute("total", total);
                return "Contract/contract";
            } else if (resp.equals("reject")) {
                return "insurance/home";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insurance/home";
    }
    @PostMapping("/healthQoute")
    public String handleHealthQoute(Model model , @RequestParam(name = "resp") String resp , HttpSession session) {
        try {
            if (resp.equals("approve")){
                model.addAttribute("type" , "health");
                double total = (double) session.getAttribute("total");
                model.addAttribute("total", total);
                return "Contract/contract";
            } else if (resp.equals("reject")) {
                return "insurance/health";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insurance/health";
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
            HomeInsuranceDto homeInusrance = new HomeInsuranceDto(PolicyHolderName , startDate , endDate ,PropertyValue,
                    isHous , hasSecurity , isInRisk ,user);
            session.setAttribute("homeInsurance" , homeInusrance);
            double homeTotal = homeInsuranceServices.calc(homeInusrance);
            session.setAttribute("total", homeTotal);
           return "insurance/homeQoute";
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
            boolean hasChronicConditio = hasChronicCondition.equals("yes") ? true : false;
            HealthInsuranceDto healthInsuranceDto = new HealthInsuranceDto(PolicyHolderName , startDate , endDate ,age,
                    CoverageType , hasChronicConditio , user);
            session.setAttribute("healthInsurance" , healthInsuranceDto);
            double healthTotal = healthInsuranceServices.calc(healthInsuranceDto);
            session.setAttribute("total", healthTotal);
            return "insurance/healthQoute";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/insurance/health";
        }
    }

    @PostMapping("/contract")
    public String contract(Model model , @RequestParam(name = "total") double total ,@RequestParam(name = "insuranceType") String type, HttpSession session) {
        try {
            switch (type){
                case "car":
                   carContract(session , total);
                case "home":
                    homeContract(session , total);
                    break;
                case "health":
                    healthContract(session , total);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "insurance/carQuote";
    }
    public String carContract(HttpSession session , double total){
        try {
            CarInsuranceDto carInsuranceDto = (CarInsuranceDto) session.getAttribute("carInsuranceDto");
            AutoInsurance caInsurance = carInsuranceServices.create(carInsuranceDto , session);
            ContractDto contractDto = new ContractDto("file" ,caInsurance , total );
            boolean flag = contractServices.addCarContract(contractDto ,caInsurance);
            if (caInsurance!=null&&flag){
                return "redirect:/Auth/client";
            }else{
                return "redirect:/Auth/client";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/insurance/contract";
        }

    }
    public String homeContract(HttpSession session, double total){
        try {
            HomeInsuranceDto insuranceDto = (HomeInsuranceDto) session.getAttribute("homeInsurance");
            HomeInsurance Insurance = homeInsuranceServices.create(insuranceDto);
            ContractDto contractDto = new ContractDto("file" ,Insurance , total );
            boolean flag = contractServices.addHomeContract(contractDto , Insurance);
            if (Insurance!=null&&flag){
                return "redirect:/Auth/client";
            }else{
                return "redirect:/Auth/client";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/insurance/contract";
        }
    }
    public String healthContract(HttpSession session , double total){
        try {
            HealthInsuranceDto insuranceDto = (HealthInsuranceDto) session.getAttribute("healthInsurance");
            HealthInsurance Insurance = healthInsuranceServices.createHealthInsurance(insuranceDto);
            ContractDto contractDto = new ContractDto("file" ,Insurance , total );
            boolean flag = contractServices.addHealthContract(contractDto , Insurance);
            if (Insurance!=null&&flag){
                return "redirect:/Auth/client";
            }else{
                return "redirect:/Auth/client";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/Auth/client";
        }
    }
}
