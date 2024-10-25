package insurancetracker.insurancetracker.service.UserService;

import insurancetracker.insurancetracker.model.User;
import insurancetracker.insurancetracker.repository.UserRepository;
import insurancetracker.insurancetracker.utils.PasswordUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServices {

    @Autowired
    private UserRepository userRepository;

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
}
