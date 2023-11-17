package com.workandtravel.workandtravelilwl.service.impl;

import com.workandtravel.workandtravelilwl.model.Feedback;
import com.workandtravel.workandtravelilwl.repository.FeedBackRepository;
import com.workandtravel.workandtravelilwl.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedBackRepository.findAll();
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedBackRepository.findById(id).orElse(null);
    }

    @Override
    public void createFeedback(Feedback feedback) {
        feedBackRepository.save(feedback);
    }

    @Override
    public void updateFeedback(Long id) {

    }

    @Override
    public void deleteFeedbackById(Long id) {
        feedBackRepository.deleteById(id);
    }
}
