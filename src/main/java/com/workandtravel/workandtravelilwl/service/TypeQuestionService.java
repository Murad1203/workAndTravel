package com.workandtravel.workandtravelilwl.service;

import com.workandtravel.workandtravelilwl.model.TypeQuestion;

import java.util.List;

public interface TypeQuestionService {
    List<TypeQuestion> getAllTypeQuestions();
    TypeQuestion getTypeQuestionById(Long id);
    void createTypeQuestion(TypeQuestion typeQuestion);

    void updateTypeQuestion(Long id, TypeQuestion typeQuestion);

    void deleteTypeQuestionById(Long id);
}
