package com.example.backend.controller;

import com.example.backend.entity.Employment;
import com.example.backend.service.EmploymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class EmploymentController {

    private final EmploymentService employmentService;

    @GetMapping("/employ/load")
    public List<Employment> load() throws Exception {
        return employmentService.load();
    }
}
