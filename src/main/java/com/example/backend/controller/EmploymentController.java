package com.example.backend.controller;

import com.example.backend.DTO.LoadDTO;
import com.example.backend.service.EmploymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.List;
import java.util.Set;

import com.example.backend.VO.EmploymentSubmitVO;


@RequiredArgsConstructor
@RestController
@Slf4j
public class EmploymentController {
    private final EmploymentService employmentService;

    @GetMapping("/employ/modify")
    public Long employModify(@RequestBody Map<String, Object> map) throws Exception {
        return employmentService.employModify(map);
    }


    @DeleteMapping("/employ/delete")
    public Long employDelete(@RequestParam Long empId){
        return employmentService.employDelete(empId);
    }

    @PostMapping("/employ/submit")
    public Long employSubmit(@RequestBody EmploymentSubmitVO employmentSubmitVO) throws Exception {
        return employmentService.employSubmit(employmentSubmitVO);
    }

    @GetMapping("/employ/load")
    public List<LoadDTO> load() throws Exception {
        return employmentService.load();
    }

    @GetMapping("/employ/search")
    public Set<LoadDTO> search(@RequestParam String keyword) throws Exception {
        return employmentService.search(keyword);
    }
}
