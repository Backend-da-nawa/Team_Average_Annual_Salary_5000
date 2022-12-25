package com.example.backend.service;

import com.example.backend.DTO.EmploymentModifyDTO;
import com.example.backend.REPO.CompanyRepository;
import com.example.backend.REPO.EmploymentRepository;
import com.example.backend.entity.Company;
import com.example.backend.entity.Employment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmploymentService {
    private final EmploymentRepository employmentRepository;
    private final CompanyRepository companyRepository;

    public Long employModify(Map<String,Object> map) throws Exception {
        Long comId = Long.parseLong((String) map.get("comId"));
        Optional<Company> optional= companyRepository.findById( Long.parseLong((String) map.get("comId")));
        Company company;
        if(optional.isPresent()) company=optional.get();
        else  throw  new Exception();

        EmploymentModifyDTO employmentModifyDTO = EmploymentModifyDTO.builder()
                .id(Long.parseLong((String) map.get("empId")))
                .company(company)
                .compensation(Long.parseLong((String) map.get("compensation")))
                .position((String) map.get("position"))
                .stack((String) map.get("stack"))
                .content((String) map.get("content"))
                .build();
        Employment employment= Employment.builder().employmentModifyDTO(employmentModifyDTO).build();
        employmentRepository.save(employment);
        return 1L;
    }



}
