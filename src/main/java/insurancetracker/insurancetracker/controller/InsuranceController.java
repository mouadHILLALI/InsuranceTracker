package insurancetracker.insurancetracker.controller;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.pdfa.PdfADocument;
import insurancetracker.insurancetracker.dtos.CarInsuranceDto;
import insurancetracker.insurancetracker.dtos.ContractDto;
import insurancetracker.insurancetracker.dtos.HealthInsuranceDto;
import insurancetracker.insurancetracker.dtos.HomeInsuranceDto;
import insurancetracker.insurancetracker.model.*;
import insurancetracker.insurancetracker.service.ContractService.ContractServices;
import insurancetracker.insurancetracker.service.InsuranceService.CarInsuranceServices;
import insurancetracker.insurancetracker.service.InsuranceService.HealthInsuranceServices;
import insurancetracker.insurancetracker.service.InsuranceService.HomeInsuranceServices;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {
    private static final String UPLOAD_DIR = "tmp/";
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
        session.setAttribute("user", user);
        model.addAttribute("healthInsurance", new HealthInsurance());
        return "insurance/health";
    }
    @GetMapping("/car")
    public String carInsurance(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        List<AutoInsurance> carInsurances = user.getCarInsurance();
        model.addAttribute("carInsurances", carInsurances);
        model.addAttribute("carInsurance", new AutoInsurance());
        return "insurance/car";
    }

    @GetMapping("/home")
    public String homeInsurance(Model model , HttpSession session) {
        User user = (User) session.getAttribute("user");
        session.setAttribute("user", user);
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
                if (total == 0){
                    session.setAttribute("total", 0);
                }else{
                session.setAttribute("total", total);
                }
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
            boolean flag = homeInsuranceServices.validate(homeInusrance);
            if (flag) {
            session.setAttribute("homeInsurance" , homeInusrance);
            double homeTotal = homeInsuranceServices.calc(homeInusrance);
            session.setAttribute("total", homeTotal);
            return "insurance/homeQoute";
            }else {
                session.setAttribute("alertMessage" , "invalid inputs");
                return "insurance/home";
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
            boolean hasChronicConditio = hasChronicCondition.equals("yes") ? true : false;
            HealthInsuranceDto healthInsuranceDto = new HealthInsuranceDto(PolicyHolderName , startDate , endDate ,age,
                    CoverageType , hasChronicConditio , user);
            boolean flag = healthInsuranceServices.validate(healthInsuranceDto);
            if (flag){
            session.setAttribute("healthInsurance" , healthInsuranceDto);
            double healthTotal = healthInsuranceServices.calc(healthInsuranceDto);
            session.setAttribute("total", healthTotal);
            return "insurance/healthQoute";
            }else{
                session.setAttribute("alertMessage" , "invalid inputs");
                return "redirect:/insurance/health";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/insurance/health";
        }
    }


    @PostMapping("/contract")
    public String contract(@RequestParam(name = "total") double total ,@RequestParam(name = "insuranceType") String type , HttpSession session) {
        try {
            switch (type){
                case "car":
                   carContract(session , total , "file");
                   break;
                case "home":
                    homeContract(session , total , "file");
                    break;
                case "health":
                    healthContract(session , total , "file");
                    break;
            }
            return "redirect:/Auth/client";
        } catch (Exception e) {
            e.printStackTrace();
            return "Contract/contract";
        }

    }

    @GetMapping("/display/{id}/{type}")
    public String displayInsurance(@PathVariable(name = "id") int id , @PathVariable("type") String type, HttpSession session , Model model) {
        try {
            switch (type) {
                case "car":
                    return displayCarContract(id, model, session);
                case "home":

                    break;
                case "health":

                    break;
                default:
                    session.setAttribute("alertMessage", "Invalid insurance type");
                    return "Client/client";
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("alertMessage", "An error occurred");
            return "Client/client";
        }
        return "Client/client";
    }


    public String displayCarContract(int id, Model model, HttpSession session) {
        try {
            AutoInsurance insurance = carInsuranceServices.getInsurance(id);
            if (insurance == null) {
                session.setAttribute("alertMessage", "AutoInsurance not found");
                return "Client/client";
            }
            Contract contract = contractServices.getContractByAutoInsuranceId(insurance.getId());
            model.addAttribute("insurance", insurance);
            if(contract!=null){
                model.addAttribute("contract", contract);
            }
            return "insurance/carContract";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("alertMessage", "An error occurred while fetching the contract");
            return "insurance/carContract";
        }
    }


    public String carContract(HttpSession session , double total , String path){
        try {
            CarInsuranceDto carInsuranceDto = (CarInsuranceDto) session.getAttribute("carInsuranceDto");
            AutoInsurance caInsurance = carInsuranceServices.create(carInsuranceDto , session);
            ContractDto contractDto = new ContractDto(path ,caInsurance , total );
            boolean flag = contractServices.addCarContract(contractDto ,caInsurance);
            if (caInsurance!=null&&flag){
                session.setAttribute("alertMessage" , "Car insurance was created successfully");
                return "redirect:/Auth/client";
            }else{
                session.setAttribute("alertMessage" , "failed to create car insurance");
                return "redirect:/Auth/client";
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("alertMessage" , "An error occurred while creating the car insurance");
            return "redirect:/Auth/client";
        }

    }
    public String homeContract(HttpSession session, double total, String path){
        try {
            HomeInsuranceDto insuranceDto = (HomeInsuranceDto) session.getAttribute("homeInsurance");
            HomeInsurance Insurance = homeInsuranceServices.create(insuranceDto);
            ContractDto contractDto = new ContractDto(path ,Insurance , total );
            boolean flag = contractServices.addHomeContract(contractDto , Insurance);
            if (Insurance!=null&&flag){
                session.setAttribute("alertMessage" , "Home insurance was created successfully");
                return "redirect:/Auth/client";
            }else{
                session.setAttribute("alertMessage" , "couldn't create home insurance");
                return "redirect:/Auth/client";
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("alertMessage" , "An error occurred while creating the home insurance");
            return "redirect:/Auth/client";
        }
    }
    public String healthContract(HttpSession session , double total, String path){
        try {
            HealthInsuranceDto insuranceDto = (HealthInsuranceDto) session.getAttribute("healthInsurance");
            HealthInsurance Insurance = healthInsuranceServices.createHealthInsurance(insuranceDto);
            ContractDto contractDto = new ContractDto(path ,Insurance , total );
            boolean flag = contractServices.addHealthContract(contractDto , Insurance);
            if (Insurance!=null&&flag){
                session.setAttribute("alertMessage" , "Health insurance was created successfully");
                return "redirect:/Auth/client";
            }else{
                session.setAttribute("alertMessage" , "couldn't create health insurance");
                return "redirect:/Auth/client";
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("alertMessage" , "An error occurred while creating the health insurance");
            return "redirect:/Auth/client";
        }
    }


    @GetMapping("/downloadPdf")
    public ResponseEntity<byte[]> downloadPdf(@RequestParam("id") int insuranceId, HttpServletResponse response) throws Exception {
        // Set the response headers for the PDF download
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=insurance-details.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");

        // Create the PdfWriter and PdfDocument instances
        PdfWriter pdfWriter = new PdfWriter(response.getOutputStream());
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument);

        // Add content to the PDF
        document.add(new Paragraph("Car Insurance Details"));
        document.add(new Paragraph("Insurance ID: " + insuranceId));
        document.add(new Paragraph("Policy Holder: John Doe"));
        document.add(new Paragraph("Start Date: 01-Jan-2024"));
        document.add(new Paragraph("End Date: 01-Jan-2025"));
        document.add(new Paragraph("Vehicle Type: Sedan"));

        // Close the document to finish writing the content
        document.close();

        // The response output stream will automatically handle the byte array and serve the file
        return ResponseEntity.ok()
                .headers(headers)
                .build();  // No need to return the byte[] since the response is already being written directly
    }

}
