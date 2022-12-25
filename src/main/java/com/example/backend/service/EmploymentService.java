package com.example.backend.service;

import com.example.backend.DTO.LoadDTO;
import com.example.backend.REPO.CompanyRepository;
import com.example.backend.REPO.EmploymentRepository;
import com.example.backend.entity.Company;
import com.example.backend.mapping.WithoutContent;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

        for (WithoutContent withoutContent : mapping) {
            LoadDTO loadDTO = new LoadDTO(withoutContent);
            loadDTOList.add(loadDTO);
        }

        return loadDTOList;
    }

    @Transactional
    public List<LoadDTO> search(String search) throws Exception {
        List<LoadDTO> loadDTOList = new ArrayList<>();

        companySearch(loadDTOList, search);

        stackSearch(loadDTOList, search);

        return loadDTOList;
    }

    private void companySearch(List<LoadDTO> loadDTOList, String search) {
        LoadDTO loadDTO;
        List<WithoutContent> searchWithCompanyList = employmentRepository.findAllByCompany_NameLike(search);

        for (WithoutContent companySearch : searchWithCompanyList) {
            loadDTO = new LoadDTO(companySearch);
            loadDTOList.add(loadDTO);
        }
    }

    private void stackSearch(List<LoadDTO> loadDTOList, String search) {
        LoadDTO loadDTO;
        List<WithoutContent> searchWithStackList = employmentRepository.findAllByStackLike(search);

        for (WithoutContent stackSearch : searchWithStackList) {
            loadDTO = new LoadDTO(stackSearch);
            loadDTOList.add(loadDTO);
        }
    }
}
