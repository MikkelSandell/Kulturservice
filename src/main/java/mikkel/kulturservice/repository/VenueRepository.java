package mikkel.kulturservice.repository;

import mikkel.kulturservice.modle.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue,Long> {
}
