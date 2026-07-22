package com.shashank.quizsystem.service;

import com.shashank.quizsystem.entity.Result;
import com.shashank.quizsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public String addResult(Result result) {

        resultRepository.save(result);

        return "Result Saved Successfully";
    }

    public List<Result> getAllResults() {

        return resultRepository.findAll();
    }
}