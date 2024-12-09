package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false , unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AutoInsurance> carInsurance;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HealthInsurance> healthInsurance;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<HomeInsurance> homeInsurances;
    @Transient
    private List<Contract> contracts;
    public User(){}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<AutoInsurance> getCarInsurance() {
        return carInsurance;
    }
    public void setCarInsurance(List<AutoInsurance> carInsurance) {
        this.carInsurance = carInsurance;
    }
    public List<HealthInsurance> getHealthInsurance() {
        return healthInsurance;
    }
    public void setHealthInsurance(List<HealthInsurance> healthInsurance) {
        this.healthInsurance = healthInsurance;
    }
    public List<HomeInsurance> getHomeInsurances() {
        return homeInsurances;
    }
    public List<Contract> getContracts() {
        return contracts;
    }
    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
