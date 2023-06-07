package com.example.worckcourse2.service;

import com.example.worckcourse2.domain.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    private final Set<Question> chtoGdeKogda = new HashSet<>();

    @Override
    public Question add(String question, String answer) {

        chtoGdeKogda.add(new Question(question,answer));
        return new Question(question,answer);
    }

    @Override
    public Question add(Question question) {
        chtoGdeKogda.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(chtoGdeKogda.contains(question)){
            chtoGdeKogda.remove(question);
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return chtoGdeKogda;
    }

    @Override
    public Question getRandomQuestion() {
        int size = chtoGdeKogda.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for(Question question : chtoGdeKogda) {
            if (i == item)
                return question;
            i++;
        }
        return null;
    }
}

