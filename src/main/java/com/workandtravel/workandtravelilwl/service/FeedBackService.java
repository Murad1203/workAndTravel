package com.workandtravel.workandtravelilwl.service;

import com.workandtravel.workandtravelilwl.model.Feedback;

import java.util.List;

public interface FeedBackService {
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(Long id);
    void createFeedback(Feedback feedback);
    void updateFeedback(Long id);
    void deleteFeedbackById(Long id);
}
