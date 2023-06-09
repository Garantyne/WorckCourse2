package com.example.worckcourse2.controller;

import com.example.worckcourse2.domain.Question;
import com.example.worckcourse2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
@RequestMapping
public class MathQuestionController {
    @Qualifier("mathQuestionServiceImpl")
    private final QuestionService questionService;

    public MathQuestionController( @Qualifier("mathQuestionServiceImpl")QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "/exam/math/add")
    Question addQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionService.add(newQuestion);
        return newQuestion;
    }
    @GetMapping(value = "/exam/math")
    Collection<Question> getQuestions(){
        return questionService.getAll();
    }

    @GetMapping(value = "/exam/math/remove")
    Question removeQuestion(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questionService.remove(newQuestion);
        return newQuestion;
    }
}
