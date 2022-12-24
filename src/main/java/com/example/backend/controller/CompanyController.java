package com.example.backend.controller;

import com.example.backend.entity.Company;
import com.example.backend.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/company/jobOpening")
    public Company read(@RequestParam Long id) throws Exception {
        return companyService.read(id);
    }
}
