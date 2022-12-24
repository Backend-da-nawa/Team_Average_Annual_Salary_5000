package com.example.backend.service;

import com.example.backend.REPO.CompanyRepository;
import com.example.backend.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company read(Long id) throws Exception {
        Optional<Company> optional = companyRepository.findById(id);

        Company company;
        if (optional.isPresent()) company = optional.get();
        else throw new Exception();

        return company;
    }
}
