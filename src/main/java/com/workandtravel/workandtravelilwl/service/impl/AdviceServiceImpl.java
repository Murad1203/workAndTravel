package com.workandtravel.workandtravelilwl.service.impl;

import com.workandtravel.workandtravelilwl.model.Advice;
import com.workandtravel.workandtravelilwl.repository.AdviceRepository;
import com.workandtravel.workandtravelilwl.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    private AdviceRepository adviceRepository;

    @Override
    public List<Advice> getAllAdvice() {
        return adviceRepository.findAll();
    }

    @Override
    public Advice getAdviceById(Long id) {
        return adviceRepository.findById(id).orElse(null);
    }

    @Override
    public void createAdvice(Advice advice) {
        adviceRepository.save(advice);
    }

    @Override
    public void updateAdvice(Long id) {

    }

    @Override
    public void deleteAdviceById(Long id) {
        adviceRepository.deleteById(id);
    }
}
