package insurancetracker.insurancetracker.dtos;

import insurancetracker.insurancetracker.model.User;


import java.time.LocalDate;

public record HealthInsuranceDto(String PolicyHolderName , LocalDate startDate , LocalDate endDate , int age , String coverageType , boolean hasChronic  , User user) {
    public String getPolicyHolderName() {
        return PolicyHolderName;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
       return endDate;
    }
    public int getAge() {
        return age;
    }
    public String getCoverageType() {
        return coverageType;
    }
    public boolean getHasChronic() {
        return hasChronic;
    }
    public User getUser() {
        return user;
    }
}
