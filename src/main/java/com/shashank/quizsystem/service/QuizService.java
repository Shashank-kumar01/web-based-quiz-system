package com.shashank.quizsystem.service;
import com.shashank.quizsystem.dto.QuizSubmissionRequest;
import com.shashank.quizsystem.entity.Question;
import com.shashank.quizsystem.entity.Result;
import com.shashank.quizsystem.repository.ResultRepository;
import java.util.Map;
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
    @Autowired
    private ResultRepository resultRepository;
    public int submitQuiz(QuizSubmissionRequest request) {

        Quiz quiz = quizRepository.findById(request.getQuizId()).orElse(null);

        if(quiz == null) {
            return -1;
        }

        int score = 0;

        Map<Long, String> answers = request.getAnswers();

        for(Question question : quiz.getQuestions()) {

            String userAnswer = answers.get(question.getId());

            if(userAnswer != null &&
                    userAnswer.equals(question.getCorrectAnswer())) {

                score++;
            }
        }

        Result result = new Result();

        result.setUserName(request.getUserName());
        result.setQuizTitle(quiz.getTitle());
        result.setScore(score);

        resultRepository.save(result);

        return score;
    }
}