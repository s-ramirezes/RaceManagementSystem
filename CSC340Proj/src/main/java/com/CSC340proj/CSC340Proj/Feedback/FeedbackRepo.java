package com.CSC340proj.CSC340Proj.Feedback;

import com.CSC340proj.CSC340Proj.Feedback.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
    // Basic CRUD methods are automatically provided
}