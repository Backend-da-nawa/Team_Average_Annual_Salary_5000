package com.example.backend.DTO;

import com.example.backend.entity.Company;
import com.example.backend.entity.Employment;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Data
public class DetailDTO {

//    private Company company;
    private Long empId;
    private String comName;
    private String comCountry;
    private String comArea;
    private String empPosition;
    private Long empCompensation;
    private String empStack;
    private String empContent;
    private List<Long> anotherEmployment;

    @Builder
    public DetailDTO(Employment employment, List<Long> empIdList) {
        this.empId = employment.getId();
        this.comName = employment.getCompany().getName();
        this.comCountry = employment.getCompany().getCountry();
        this.comArea = employment.getCompany().getArea();
        this.empPosition = employment.getPosition();
        this.empCompensation = employment.getCompensation();
        this.empStack = employment.getStack();
        this.empContent = employment.getContent();
        this.anotherEmployment = empIdList;
    }

}
