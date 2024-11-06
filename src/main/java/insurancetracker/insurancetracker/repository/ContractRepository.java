package insurancetracker.insurancetracker.repository;

import insurancetracker.insurancetracker.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Contract findByAutoInsurance_Id(int insuranceId);
    Contract findByHomeInsurance_Id(int insuranceId);
    Contract findByHealthInsurance_Id(int insuranceId);
}
