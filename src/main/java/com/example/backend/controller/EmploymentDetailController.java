package com.example.backend.controller;

import com.example.backend.DTO.DetailDTO;
import com.example.backend.service.EmploymentDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class EmploymentDetailController {
    private final EmploymentDetailService employmentDetailService;


    @GetMapping("/company/emp")
    public DetailDTO read(@RequestParam Long empId) throws Exception {
        return employmentDetailService.read(empId);
    }
}
