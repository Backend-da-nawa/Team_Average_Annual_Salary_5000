package com.example.backend.controller;

import com.example.backend.VO.EmploymentSubmitVO;
import com.example.backend.entity.Employment;
import com.example.backend.service.EmploymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@Controller
public class EmploymentController {
    private final EmploymentService employmentService;

    public EmploymentController(EmploymentService boardService) {
        this.employmentService = boardService;
    }

    @PostMapping("/employ/submit")
    public void employSubmit(@RequestBody EmploymentSubmitVO employmentSubmitVO)throws Exception{
        employmentService.employSubmit(employmentSubmitVO);
    }



}
