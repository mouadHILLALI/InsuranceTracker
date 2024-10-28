package insurancetracker.insurancetracker.service.InsuranceService;

import static org.junit.Assert.assertNotNull;
import org.junit.Before;


import insurancetracker.insurancetracker.service.InsuranceService.CarInsuranceServices;
import insurancetracker.insurancetracker.dtos.CarInsuranceDto;
import org.junit.Test;

import java.time.LocalDate;

public class CarInsuranceServicesTest {

    private CarInsuranceServices carInsuranceServices;

    @Before
    public void setUp() {
        carInsuranceServices = new CarInsuranceServices();
    }

    @Test
    public void calcQoute() {
        CarInsuranceDto carInsuranceDto = new CarInsuranceDto("mouad", LocalDate.EPOCH, LocalDate.now(), 45, "lux", true, true);
        double quote = carInsuranceServices.qouteCalc(carInsuranceDto);
        assertNotNull(quote);
    }
}
