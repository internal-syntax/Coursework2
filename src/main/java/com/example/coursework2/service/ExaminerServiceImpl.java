package com.example.coursework2.service;

import com.example.coursework2.Question;
import com.example.coursework2.exception.IncorrectQuestionsAmountException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > javaQuestionService.getAll().size()) {
            throw new IncorrectQuestionsAmountException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(javaQuestionService.getRandomQuestion());
        }
        return questions;
    }
}
