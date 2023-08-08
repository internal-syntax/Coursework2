package com.example.coursework2.service;

import com.example.coursework2.exception.IncorrectQuestionsAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.coursework2.service.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowIncorrectQuestionsAmountException() {
        when(javaQuestionService.getAll()).thenReturn(MOCK_QUESTION);

        assertThatExceptionOfType(IncorrectQuestionsAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
        assertThatExceptionOfType(IncorrectQuestionsAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(MOCK_QUESTION.size() + 1));
    }

    @Test
    public void shouldReturnQuestions() {
        when(javaQuestionService.getAll()).thenReturn(MOCK_QUESTION);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                QUESTION_1,
                QUESTION_2,
                QUESTION_3,
                QUESTION_4);

        int questionAmount = MOCK_QUESTION.size() - 2;

        assertThat(examinerService.getQuestions(questionAmount))
                .hasSize(questionAmount);
    }
}