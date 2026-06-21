package com.shashank.quizsystem.repository;

import com.shashank.quizsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}