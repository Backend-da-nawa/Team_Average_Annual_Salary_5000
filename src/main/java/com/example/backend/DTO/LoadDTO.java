package com.example.backend.DTO;

import com.example.backend.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoadDTO {

//    private Company company;
    private Long com_id;
    private String com_name;
    private String com_country;
    private String com_area;
    private String emp_position;
    private Long emp_compensation;
    private String emp_stack;



}
