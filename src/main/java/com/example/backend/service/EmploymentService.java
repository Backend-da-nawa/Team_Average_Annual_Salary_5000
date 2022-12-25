package com.example.backend.service;

import com.example.backend.DTO.EmploymentDeleteDTO;
import com.example.backend.REPO.CompanyRepository;
import com.example.backend.REPO.EmploymentRepository;
import com.example.backend.VO.EmploymentDeleteVO;
import com.example.backend.entity.Company;
import com.example.backend.entity.Employment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmploymentService {
    private final EmploymentRepository employmentRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    public Long employDelete(Long empId) {
        employmentRepository.deleteById(empId);
        return 1L;
    }
}
