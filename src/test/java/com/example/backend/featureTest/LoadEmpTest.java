package com.example.backend.featureTest;

import com.example.backend.DTO.EmploymentDTO;
import com.example.backend.REPO.CompanyRepository;
import com.example.backend.REPO.EmploymentRepository;
import com.example.backend.entity.Company;
import com.example.backend.entity.Employment;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("채용 공고 테스트")
public class submitTest {

    @LocalServerPort
    private  int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmploymentRepository employmentRepository;

    @AfterEach
    public void clear(){
        companyRepository.deleteAll();
        employmentRepository.deleteAll();
    }

    @Test
    public void 채용_공고_등록(){
        //given
        Company savedCompany = companyRepository.save(Company.builder()
                .id(1L)
                .name("카카오")
                .country("대한민국")
                .area("판교")
                .build());

        Long id=1L;
        Long compensation=87000L;
        String stack="React";
        String content="카카오에서 프론트엔드 주니어 개발자를 채용합니다. 자격요건은..";
        String position="프론트엔드 개발자";

        EmploymentDTO employmentDTO=EmploymentDTO.builder()
                .id(id)
                .compensation(compensation)
                .content(content)
                .company(savedCompany)
                .position(position)
                .stack(stack)
                .build();

        Employment oldEmploy=Employment.builder()
                .employmentDTO(employmentDTO)
                .build();


        employmentRepository.save(oldEmploy);


        String url = "http://localhost:"+port+"/employ/submit";

        //when
        Optional<Employment> optional= employmentRepository.findById(oldEmploy.getId());
        Employment newEmployment = null;
        if(optional.isPresent()){
            newEmployment=optional.get();
        }
        assertThat(newEmployment.getId()).isEqualTo(id);
        assertThat(newEmployment.getId()).isNotEqualTo(2L);

    }


    @Test
    public void 채용_공고_수정() throws Exception {
        //given
        Company savedCompany = companyRepository.save(Company.builder()
                .id(1L)
                .name("카카오")
                .country("대한민국")
                .area("판교")
                .build());

        Long id=1L;
        Long compensation=87000L;
        String stack="React";
        String content="카카오에서 프론트엔드 주니어 개발자를 채용합니다. 자격요건은..";
        String position="프론트엔드 개발자";

        EmploymentDTO employmentDTO=EmploymentDTO.builder()
                .id(id)
                .compensation(compensation)
                .content(content)
                .company(savedCompany)
                .position(position)
                .stack(stack)
                .build();

        Employment oldEmploy=Employment.builder()
                .employmentDTO(employmentDTO)
                .build();


        Employment old =employmentRepository.save(oldEmploy);


        String updatedStack="Vue.js";
        String updatedContent="카카오에서 프론트엔드 시니어 개발자를 채용합니다. 자격요건은.....";
        String updatedPosition="프론트엔드 시니어 개발자";

        EmploymentDTO newEmploymentDTO= EmploymentDTO.builder()
                .stack(updatedStack)
                .position(updatedPosition)
                .content(updatedContent)
                .compensation(old.getCompensation())
                .company(old.getCompany())
                .id(old.getId())
                .build();

        Employment newEmploy=Employment.builder()
                .employmentDTO(newEmploymentDTO)
                .build();

        Employment newEmployment=employmentRepository.save(newEmploy);

        assertThat(newEmployment.getStack()).isEqualTo(updatedStack);
        assertThat(newEmployment.getContent()).isEqualTo(updatedContent);
        assertThat(newEmployment.getPosition()).isEqualTo(updatedPosition);

    }

    @Test
    public void 채용_공고_삭제(){
        //given
        Company savedCompany = companyRepository.save(Company.builder()
                .id(1L)
                .name("카카오")
                .country("대한민국")
                .area("판교")
                .build());

        Long id=1L;
        Long compensation=87000L;
        String stack="React";
        String content="카카오에서 프론트엔드 주니어 개발자를 채용합니다. 자격요건은..";
        String position="프론트엔드 개발자";

        EmploymentDTO employmentDTO=EmploymentDTO.builder()
                .id(id)
                .compensation(compensation)
                .content(content)
                .company(savedCompany)
                .position(position)
                .stack(stack)
                .build();

        Employment oldEmploy=Employment.builder()
                .employmentDTO(employmentDTO)
                .build();


        Employment old =employmentRepository.save(oldEmploy);

        String url = "http://localhost:"+port+"/employ/delete?empId="+id;
        restTemplate.delete(url);


        List<Employment> deleted =employmentRepository.findAll();
        assertThat(deleted.size()).isEqualTo(0);

    }

    

}
