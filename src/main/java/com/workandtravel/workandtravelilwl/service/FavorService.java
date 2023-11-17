package com.workandtravel.workandtravelilwl.service;



import com.workandtravel.workandtravelilwl.model.Favor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavorService {
    List<Favor> getAllServices();
    Favor getServiceById(Long id);
    void createService(Favor service);
    void updateServiceById(Favor favor, Long id);

    void deleteServiceById(Long id);
}
