package insurancetracker.insurancetracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

@Entity(name = "home_insurances")
public class HomeInsurance extends Insurance {
    @Column(nullable = false)
    private double PropertyValue;
    private boolean isHouse;
    private boolean hasSecuritySystem;
    private boolean isInRiskZone;
    @OneToOne
    private Contract contract;
    @ManyToOne
    private User user;
    public HomeInsurance() {}

    public double getPropertyValue() {
        return PropertyValue;
    }
    public void setPropertyValue(double PropertyValue) {
        this.PropertyValue = PropertyValue;
    }
    public boolean getIsHouse() {
        return isHouse;
    }
    public void setIsHouse(boolean isHouse) {
        this.isHouse = isHouse;
    }
    public boolean getHasSecuritySystem() {
        return hasSecuritySystem;
    }
    public void setHasSecuritySystem(boolean hasSecuritySystem) {
        this.hasSecuritySystem = hasSecuritySystem;
    }
    public boolean getIsInRiskZone() {
        return isInRiskZone;
    }
    public void setIsInRiskZone(boolean isInRiskZone) {
        this.isInRiskZone = isInRiskZone;
    }
    public Contract getContract() {
        return contract;
    }
    public void setContract(Contract contract) {
        this.contract = contract;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String getPolicyHolderName(){
        return super.getPolicyHolderName();
    }
    @Override
    public void setPolicyHolderName(String policyHolderName){
        super.setPolicyHolderName(PolicyHolderName);
    }
    @Override
    public int getPolicyNumber(){
        return super.getPolicyNumber();
    }
    @Override
    public void setPolicyNumber(int policyNumber){
        super.setPolicyNumber(policyNumber);
    }
    @Override
    public LocalDate getStartDate() {
        return super.getStartDate();
    }
    @Override
    public void setStartDate(LocalDate startDate) {
        super.setStartDate(startDate);
    }
    @Override
    public LocalDate getEndDate() {
        return super.getEndDate();
    }
    @Override
    public void setEndDate(LocalDate endDate) {
        super.setEndDate(endDate);
    }
}

