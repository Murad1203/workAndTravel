package com.workandtravel.workandtravelilwl.service.impl;

import com.workandtravel.workandtravelilwl.model.Favor;
import com.workandtravel.workandtravelilwl.repository.FavorRepository;
import com.workandtravel.workandtravelilwl.service.FavorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("FavorService")
public class ServiceServiceImpl implements FavorService {

    @Autowired
    private FavorRepository serviceRepository;

    @Override
    public List<Favor> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Favor getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void createService(Favor service) {
        serviceRepository.save(service);
    }

    @Override
    public void updateServiceById(Favor favor, Long id) {
        Favor favor1 = serviceRepository.findById(id)
                .orElseThrow(() ->  new EntityNotFoundException("Object not found with id: " + id));

        
    }
    @Override
    public void deleteServiceById(Long id) {
        serviceRepository.deleteById(id);
    }
}
