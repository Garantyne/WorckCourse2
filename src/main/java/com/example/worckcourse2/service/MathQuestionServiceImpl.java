package com.example.worckcourse2.service;

import com.example.worckcourse2.domain.Question;
import com.example.worckcourse2.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionServiceImpl implements QuestionService{
    @Qualifier("mathJavaQuestionrepository")
    private final QuestionRepository questionRepository;

    public MathQuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        questionRepository.add(new Question(question, answer));
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {
        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(questionRepository.getAll().contains(question)){
            questionRepository.remove(question);
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        int size = questionRepository.getAll().size();
        int item = new Random().nextInt(size);
        int i = 0;
        for(Question question : questionRepository.getAll()) {
            if (i == item)
                return question;
            i++;
        }
        return null;
    }
}
