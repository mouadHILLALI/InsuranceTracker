package insurancetracker.insurancetracker.repository;

import insurancetracker.insurancetracker.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    void deleteById(int id);
}
