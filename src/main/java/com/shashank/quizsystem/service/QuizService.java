package com.shashank.quizsystem.service;

import com.shashank.quizsystem.entity.Quiz;
import com.shashank.quizsystem.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public String addQuiz(Quiz quiz) {

        quizRepository.save(quiz);

        return "Quiz Added Successfully";
    }

    public List<Quiz> getAllQuizzes() {

        return quizRepository.findAll();
    }
    public String updateQuiz(Long id, Quiz updatedQuiz) {

        Quiz quiz = quizRepository.findById(id).orElse(null);

        if(quiz != null) {

            quiz.setTitle(updatedQuiz.getTitle());
            quiz.setQuestions(updatedQuiz.getQuestions());

            quizRepository.save(quiz);

            return "Quiz Updated Successfully";
        }

        return "Quiz Not Found";
    }
    public String deleteQuiz(Long id) {

        quizRepository.deleteById(id);

        return "Quiz Deleted Successfully";
    }
    public Quiz getQuizById(Long id) {

        return quizRepository.findById(id).orElse(null);
    }
}