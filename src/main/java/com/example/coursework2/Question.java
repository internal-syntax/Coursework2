package com.example.coursework2;

import java.util.Objects;

public class Question {

    private final String questions;
    private final String answer;

    public Question(String questions, String answer) {
        this.questions = questions;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestions() {
        return questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questions, question.questions) && Objects.equals(answer, question.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questions, answer);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questions='" + questions + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
