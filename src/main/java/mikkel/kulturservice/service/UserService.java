package mikkel.kulturservice.service;

import mikkel.kulturservice.config.SecurityConfiguration;
import mikkel.kulturservice.modle.User;
import mikkel.kulturservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service  // gør at Spring "ser" denne klasse
public class UserService implements IUserService{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    /*@Override
    public User save(User object) {
        return userRepository.save(object);
    }
*/
    @Override
    public User save(User user) {
        PasswordEncoder pw = SecurityConfiguration.passwordEncoder();
        user.setPassword(pw.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public void delete(User object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<User> findById(Long aLong) {
        return userRepository.findById(aLong);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public List<User> findByName(String name) {
        System.out.println("Userservice called findByName with argument: " + name);
        return userRepository.findByUsername(name);
    }

    @Override
    public void update(User userToUpdate) {
        userRepository.save(userToUpdate);
    }
}