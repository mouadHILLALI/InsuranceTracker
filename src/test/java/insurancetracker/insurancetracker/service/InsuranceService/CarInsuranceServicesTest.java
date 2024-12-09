package insurancetracker.insurancetracker.service.InsuranceService;

import insurancetracker.insurancetracker.helpers.MonthsCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import insurancetracker.insurancetracker.dtos.CarInsuranceDto;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;

public class CarInsuranceServicesTest {

    private CarInsuranceServices carInsuranceServices;

    @BeforeEach
    public void setUp() {
        carInsuranceServices =  new CarInsuranceServices();
    }

    @Test
    public void calcQoute() {
        CarInsuranceDto carInsuranceDto = new CarInsuranceDto("mouad",  LocalDate.parse("2024-10-10") , LocalDate.parse("2024-11-10"), 45, "standard", false, false);
        try (MockedStatic<MonthsCalculator> mockedCalculator = Mockito.mockStatic(MonthsCalculator.class)) {
            mockedCalculator.when(() -> MonthsCalculator.calculateMonthsBetween(
                    carInsuranceDto.startDate(),
                    carInsuranceDto.endDate()
            )).thenReturn(1);
            double quote = carInsuranceServices.qouteCalc(carInsuranceDto);
            assertNotNull(quote, "Quote should not be null");
            assertEquals(400, quote, "The quote calculation should return 500 for this input");
        }
    }
    @Test
    public void validate(){

    }
}
