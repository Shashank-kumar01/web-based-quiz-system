package com.shashank.quizsystem.controller;

import com.shashank.quizsystem.entity.Question;
import com.shashank.quizsystem.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/addQuestion")
    public String addQuestion(@RequestBody Question question) {

        return questionService.addQuestion(question);
    }

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {

        return questionService.getAllQuestions();
    }
    @PutMapping("/question/{id}")
    public String updateQuestion(@PathVariable Long id,
                                 @RequestBody Question question) {

        return questionService.updateQuestion(id, question);
    }
    @DeleteMapping("/question/{id}")
    public String deleteQuestion(@PathVariable Long id) {

        return questionService.deleteQuestion(id);
    }@GetMapping("/question/{id}")
    public Question getQuestionById(@PathVariable Long id) {

        return questionService.getQuestionById(id);
    }

}