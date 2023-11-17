package com.workandtravel.workandtravelilwl.сontroller;

import com.workandtravel.workandtravelilwl.model.Advice;
import com.workandtravel.workandtravelilwl.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdviceController {

    @Autowired
    private AdviceService adviceService;

    @GetMapping("/advices")
    public ResponseEntity<List<Advice>> getAdvices() {
        return ResponseEntity.ok(adviceService.getAllAdvice());
    }

    @GetMapping("/advice/{id}")
    public ResponseEntity<Advice> getAdvice(@PathVariable Long id) {
        return ResponseEntity.ok(adviceService.getAdviceById(id));
    }

    @PostMapping("/advice/create")
    public ResponseEntity<String> createAdvice(@RequestBody Advice advice) {
        adviceService.createAdvice(advice);
        return ResponseEntity.ok("Успешно сохранен");
    }

    @PutMapping("/advice/update")
    public ResponseEntity<String> updateAdvice(@RequestBody Advice advice) {
        adviceService.createAdvice(advice);
        return ResponseEntity.ok("Успешно изменен");
    }



}
