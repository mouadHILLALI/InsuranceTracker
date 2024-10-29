package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.dtos.HomeInsuranceDto;
import insurancetracker.insurancetracker.model.User;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

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
        assertEquals("The calculated premium should match the expected premium.", expectedPremium, actualPremium, 0.01);
    }
}
