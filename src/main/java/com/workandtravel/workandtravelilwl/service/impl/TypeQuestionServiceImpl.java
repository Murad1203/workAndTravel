package com.workandtravel.workandtravelilwl.service.impl;

import com.workandtravel.workandtravelilwl.model.TypeQuestion;
import com.workandtravel.workandtravelilwl.repository.TypeQuestionRepository;
import com.workandtravel.workandtravelilwl.service.TypeQuestionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeQuestionServiceImpl implements TypeQuestionService {

    @Autowired
    private TypeQuestionRepository typeQuestionRepository;

    @Override
    public List<TypeQuestion> getAllTypeQuestions() {
        return typeQuestionRepository.findAll();
    }

    @Override
    public TypeQuestion getTypeQuestionById(Long id) {
        return typeQuestionRepository.findById(id).orElse(null);
    }

    @Override
    public void createTypeQuestion(TypeQuestion typeQuestion) {
        typeQuestionRepository.save(typeQuestion);
    }

    @Override
    public void updateTypeQuestion(Long id, TypeQuestion typeQuestion) {
        TypeQuestion typeQuestion1 = typeQuestionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Объект не найден с id: " + id));

        typeQuestion1.setTypeQuestion(typeQuestion.getTypeQuestion());
    }

    @Override
    public void deleteTypeQuestionById(Long id) {
        typeQuestionRepository.deleteById(id);
    }
}
