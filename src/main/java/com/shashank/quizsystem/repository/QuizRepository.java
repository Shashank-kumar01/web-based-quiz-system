package com.shashank.quizsystem.repository;

import com.shashank.quizsystem.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}