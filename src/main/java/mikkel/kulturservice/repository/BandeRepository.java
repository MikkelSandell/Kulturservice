package mikkel.kulturservice.repository;

import mikkel.kulturservice.modle.Bande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BandeRepository extends JpaRepository<Bande,Long> {

    List<Bande> findBandeByName(String name);
}
