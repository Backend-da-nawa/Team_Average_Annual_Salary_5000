package com.example.backend.service;

import com.example.backend.REPO.CompanyRepository;
import com.example.backend.REPO.EmploymentRepository;
import com.example.backend.mapping.WithoutContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmploymentService {
    private final EmploymentRepository employmentRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public List<WithoutContent> load() throws Exception {
//        List<WithoutContent> employments = employmentRepository.findAllEmploymentLoadProjectionBy();

//        return employments;
        return null;
    }
}
