package insurancetracker.insurancetracker.repository;

import insurancetracker.insurancetracker.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query("SELECT c FROM contracts c WHERE c.autoInsurance.id = :autoInsuranceId")
    Contract findByAutoInsuranceId(@Param("autoInsuranceId") int autoInsuranceId);

    Contract findByHealthInsurance_Id(int healthInsuranceId);
    Contract findByHomeInsurance_Id(int insuranceId);
}
