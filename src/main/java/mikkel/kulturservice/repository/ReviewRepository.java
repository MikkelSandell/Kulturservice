package mikkel.kulturservice.repository;

import mikkel.kulturservice.modle.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
