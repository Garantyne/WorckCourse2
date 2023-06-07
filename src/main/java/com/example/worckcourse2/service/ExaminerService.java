package com.example.worckcourse2.service;

import com.example.worckcourse2.domain.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
