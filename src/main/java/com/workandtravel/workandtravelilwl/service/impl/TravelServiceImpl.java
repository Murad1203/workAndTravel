package com.workandtravel.workandtravelilwl.service.impl;

import com.workandtravel.workandtravelilwl.model.Travel;
import com.workandtravel.workandtravelilwl.repository.TravelRepository;
import com.workandtravel.workandtravelilwl.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Override
    public List<Travel> getAllTravel() {
        return travelRepository.findAll();
    }

    @Override
    public Travel getTravelById(Long id) {
        return travelRepository.findById(id).orElse(null);
    }

    @Override
    public void createTravel(Travel travel) {
        travelRepository.save(travel);
    }

    @Override
    public void updateTravel(Long id) {

    }

    @Override
    public void deleteTravelById(Long id) {
        travelRepository.deleteById(id);
    }
}
