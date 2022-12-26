package com.example.backend.service;

import com.example.backend.DTO.LoadDTO;
import com.example.backend.REPO.EmploymentRepository;
import com.example.backend.mapping.WithoutContent;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Set<LoadDTO> search(String keyword) throws Exception {
        Set<LoadDTO> loadDTOList = new HashSet<>();

        companySearch(loadDTOList, keyword);

        stackSearch(loadDTOList, keyword);


        return loadDTOList;
    }

    private void companySearch(Set<LoadDTO> loadDTOList, String keyword) {
//        LoadDTO loadDTO;
        List<WithoutContent> searchWithCompanyList = employmentRepository.findAllByCompany_NameLike("%"+keyword+"%");

        for (WithoutContent companySearch : searchWithCompanyList) {
            LoadDTO loadDTO = new LoadDTO(companySearch);
            loadDTOList.add(loadDTO);
        }
    }

    private void stackSearch(Set<LoadDTO> loadDTOList, String keyword) {
//        LoadDTO loadDTO;
        List<WithoutContent> searchWithStackList = employmentRepository.findAllByStackLike("%"+keyword+"%");

        for (WithoutContent stackSearch : searchWithStackList) {
            LoadDTO loadDTO = new LoadDTO(stackSearch);
            loadDTOList.add(loadDTO);
        }
    }
}
