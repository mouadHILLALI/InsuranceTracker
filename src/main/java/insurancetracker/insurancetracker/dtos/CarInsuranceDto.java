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
) {
    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public boolean getisProfessional() {
        return isProfessional;
    }

    public boolean gethasAccidents() {
        return hasAccidents;
    }
}
