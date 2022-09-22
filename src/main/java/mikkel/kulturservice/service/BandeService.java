package mikkel.kulturservice.service;

import mikkel.kulturservice.modle.Bande;
import mikkel.kulturservice.repository.BandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BandeService implements IBandeService{

    private BandeRepository bandeRepository;

    public BandeService(BandeRepository bandeRepository){
        this.bandeRepository = bandeRepository;
    }
    @Override
    public Set<Bande> findAll() {
        return null;
    }

    @Override
    public Bande save(Bande object) {
        return bandeRepository.save(object);
    }

    @Override
    public void delete(Bande object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Bande> findById(Long aLong) {
        return bandeRepository.findById(aLong);
    }

    @Override
    public List<Bande> findBandeByName(String name) {
        return bandeRepository.findBandeByName(name);
    }
}
