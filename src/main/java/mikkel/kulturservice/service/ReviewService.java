package mikkel.kulturservice.service;


import mikkel.kulturservice.modle.Event;
import mikkel.kulturservice.modle.Review;
import mikkel.kulturservice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


@Service
public class ReviewService implements IReviewSerice{

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Set<Review> findAll() {
        return null;
    }

    @Override
    public Review save(Review object) {
        return reviewRepository.save(object);
    }

    @Override
    public void delete(Review object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return Optional.empty();
    }
}
