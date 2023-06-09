package com.example.worckcourse2.repository;

import com.example.worckcourse2.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);
    Collection<Question> getAll();
}
