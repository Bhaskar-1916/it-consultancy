package com.consultancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    // 1. User review add chesinappudu save cheyadaniki (Default PENDING)
    @PostMapping("/save")
    public Review saveReview(@RequestBody Review review) {
        review.setStatus("PENDING");
        return reviewRepository.save(review);
    }

    // 2. Admin page lo motham reviews chupinchadaniki
    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // 3. User page (Review.html) lo kevalam APPROVED vi chupinchadaniki
    @GetMapping("/approved")
    public List<Review> getApprovedReviews() {
        return reviewRepository.findByStatus("APPROVED");
    }

    // 4. Admin approve button nokkinappudu status marchadaniki
    @PutMapping("/{id}/approve")
    public Review approveReview(@PathVariable Long id) {
        Review review = reviewRepository.findById(id).orElseThrow();
        review.setStatus("APPROVED");
        return reviewRepository.save(review);
    }

    // 5. Admin reject button nokkithe database nunchi delete cheyadaniki
    @DeleteMapping("/{id}/reject")
    public void rejectReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
    }
}