package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.model.HomeInsurance;
import insurancetracker.insurancetracker.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeInsuranceServices {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public HomeInsurance create(HomeInsurance homeInsurance) {
        try {
            return insuranceRepository.save(homeInsurance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
