package com.example.worckcourse2.service;

import com.example.worckcourse2.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService{
    public final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> res = new HashSet<>();
        while(res.size() != amount){
            res.add(questionService.getRandomQuestion());
        }

        return res;
    }
}
