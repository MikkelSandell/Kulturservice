package mikkel.kulturservice.service;

import mikkel.kulturservice.modle.Venue;
import mikkel.kulturservice.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class venueService implements IVenueService{

    private VenueRepository venueRepository;

    public venueService(VenueRepository venueRepository){
        this.venueRepository = venueRepository;
    }

    @Override
    public Set<Venue> findAll() {
        return null;
    }

    @Override
    public Venue save(Venue object) {
        return venueRepository.save(object);
    }

    @Override
    public void delete(Venue object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Venue> findById(Long aLong) {
        return venueRepository.findById(aLong);
    }
}
