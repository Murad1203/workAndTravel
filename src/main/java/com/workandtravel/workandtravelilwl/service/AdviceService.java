package com.workandtravel.workandtravelilwl.service;

import com.workandtravel.workandtravelilwl.model.Advice;
import com.workandtravel.workandtravelilwl.model.Travel;

import java.util.List;

public interface AdviceService {
    List<Advice> getAllAdvice();
    Advice getAdviceById(Long id);
    void createAdvice(Advice advice);
    void updateAdvice(Long id);
    void deleteAdviceById(Long id);
}
