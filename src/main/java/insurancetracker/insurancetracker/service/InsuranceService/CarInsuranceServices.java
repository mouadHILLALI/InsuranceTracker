package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.dtos.CarInsuranceDto;
import insurancetracker.insurancetracker.helpers.MonthsCalculator;
import insurancetracker.insurancetracker.model.AutoInsurance;
import insurancetracker.insurancetracker.model.User;
import insurancetracker.insurancetracker.repository.InsuranceRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarInsuranceServices {
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private MonthsCalculator monthsCalculator;
    final double base = 500 ;
    public AutoInsurance create(CarInsuranceDto carInsuranceDto , HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            AutoInsurance autoInsurance = new AutoInsurance(carInsuranceDto.policyHolderName() , carInsuranceDto.startDate() ,carInsuranceDto.endDate() ,carInsuranceDto.driverAge() ,
                    carInsuranceDto.vehicleType() , carInsuranceDto.isProfessional() , carInsuranceDto.hasAccidents() ,user );
            return insuranceRepository.save(autoInsurance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public double qouteCalc(CarInsuranceDto carInsuranceDto){
        try {
            QouteCalc qouteCalc = ()->{
                double newBase = base ;
                if (carInsuranceDto.driverAge()<25){
                    newBase += (base/10);
                }
                if (carInsuranceDto.vehicleType().equals("lux")){
                    newBase += (base * 0.15);
                }
                if (carInsuranceDto.isProfessional()){
                    newBase += (base * 0.10);
                }
                if (carInsuranceDto.hasAccidents()){
                    newBase += (base * 0.10);
                }else{
                    newBase -= (base * 0.20);
                }
                return newBase;
            };
            double newBase = qouteCalc.calc();
            int diffrenceInMonths = monthsCalculator.calculateMonthsBetween(carInsuranceDto.startDate() , carInsuranceDto.endDate());
            double total = newBase * diffrenceInMonths;
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
