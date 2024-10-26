package insurancetracker.insurancetracker.dtos;

import java.time.LocalDate;

public record CarInsuranceDto(
        String policyHolderName,
        LocalDate startDate,
        LocalDate endDate,
        int driverAge,
        String vehicleType,
        boolean isProfessional,
        boolean hasAccidents
) { }
