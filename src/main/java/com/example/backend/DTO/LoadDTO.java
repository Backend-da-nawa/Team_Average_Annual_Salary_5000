package com.example.backend.DTO;

import com.example.backend.entity.Company;
import com.example.backend.entity.Employment;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@NoArgsConstructor
@Data
public class LoadDTO {

//    private Company company;
    private Long com_id;
    private String com_name;
    private String com_country;
    private String com_area;
    private String emp_position;
    private Long emp_compensation;
    private String emp_stack;

    @Builder
    public LoadDTO(Company company) {
        this.com_id = company.getId();
        this.com_name = company.getName();
        this.com_country = company.getCountry();
        this.com_area = company.getArea();
    }

    @Builder
    public LoadDTO(Employment employment) {
        this.emp_position = employment.getPosition();
        this.emp_compensation = employment.getCompensation();
        this.emp_stack = employment.getStack();
    }

}
