package insurancetracker.insurancetracker.dtos;

import insurancetracker.insurancetracker.model.User;

import java.time.LocalDate;

public record HomeInsuranceDto(String policyHolderName , LocalDate startDate , LocalDate endDate , double propertyValue,
                              boolean isHous , boolean hasSecurity , boolean isInRisk , User user) {
    public String getPolicyHolderName() {
        return policyHolderName;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public double getPropertyValue() {
        return propertyValue;
    }
    public boolean getisHous() {
        return isHous;
    }
    public boolean getHasSecurity() {
        return hasSecurity;
    }
    public boolean getisInRisk() {
        return isInRisk;
    }
    public User getUser() {
        return user;
    }
}
