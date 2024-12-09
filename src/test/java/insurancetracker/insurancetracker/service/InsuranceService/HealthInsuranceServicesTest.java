package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.dtos.HealthInsuranceDto;
import insurancetracker.insurancetracker.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HealthInsuranceServicesTest {
    HealthInsuranceServices healthInsuranceServices;

    @BeforeEach
    public void setUp() throws Exception {
        healthInsuranceServices = Mockito.mock(HealthInsuranceServices.class);
    }
    @Test
    public void calc() {
        HealthInsuranceServices healthInsuranceServices = new HealthInsuranceServices();
        int age = 35;
        boolean hasPreExistingConditions = false;
        String coverageLevel = "standard";
        double expectedPremium = 1200.0;
        User user = new User();
        HealthInsuranceDto healthInsuranceDto = new HealthInsuranceDto("test" , LocalDate.EPOCH , LocalDate.now() , age ,coverageLevel, false , user);

        double actualPremium = healthInsuranceServices.calc(healthInsuranceDto);
        assertEquals(expectedPremium, actualPremium, 0.01);
    }

}
