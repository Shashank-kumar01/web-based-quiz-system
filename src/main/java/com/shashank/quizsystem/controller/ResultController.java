package com.shashank.quizsystem.controller;

import com.shashank.quizsystem.entity.Result;
import com.shashank.quizsystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping("/addResult")
    public String addResult(@RequestBody Result result) {

        return resultService.addResult(result);
    }

    @GetMapping("/results")
    public List<Result> getAllResults() {

        return resultService.getAllResults();
    }
}