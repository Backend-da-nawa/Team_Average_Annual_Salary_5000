package com.example.backend.controller;

import com.example.backend.DTO.LoadDTO;
import com.example.backend.service.EmploymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@Slf4j
public class EmploymentController {

    private final EmploymentService employmentService;

    @GetMapping("/employ/load")
    public List<LoadDTO> load() throws Exception {
        return employmentService.load();
    }

    @GetMapping("/employ/search")
    public Set<LoadDTO> search(@RequestParam String keyword) throws Exception {
        return employmentService.search(keyword);
    }

}
