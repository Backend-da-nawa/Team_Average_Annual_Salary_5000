package com.example.backend.service;

import com.example.backend.DTO.LoadDTO;
import com.example.backend.REPO.CompanyRepository;
import com.example.backend.REPO.EmploymentRepository;
import com.example.backend.entity.Company;
import com.example.backend.mapping.WithoutContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmploymentService {
    private final EmploymentRepository employmentRepository;

    @Transactional
    public List<LoadDTO> load() throws Exception {
        List<WithoutContent> mapping = employmentRepository.findAllBy();

        List<LoadDTO> loadDTOList = new ArrayList<>();

        for (int i = 0; i < mapping.size(); i++) {
            LoadDTO loadDTO = new LoadDTO(mapping.get(i));
            loadDTOList.add(loadDTO);
        }

        return loadDTOList;
    }
}
