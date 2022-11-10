package mikkel.kulturservice.repository;

import mikkel.kulturservice.modle.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findUserByName(String name);

    List<User> findByUsername(String name);
}
