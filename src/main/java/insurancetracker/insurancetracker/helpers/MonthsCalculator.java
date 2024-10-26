package insurancetracker.insurancetracker.helpers;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class MonthsCalculator {

    public static int calculateMonthsBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Both startDate and endDate must be provided");
        }

        return (int) ChronoUnit.MONTHS.between(startDate, endDate);
    }
}
