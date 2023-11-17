package com.workandtravel.workandtravelilwl.service;


import com.workandtravel.workandtravelilwl.model.Travel;

import java.util.List;

public interface TravelService {
    List<Travel> getAllTravel();
    Travel getTravelById(Long id);
    void createTravel(Travel travel);
    void updateTravel(Long id);
    void deleteTravelById(Long id);
}
