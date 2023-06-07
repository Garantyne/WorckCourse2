package com.example.worckcourse2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.example.worckcourse2.domain.Question;
import com.example.worckcourse2.service.ExaminerService;
import com.example.worckcourse2.service.ExaminerServiceImpl;
import com.example.worckcourse2.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {


    @Mock
    private QuestionService questionService;

    @Test
    public void testGetQuestions() {
        ExaminerService examinerService = new ExaminerServiceImpl(questionService);

        Question question1 = new Question("What is the capital of France?","Paris");
        Question question2 = new Question("What is the capital of Germany?","Berlin");
        Question question3 = new Question("What is the capital of Italy?","Rome");
        Set<Question> questionSet = new HashSet<>();
        questionSet.add(question1);
        questionSet.add(question2);
        questionSet.add(question3);

        when(questionService.getRandomQuestion()).thenReturn(question1, question2, question3);

        Collection<Question> questions = examinerService.getQuestions(3);

        assertEquals(questionSet, questions);

        verify(questionService, times(3)).getRandomQuestion();
    }
}