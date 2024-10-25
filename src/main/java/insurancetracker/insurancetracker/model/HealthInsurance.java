package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "health_insurances")
public class HealthInsurance extends Insurance {
    @Column(nullable = false)
    private int age;
    private boolean hasChronicCondition;
    @Column(nullable = false)
    private String CoverageType;
    @OneToOne
    private Contract contract;
    @ManyToOne
    private User user;

    public HealthInsurance() {}

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isHasChronicCondition() {
        return hasChronicCondition;
    }
    public void setHasChronicCondition(boolean hasChronicCondition) {
        this.hasChronicCondition = hasChronicCondition;
    }
    public String getCoverageType() {
        return CoverageType;
    }
    public void setCoverageType(String CoverageType) {
        this.CoverageType = CoverageType;
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
