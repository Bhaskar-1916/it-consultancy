package com.consultancy;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Kevalam Approved reviews leda Pending reviews thechukodaniki custom logic
    List<Review> findByStatus(String status);
}