package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.dtos.HealthInsuranceDto;
import insurancetracker.insurancetracker.helpers.MonthsCalculator;
import insurancetracker.insurancetracker.model.HealthInsurance;
import insurancetracker.insurancetracker.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HealthInsuranceServices {
    @Autowired
    private InsuranceRepository healthInsuranceRepository;
    final double base = 150 ;
    @Autowired
    MonthsCalculator monthsCalculator;
    public HealthInsurance createHealthInsurance(HealthInsuranceDto healthInsurance) {
        try {
            HealthInsurance newHealthInsurance = new HealthInsurance(healthInsurance.getPolicyHolderName(), healthInsurance.getStartDate(), healthInsurance.getEndDate() ,
                    healthInsurance.getAge() , healthInsurance.getCoverageType() , healthInsurance.getHasChronic() , healthInsurance.getUser());
            return healthInsuranceRepository.save(newHealthInsurance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public double calc(HealthInsuranceDto healthInsurance) {
        try {
            QouteCalc qouteCalc = ()->{
                double newBase = base ;
                if (healthInsurance.age()>60){
                    newBase += (base*0.20);
                }
                if (healthInsurance.hasChronic()){
                    newBase += (base * 0.30);
                }
                if (healthInsurance.coverageType().equals("premium")){
                    newBase += (base * 0.05);
                }else{
                    newBase -= (base * 0.10);
                }
                return newBase;
            };
            double newBase = qouteCalc.calc();
            int diffrenceInMonths = monthsCalculator.calculateMonthsBetween(healthInsurance.startDate() , healthInsurance.endDate());
            return newBase * diffrenceInMonths;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public boolean validate(HealthInsuranceDto insuranceDto) {
        if (insuranceDto.getPolicyHolderName().isEmpty()) {
            return false;
        }
        LocalDate startDate = insuranceDto.getStartDate();
        LocalDate endDate = insuranceDto.getEndDate();
        if (startDate == null || endDate == null) {
            return false;
        }

        if (endDate.isBefore(startDate)|startDate.isBefore(LocalDate.now())) {
            return false;
        }
        return true;
    }
    public boolean delete(int id) {
        if (healthInsuranceRepository.existsById(id)) {
            healthInsuranceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
