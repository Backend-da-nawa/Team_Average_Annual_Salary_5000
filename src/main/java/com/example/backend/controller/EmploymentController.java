package com.example.backend.controller;

import com.example.backend.service.EmploymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmploymentController {
    private  final EmploymentService employmentService;

    public EmploymentController(EmploymentService boardService) {
        this.employmentService = boardService;
    }
    @GetMapping("/employ/modify/{id}")
    public void employModify(@PathVariable("id") Integer id, Model model){

    }

}
