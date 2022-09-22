package mikkel.kulturservice.controller;

import mikkel.kulturservice.modle.Bande;
import mikkel.kulturservice.modle.User;
import mikkel.kulturservice.modle.Venue;
import mikkel.kulturservice.service.IBandeService;
import mikkel.kulturservice.service.IUserService;
import mikkel.kulturservice.service.IVenueService;
import mikkel.kulturservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private IUserService userService;
    private IVenueService venueService;

    private IBandeService bandeService;

    public UserController(IUserService userService, IVenueService venueService, IBandeService bandeService) {
        this.userService = userService;
        this.venueService = venueService;
        this.bandeService = bandeService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/findUserByName")
    public ResponseEntity<List<User>> getUserByName(String name){
        return new ResponseEntity<>(userService.findUserByName(name),HttpStatus.OK);
    }

    @PostMapping("/createLike")
    public ResponseEntity<String> createLike(@RequestParam Long userID, @RequestParam Long venueID){

        Optional<User> user_ = userService.findById(userID);
        Optional<Venue> venue_ = venueService.findById(venueID);
        if (user_.isPresent() && venue_.isPresent()){
            user_.get().getVenuesLiked().add(venue_.get());
            userService.save(user_.get());
            return new ResponseEntity<>("ok at gamme user: " + userID + " med like venue " + venueID, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("fejl at oprette like", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/createLikeForBands")
    public ResponseEntity<String> createLikeForBands(@RequestParam Long userID, @RequestParam Long bandID){

        Optional<User> user_ = userService.findById(userID);
        Optional<Bande> band_ = bandeService.findById(bandID);
        if (user_.isPresent() && band_.isPresent()){
            user_.get().getBandesLiked().add(band_.get());
            userService.save(user_.get());
            return new ResponseEntity<>("ok at gamme user: " + userID + " med like band " + bandID, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("fejl at oprette like", HttpStatus.BAD_REQUEST);
        }
    }
}