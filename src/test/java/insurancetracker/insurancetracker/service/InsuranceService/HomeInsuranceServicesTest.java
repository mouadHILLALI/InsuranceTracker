package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.dtos.HomeInsuranceDto;
import insurancetracker.insurancetracker.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HomeInsuranceServicesTest {

    @Test
    public void calc() {
        HomeInsuranceServices homeInsuranceServices = new HomeInsuranceServices();
        double propertyValue = 250000;
        int yearsInsured = 5;
        double expectedPremium = 1500;
        User user = new User();
        HomeInsuranceDto homeInsuranceDto = new HomeInsuranceDto("test" , LocalDate.EPOCH , LocalDate.now() ,propertyValue , true , true , false , user );
        double actualPremium = homeInsuranceServices.calc(homeInsuranceDto);
        assertEquals(expectedPremium, actualPremium, 0.01);
    }
}
