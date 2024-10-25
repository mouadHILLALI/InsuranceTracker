package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.model.HealthInsurance;
import insurancetracker.insurancetracker.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthInsuranceServices {
    @Autowired
    private InsuranceRepository healthInsuranceRepository;

    public HealthInsurance createHealthInsurance(HealthInsurance healthInsurance) {
        try {
            return healthInsuranceRepository.save(healthInsurance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
