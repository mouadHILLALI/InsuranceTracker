package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "insurances")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int policyNumber;
    @Column(nullable = false)
    protected String PolicyHolderName;
    protected LocalDate startDate;
    protected LocalDate endDate;

    protected Insurance(){}

    protected int getPolicyNumber() {
        return policyNumber;
    }
    protected void setPolicyNumber(int policyNumber) {
        policyNumber = policyNumber;
    }
    protected String getPolicyHolderName() {
        return PolicyHolderName;
    }
    protected void setPolicyHolderName(String policyHolderName) {
        PolicyHolderName = policyHolderName;
    }
    protected LocalDate getStartDate() {
        return startDate;
    }
    protected void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    protected LocalDate getEndDate() {
        return endDate;
    }
    protected void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
