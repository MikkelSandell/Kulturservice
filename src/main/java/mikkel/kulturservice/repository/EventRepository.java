package mikkel.kulturservice.repository;

import mikkel.kulturservice.modle.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
