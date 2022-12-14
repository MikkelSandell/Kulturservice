package mikkel.kulturservice.controller;

import mikkel.kulturservice.modle.Bande;
import mikkel.kulturservice.service.BandeService;
import mikkel.kulturservice.service.IBandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BandeController {

    private IBandeService bandeService;

    public BandeController(IBandeService bandeService){
        this.bandeService = bandeService;
    }

    @PostMapping("/createBande")
    public ResponseEntity<String> createUser(@RequestBody Bande bande){
        String msg="";
        if(bandeService.save(bande)!=null) {
            msg="Oprettet bande: "+bande.getName();
        }else {
            msg="fejl i oprettelse af " + bande.getName();
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/getBandbyName")
    public ResponseEntity<List<Bande>> getBandByName(String name){
        return new ResponseEntity<>(bandeService.findBandeByName(name), HttpStatus.OK);
    }
}
