package com.example.worckcourse2.repository;

import com.example.worckcourse2.domain.Question;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class MathJavaQuestionRepository implements QuestionRepository{
    private Set<Question> questions = new HashSet<>();

    @PostConstruct
    public  void init(){
        questions.add(new Question("first question", "first answer"));
        questions.add(new Question("two question", "two answer"));
        questions.add(new Question("three question", "three answer"));
        questions.add(new Question("for question", "for answer"));
        questions.add(new Question("five question", "five answer"));
    }

    @PreDestroy
    public void destr(){
        questions.clear();
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(questions.contains(question)){
            questions.remove(question);
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
