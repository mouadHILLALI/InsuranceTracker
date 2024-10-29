package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.dtos.HealthInsuranceDto;
import insurancetracker.insurancetracker.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class HealthInsuranceServicesTest {
    HealthInsuranceServices healthInsuranceServices;

    @Before
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
        assertEquals("The calculated health insurance premium should match the expected premium.",
                expectedPremium, actualPremium, 0.01);
    }

}
