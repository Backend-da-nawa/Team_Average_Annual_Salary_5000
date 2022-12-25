package com.example.backend.DTO;

import com.example.backend.entity.Company;
import com.example.backend.entity.Employment;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Data
public class LoadDTO {

//    private Company company;
    private Long empId;
    private String comName;
    private String comCountry;
    private String comArea;
    private String empPosition;
    private Long empCompensation;
    private String empStack;

    @Builder
    public LoadDTO(Company company) {
        this.comName = company.getName();
        this.comCountry = company.getCountry();
        this.comArea = company.getArea();
    }

    @Builder
    public LoadDTO(Employment employment) {
        this.empId = employment.getId();
        this.empPosition = employment.getPosition();
        this.empCompensation = employment.getCompensation();
        this.empStack = employment.getStack();
    }

}
