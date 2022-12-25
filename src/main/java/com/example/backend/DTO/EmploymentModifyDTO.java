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

    @Builder
    public EmploymentModifyDTO(Long id, Company company, String position, Long compensation, String stack, String content) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.compensation = compensation;
        this.stack = stack;
        this.content = content;
    }

}
