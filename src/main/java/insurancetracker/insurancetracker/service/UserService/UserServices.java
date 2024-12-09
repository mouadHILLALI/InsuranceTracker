package insurancetracker.insurancetracker.service.UserService;

import insurancetracker.insurancetracker.model.Contract;
import insurancetracker.insurancetracker.model.Insurance;
import insurancetracker.insurancetracker.model.User;
import insurancetracker.insurancetracker.repository.ContractRepository;
import insurancetracker.insurancetracker.repository.InsuranceRepository;
import insurancetracker.insurancetracker.repository.UserRepository;
import insurancetracker.insurancetracker.utils.PasswordUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private PasswordUtils passwordUtils;


    public User Login(String email, String password) {
        try {
            String hashedPass = PasswordUtils.hashPassword(password);
            User user = userRepository.findByEmail(email);
            if (user.getPassword().equals(hashedPass)) {
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public User Register(User user) {
        try {
            user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
            return userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public User updateUser(User user) {
        User updatedUser = new User();
        try {
            updatedUser = userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updatedUser;
    }
   public long getTotalContracts(User user) {
        try {
            List<Contract> contracts = contractRepository.findAll();
            return contracts.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
   }
   public double totalPremium(User user) {
        try {
            List<Contract> contracts = contractRepository.findAll();
            return contracts.stream()
                    .mapToDouble(contract -> contract.getTotal())
                    .sum();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
   }
   public int activeInsurance(User user) {
        try {
            return  user.getCarInsurance().size() + user.getHomeInsurances().size() + user.getHealthInsurance().size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
   }
   public boolean validator(User user) {
        if (user.getPassword()!=null && user.getPassword().length()>0 && !user.getName().isEmpty()&& !user.getName().isEmpty()&&!user.getAddress().isEmpty()&&!user.getPhone().isEmpty()) {
            return true;
        }
        return false;
   }
}
