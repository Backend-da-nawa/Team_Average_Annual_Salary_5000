package com.example.backend.controller;

import com.example.backend.DTO.LoadDTO;
import com.example.backend.REPO.CompanyRepository;
import com.example.backend.entity.Company;
import com.example.backend.mapping.WithoutContent;
import com.example.backend.service.EmploymentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class EmploymentController {

    private final EmploymentService employmentService;

    @GetMapping("/employ/load")
    public List<LoadDTO> load() throws Exception {
        return employmentService.load();
    }

    @GetMapping("/employ/load")
    public List<LoadDTO> search(@RequestParam String search) throws Exception {
        return employmentService.search(search);
    }

}
