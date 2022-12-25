package com.example.backend.DTO;
import com.example.backend.entity.Company;
import com.example.backend.entity.Employment;
import lombok.*;

import javax.persistence.*;
@Getter
@NoArgsConstructor
@Data
public class EmploymentModifyDTO {
    private Long id;
    private Company company;
    private String position;
    private Long compensation;
    private String stack;
    private String content;


}
