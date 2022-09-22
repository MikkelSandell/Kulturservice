package mikkel.kulturservice.controller;


import mikkel.kulturservice.modle.Bande;
import mikkel.kulturservice.modle.Event;
import mikkel.kulturservice.service.BandeService;
import mikkel.kulturservice.service.EventService;
import mikkel.kulturservice.service.IBandeService;
import mikkel.kulturservice.service.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EventController {

    private IEventService eventService;
    private IBandeService bandeService;

    public EventController(IEventService eventService, IBandeService bandeService){
        this.eventService = eventService;
        this.bandeService = bandeService;
    }

    @PostMapping("/createEvent")
    public ResponseEntity<String> createUser(@RequestBody Event event, @RequestParam Long bandID) {

        Optional<Bande> bande_ = bandeService.findById(bandID);
        if (bande_.isPresent()) {
            event.setBande(bande_.get());
            eventService.save(event);
            return new ResponseEntity<>("ok at oprette event", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("band ikke fundet " + bandID, HttpStatus.OK);
        }
    }

}
