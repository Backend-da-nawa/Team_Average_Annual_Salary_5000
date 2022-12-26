package com.example.backend.service;

import com.example.backend.DTO.DetailDTO;
import com.example.backend.REPO.CompanyRepository;
import com.example.backend.REPO.EmploymentRepository;
import com.example.backend.entity.Company;
import com.example.backend.entity.Employment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmploymentDetailService {

    private final CompanyRepository companyRepository;
    private final EmploymentRepository employmentRepository;

    public DetailDTO read(Long empId) throws Exception {
        Employment employment = loadEmp(empId);
        List<Long> empIdList = getList(employment.getCompany());

        DetailDTO detailDTO = DetailDTO.builder()
                .employment(employment)
                .empIdList(empIdList)
                .build();

        return detailDTO;
    }

    private Employment loadEmp(Long empId) throws Exception {
        Optional<Employment> optional = employmentRepository.findById(empId);

        Employment employment;
        if (optional.isPresent()) employment = optional.get();
        else throw new Exception();

        return employment;
    }

    private List<Long> getList(Company company) throws Exception {
        List<Long> empList = new ArrayList<>();

        for (int i = 0; i < company.getEmployments().size(); i++) {
            empList.add(company.getEmployments().get(i).getId());
        }

        return empList;
    }
}
