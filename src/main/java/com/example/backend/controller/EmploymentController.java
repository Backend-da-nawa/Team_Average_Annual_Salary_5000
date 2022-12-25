package com.example.backend.controller;

import com.example.backend.service.EmploymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EmploymentController {
    private  final EmploymentService employmentService;

    public EmploymentController(EmploymentService boardService) {
        this.employmentService = boardService;
    }
    @GetMapping("/employ/modify")
    public Long employModify(@RequestBody Map<String,Object> map)throws Exception{

        return employmentService.employModify(map);

    }

}
