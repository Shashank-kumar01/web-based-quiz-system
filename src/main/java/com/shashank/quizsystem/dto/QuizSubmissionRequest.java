package com.shashank.quizsystem.dto;

import java.util.Map;

public class QuizSubmissionRequest {

    private String userName;

    private Long quizId;

    private Map<Long, String> answers;

    public QuizSubmissionRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public Map<Long, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, String> answers) {
        this.answers = answers;
    }
}