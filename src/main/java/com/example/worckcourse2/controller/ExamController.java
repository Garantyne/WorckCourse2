package com.example.worckcourse2.controller;

import com.example.worckcourse2.exceptions.SetSizeException;
import com.example.worckcourse2.service.ExaminerService;
import com.example.worckcourse2.service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {
    public final ExaminerService  examinerService;
    public final JavaQuestionService javaQuestionService;

    public ExamController(ExaminerService examinerService, JavaQuestionService javaQuestionService) {
        this.examinerService = examinerService;
        this.javaQuestionService = javaQuestionService;
    }
    @GetMapping(value = "/exam/get")
    public String getQuestions(@RequestParam("amount") int amount) {
        if(amount > javaQuestionService.getAll().size() ){
            throw new SetSizeException(javaQuestionService.getAll(), amount);
        }
        return examinerService.getQuestions(amount).toString();
    }
}
