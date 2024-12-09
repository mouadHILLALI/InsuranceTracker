package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "auto_insurances")
public class AutoInsurance extends Insurance {
    @Column(nullable = false)
    private int DriverAge;
    @Column(nullable = false)
    private String VehiculeType;
    private boolean isProfessionalUse;
    private boolean hasAccidents;
    @ManyToOne
    private User user;
    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Contract contract;
    public AutoInsurance() {}
    public AutoInsurance(String policyHolderName, LocalDate startDate, LocalDate endDate,
                         int driverAge, String VehiculeType, boolean isProfessionalUse,
                         boolean hasAccidents, User user) {
        this.PolicyHolderName = policyHolderName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.DriverAge = driverAge;
        this.VehiculeType = VehiculeType;
        this.isProfessionalUse = isProfessionalUse;
        this.hasAccidents = hasAccidents;
        this.user = user;
        this.contract = contract;
    }

    public int getDriverAge() {
        return DriverAge;
    }
    public void setDriverAge(int DriverAge) {
        this.DriverAge = DriverAge;
    }
    public String getVehiculeType() {
        return VehiculeType;
    }
    public void setVehiculeType(String VehiculeType) {
        this.VehiculeType = VehiculeType;
    }
    public boolean getIsProfessionalUse() {
        return isProfessionalUse;
    }
    public void setProfessionalUse(boolean professionalUse) {
        isProfessionalUse = professionalUse;
    }
    public boolean getHasAccidents() {
        return hasAccidents;
    }
    public void setHasAccidents(boolean hasAccidents) {
        this.hasAccidents = hasAccidents;
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
    public int getId(){
        return super.getId();
    }
    @Override
    public void setId(int id){
        super.setId(id);
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
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Contract getContract() {
        return contract;
    }
    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
