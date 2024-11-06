package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;

import java.util.Optional;

@Entity(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String Justifications;
    private double total;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "autoInsurance_id", referencedColumnName = "id")
    private AutoInsurance autoInsurance;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "homeInsurance_id", referencedColumnName = "id")
    private HomeInsurance homeInsurance;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "healthInsurance_id", referencedColumnName = "id")
    private HealthInsurance healthInsurance;
    public Contract() {}
    public Contract(String Justifications, AutoInsurance autoInsurance , double total) {
        this.Justifications = Justifications;
        this.autoInsurance = autoInsurance;
        this.total = total;
    }
    public Contract(String Justifications, HomeInsurance homeInsurance , double total) {
        this.Justifications = Justifications;
        this.homeInsurance = homeInsurance;
        this.total = total;
    }
    public Contract(String Justifications, HealthInsurance healthInsurance , double total) {
        this.Justifications = Justifications;
        this.healthInsurance = healthInsurance;
        this.total = total;
    }


    public String getJustifications() {
        return Justifications;
    }
    public void setJustifications(String justifications) {
        Justifications = justifications;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public AutoInsurance getAutoInsurance() {
        return autoInsurance;
    }
    public void setAutoInsurance(AutoInsurance autoInsurance) {
        this.autoInsurance = autoInsurance;
    }
    public HomeInsurance getHomeInsurance() {
        return homeInsurance;
    }
    public void setHomeInsurance(HomeInsurance homeInsurance) {
        this.homeInsurance = homeInsurance;
    }
    public HealthInsurance getHealthInsurance() {
        return healthInsurance;
    }
    public void setHealthInsurance(HealthInsurance healthInsurance) {
        this.healthInsurance = healthInsurance;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
   @Override
    public String toString() {
        return "Contract{" + "Justifications=" + Justifications + '}' + super.toString();
   }
}
