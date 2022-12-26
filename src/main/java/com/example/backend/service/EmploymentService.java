package com.example.backend.service;

import com.example.backend.DTO.EmploymentDTO;
import com.example.backend.DTO.LoadDTO;
import com.example.backend.REPO.CompanyRepository;
import com.example.backend.REPO.EmploymentRepository;
import com.example.backend.VO.EmploymentSubmitVO;
import com.example.backend.entity.Company;
import com.example.backend.entity.Employment;
import com.example.backend.mapping.WithoutContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmploymentService {
    private final EmploymentRepository employmentRepository;
    private final CompanyRepository companyRepository;

    public Long employModify(Map<String,Object> map) throws Exception {
        Long comId = Long.parseLong((String) map.get("comId"));
        Optional<Company> optional= companyRepository.findById( Long.parseLong((String) map.get("comId")));
        Company company;
        if(optional.isPresent()) company=optional.get();
        else  throw  new Exception();

        EmploymentDTO employmentDTO = EmploymentDTO.builder()
                .id(Long.parseLong((String) map.get("empId")))
                .company(company)
                .compensation(Long.parseLong((String) map.get("compensation")))
                .position((String) map.get("position"))
                .stack((String) map.get("stack"))
                .content((String) map.get("content"))
                .build();
        Employment employment= Employment.builder().employmentDTO(employmentDTO).build();
        employmentRepository.save(employment);
        return 1L;
    }



    public Long employDelete(Long empId) {
        employmentRepository.deleteById(empId);
        return 1L;
    }

    public void employSubmit(EmploymentSubmitVO employmentSubmitVO) throws Exception {
        Optional<Company> optional = companyRepository.findById(employmentSubmitVO.getComId());

        Company company;

        if (optional.isPresent()) company = optional.get();
        else throw new Exception();

        try {
            EmploymentDTO employmentDTO = EmploymentDTO.builder()
                    .id(employmentSubmitVO.getId())
                    .compensation(employmentSubmitVO.getCompensation())
                    .content(employmentSubmitVO.getContent())
                    .position(employmentSubmitVO.getPosition())
                    .stack(employmentSubmitVO.getStack())
                    .company(company)
                    .build();


            Employment employment = new Employment(employmentDTO);
            employmentRepository.save(employment);
        } catch (Exception ignored) {
        }

    }

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
