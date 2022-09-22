package mikkel.kulturservice.service;

import mikkel.kulturservice.modle.Bande;

import java.util.List;

public interface IBandeService extends ICrudService<Bande,Long>{
    List<Bande> findBandeByName(String name);
}
