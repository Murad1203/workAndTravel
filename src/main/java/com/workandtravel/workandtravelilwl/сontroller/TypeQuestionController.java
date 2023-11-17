package com.workandtravel.workandtravelilwl.сontroller;

import com.workandtravel.workandtravelilwl.model.TypeQuestion;
import com.workandtravel.workandtravelilwl.service.TypeQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TypeQuestionController {

    @Autowired
    private TypeQuestionService typeQuestionService;

    @GetMapping("/type_questions")
    public ResponseEntity<List<TypeQuestion>> getAllTypesQuestions() {
        return ResponseEntity.ok(typeQuestionService.getAllTypeQuestions());
    }

    @GetMapping("/type_question/{id}")
    public ResponseEntity<TypeQuestion> getTypeQuestion(@PathVariable Long id) {
        return ResponseEntity.ok(typeQuestionService.getTypeQuestionById(id));
    }

    @PostMapping("/type_question/create")
    public ResponseEntity<String> createTypeQuestion(@RequestBody TypeQuestion typeQuestion) {
        typeQuestionService.createTypeQuestion(typeQuestion);
        return ResponseEntity.ok("Успешно создан");
    }

    @PutMapping("/type_question/update/{id}")
    public ResponseEntity<String> updateTypeQuestion(
            @RequestBody TypeQuestion typeQuestion,
            @PathVariable Long id) {


        return ResponseEntity.ok("Объект успешно изменен!");
    }

    @DeleteMapping("/type_question/{id}")
    public ResponseEntity<String> deleteTypeQuestion(@PathVariable Long id) {
        typeQuestionService.deleteTypeQuestionById(id);
        return ResponseEntity.ok("Объект успешно удален!");
    }

}
