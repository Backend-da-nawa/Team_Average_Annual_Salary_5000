package com.example.backend.controller;

import com.example.backend.DTO.EmploymentDeleteDTO;
import com.example.backend.entity.Company;
import com.example.backend.entity.Employment;
import com.example.backend.service.EmploymentService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmploymentController {
    private  final EmploymentService employmentService;

    public EmploymentController(EmploymentService boardService) {
        this.employmentService = boardService;
    }

    @GetMapping("/employ/delete")
    public Long employDelete(@RequestParam Long empId){

        return employmentService.employDelete(empId);
    }
    

}
