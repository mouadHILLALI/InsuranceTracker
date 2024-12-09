package insurancetracker.insurancetracker.repository;

import insurancetracker.insurancetracker.model.AutoInsurance;
import insurancetracker.insurancetracker.model.HealthInsurance;
import insurancetracker.insurancetracker.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    @Query("SELECT a FROM auto_insurances a WHERE a.id = :id")
    AutoInsurance findAutoInsuranceById(@Param("id") int id);
}
