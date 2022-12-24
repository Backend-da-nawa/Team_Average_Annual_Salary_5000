package com.example.backend.service;

import com.example.backend.DTO.EmploymentSubmitDTO;
import com.example.backend.REPO.CompanyRepository;
import com.example.backend.REPO.EmploymentRepository;
import com.example.backend.VO.EmploymentSubmitVO;
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
    public void employSubmit(EmploymentSubmitVO employmentSubmitVO) throws Exception {
        Optional<Company> optional = companyRepository.findById(employmentSubmitVO.getComId());

        Company company;

        if (optional.isPresent()) company = optional.get();
        else throw new Exception();

        try {
            EmploymentSubmitDTO employmentSubmitDTO = EmploymentSubmitDTO.builder()
                    .id(employmentSubmitVO.getId())
                    .compensation(employmentSubmitVO.getCompensation())
                    .content(employmentSubmitVO.getContent())
                    .position(employmentSubmitVO.getPosition())
                    .stack(employmentSubmitVO.getStack())
                    .company(company)
                    .build();


            Employment employment = new Employment(employmentSubmitDTO);
            employmentRepository.save(employment);
        } catch (Exception ignored) {
        }

    }

}

