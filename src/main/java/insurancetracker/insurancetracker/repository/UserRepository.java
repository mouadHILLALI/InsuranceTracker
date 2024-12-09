package insurancetracker.insurancetracker.repository;

import insurancetracker.insurancetracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
