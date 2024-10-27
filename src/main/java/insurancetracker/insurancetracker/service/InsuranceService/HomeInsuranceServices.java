package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.dtos.HomeInsuranceDto;
import insurancetracker.insurancetracker.helpers.MonthsCalculator;
import insurancetracker.insurancetracker.model.HomeInsurance;
import insurancetracker.insurancetracker.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeInsuranceServices {
    @Autowired
    private InsuranceRepository insuranceRepository;
    final double base = 300 ;
    @Autowired
    MonthsCalculator monthsCalculator;
    public HomeInsurance create(HomeInsuranceDto homeInsurance) {
        try {
            HomeInsurance homeInsuran = new HomeInsurance(homeInsurance.policyHolderName() , homeInsurance.startDate() , homeInsurance.endDate(), homeInsurance.propertyValue(),
                    homeInsurance.isHous() , homeInsurance.hasSecurity() , homeInsurance.isInRisk() , homeInsurance.user());
            return insuranceRepository.save(homeInsuran);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public double calc(HomeInsuranceDto homeInsurance) {
        try {
            QouteCalc qouteCalc = ()->{
                double newBase = base ;
                if (homeInsurance.isHous()){
                    newBase += (base*0.02);
                }
                if (homeInsurance.isInRisk()){
                    newBase += (base * 0.05);
                }
                if (homeInsurance.getPropertyValue()>200000){
                    newBase += (base * 0.10);
                }
                if (homeInsurance.hasSecurity()){
                    newBase -= (base * 0.15);
                }else{
                    newBase += (base * 0.15);
                }
                return newBase;
            };
            double newBase = qouteCalc.calc();
            int diffrenceInMonths = monthsCalculator.calculateMonthsBetween(homeInsurance.startDate() , homeInsurance.endDate());
            return  newBase * diffrenceInMonths;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
