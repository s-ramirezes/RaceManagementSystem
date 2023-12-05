package com.CSC340.RMSproj.Feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepo feedbackRepo;

    public List<Feedback> getAllFeedback() {
        return feedbackRepo.findAll();
    }

    public void saveFeedback(Feedback feedback) {
        // Save the new feedback
        feedbackRepo.save(feedback);

        // Check the count of feedback entries
        long count = feedbackRepo.count();
        if (count > 5) {
            removeOldestFeedback();
        }
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        feedback.setSubmittedByUsername(currentUsername); // Set the username before saving
        feedbackRepo.save(feedback);
    }

    private void removeOldestFeedback() {
        // Assuming 'Feedback' entity has a date or timestamp field to find the oldest
        List<Feedback> feedbacks = feedbackRepo.findAllByOrderByDateFieldAsc();
        if (!feedbacks.isEmpty()) {
            Feedback oldestFeedback = feedbacks.get(0);
            feedbackRepo.delete(oldestFeedback);
        }
    }
}