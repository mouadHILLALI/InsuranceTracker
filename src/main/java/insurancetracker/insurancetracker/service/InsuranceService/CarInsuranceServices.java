package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.model.AutoInsurance;
import insurancetracker.insurancetracker.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarInsuranceServices {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public AutoInsurance create(AutoInsurance insurance) {
        try {
            return insuranceRepository.save(insurance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
