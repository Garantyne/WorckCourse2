package com.example.worckcourse2;

import com.example.worckcourse2.domain.Question;
import com.example.worckcourse2.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
        javaQuestionService = new JavaQuestionService();
    }
    @Test
    public void add(){
        Question testResult = javaQuestionService.add("qwer","rewq");
        Question actual = new Question("qwer", "rewq");
        assertEquals(testResult, actual);
        Question testResult2 = javaQuestionService.add(new Question("qwer", "rewq"));
        assertEquals(testResult2, actual);
    }


    @Test
    void addNewQuestion() {
        Question addedQuestion = javaQuestionService.add("What is Java?", "Java is a programming language.");
        assertNotNull(addedQuestion);
        assertEquals("What is Java?", addedQuestion.getQuestion());
        assertEquals("Java is a programming language.", addedQuestion.getAnswer());
        assertTrue(javaQuestionService.getAll().contains(addedQuestion));
    }

    @Test
    void addExistingQuestion() {
        Question question = new Question("What is Java?", "Java is a programming language.");
        assertFalse(javaQuestionService.getAll().contains(question));

        Question addedQuestion = javaQuestionService.add(question);
        assertNotNull(addedQuestion);
        assertEquals("What is Java?", addedQuestion.getQuestion());
        assertEquals("Java is a programming language.", addedQuestion.getAnswer());
        assertTrue(javaQuestionService.getAll().contains(addedQuestion));
    }

    @Test
    void removeExistingQuestion() {
        Question question = new Question("What is Java?", "Java is a programming language.");
        javaQuestionService.add(question);
        Question removedQuestion = javaQuestionService.remove(question);
        assertNotNull(removedQuestion);
        assertEquals("What is Java?", removedQuestion.getQuestion());
        assertEquals("Java is a programming language.", removedQuestion.getAnswer());
        assertFalse(javaQuestionService.getAll().contains(removedQuestion));
    }


    @Test
    void getAllQuestions() {
        Question question1 = new Question("What is Java?", "Java is a programming language.");
        Question question2 = new Question("What is a class?", "A class is a blueprint for objects.");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        assertTrue(javaQuestionService.getAll().contains(question1));
        assertTrue(javaQuestionService.getAll().contains(question2));
    }

    @Test
    void getRandomQuestion() {
        Question question1 = new Question("What is Java?", "Java is a programming language.");
        Question question2 = new Question("What is a class?", "A class is a blueprint for objects.");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        Question randomQuestion = javaQuestionService.getRandomQuestion();
        assertNotNull(randomQuestion);
        assertTrue(javaQuestionService.getAll().contains(randomQuestion));
    }
}


