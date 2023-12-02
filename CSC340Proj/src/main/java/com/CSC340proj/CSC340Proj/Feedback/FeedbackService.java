package com.CSC340proj.CSC340Proj.Feedback;

import com.CSC340proj.CSC340Proj.Feedback.Feedback;
import com.CSC340proj.CSC340Proj.Feedback.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
        feedbackRepo.save(feedback);
    }
}