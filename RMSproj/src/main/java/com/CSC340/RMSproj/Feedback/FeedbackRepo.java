package com.CSC340.RMSproj.Feedback;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
    List<Feedback> findAllByOrderByDateFieldAsc();
}