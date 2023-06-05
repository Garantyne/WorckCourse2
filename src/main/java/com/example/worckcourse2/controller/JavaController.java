package com.example.worckcourse2.controller;

import com.example.worckcourse2.domain.Question;
import com.example.worckcourse2.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/exam/java/add")
    Question addQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionService.add(newQuestion);
        return newQuestion;
    }
    @GetMapping(value = "/exam/java")
    Collection<Question> getQuestions(){
        return questionService.getAll();
    }

    @GetMapping(value = "/exam/java/remove")
    Question removeQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionService.remove(newQuestion);
        return newQuestion;
    }

}
