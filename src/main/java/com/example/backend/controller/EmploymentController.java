package com.example.backend.controller;
import com.example.backend.service.EmploymentService;
import org.springframework.web.bind.annotation.*;

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
