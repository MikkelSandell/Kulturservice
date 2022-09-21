package mikkel.kulturservice.repository;

import mikkel.kulturservice.modle.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
