package com.shashank.quizsystem.controller;

import com.shashank.quizsystem.entity.Quiz;
import com.shashank.quizsystem.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/addQuiz")
    public String addQuiz(@RequestBody Quiz quiz) {

        return quizService.addQuiz(quiz);
    }

    @GetMapping("/quizzes")
    public List<Quiz> getAllQuizzes() {

        return quizService.getAllQuizzes();
    }
    @PutMapping("/quiz/{id}")
    public String updateQuiz(@PathVariable Long id,
                             @RequestBody Quiz quiz) {

        return quizService.updateQuiz(id, quiz);
    }
    @DeleteMapping("/quiz/{id}")
    public String deleteQuiz(@PathVariable Long id) {

        return quizService.deleteQuiz(id);
    }
    @GetMapping("/quiz/{id}")
    public Quiz getQuizById(@PathVariable Long id) {

        return quizService.getQuizById(id);
    }
}