package insurancetracker.insurancetracker.model;

import jakarta.persistence.*;

@Entity(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String Justifications;
    @OneToOne(cascade = CascadeType.ALL)
    private Insurance insurance;
    public Contract() {}

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


}
