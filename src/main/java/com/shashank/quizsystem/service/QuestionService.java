package com.shashank.quizsystem.service;

import com.shashank.quizsystem.entity.Question;
import com.shashank.quizsystem.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public String addQuestion(Question question) {

        questionRepository.save(question);

        return "Question Added Successfully";
    }

    public List<Question> getAllQuestions() {

        return questionRepository.findAll();
    }
    public Question getQuestionById(Long id) {

        return questionRepository.findById(id).orElse(null);
    }

    public String deleteQuestion(Long id) {

        questionRepository.deleteById(id);

        return "Question Deleted Successfully";
    }

    public String updateQuestion(Long id, Question updatedQuestion) {

        Question question = questionRepository.findById(id).orElse(null);

        if(question != null) {

            question.setQuestionText(updatedQuestion.getQuestionText());
            question.setOptionA(updatedQuestion.getOptionA());
            question.setOptionB(updatedQuestion.getOptionB());
            question.setOptionC(updatedQuestion.getOptionC());
            question.setOptionD(updatedQuestion.getOptionD());
            question.setCorrectAnswer(updatedQuestion.getCorrectAnswer());

            question.setCategory(updatedQuestion.getCategory());

            questionRepository.save(question);

            return "Question Updated Successfully";
        }

        return "Question Not Found";
    }
}