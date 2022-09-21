package mikkel.kulturservice.controller;

import mikkel.kulturservice.modle.Event;
import mikkel.kulturservice.modle.Review;
import mikkel.kulturservice.modle.User;
import mikkel.kulturservice.service.IEventService;
import mikkel.kulturservice.service.IReviewSerice;
import mikkel.kulturservice.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReviewContoller {

    private IReviewSerice reviewSerice;
    private IEventService eventService;
    private IUserService userService;

    public ReviewContoller(IReviewSerice reviewSerice, IEventService eventService, IUserService userService) {
        this.reviewSerice = reviewSerice;
        this.eventService = eventService;
        this.userService = userService;
    }

    @PostMapping("/createReviw")
    public ResponseEntity<String> createUser(@RequestBody Review review, @RequestParam Long eventID, @RequestParam Long userID) {

        Optional<Event> event_ = eventService.findById(eventID);
        Optional<User> user_ = userService.findById(userID);
        if (event_.isPresent() && user_.isPresent()) {
            review.setEvent(event_.get());
            review.setUser(user_.get());
            reviewSerice.save(review);
            return new ResponseEntity<>("ok at oprette review", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("event og user ikke fundet " + eventID + userID, HttpStatus.OK);
        }
    }
}
