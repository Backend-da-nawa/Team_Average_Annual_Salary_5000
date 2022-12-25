package com.example.backend.entity;

import com.example.backend.DTO.EmploymentModifyDTO;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "employment")
public class Employment {
    @Id
    @NonNull
    @Column(name = "emp_id")
    private Long id;

    @JoinColumn(name = "com_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Company company;

    @Column(name = "emp_position")
    @NonNull
    private String position;

    @Column(name = "emp_compensation")
    private Long compensation;

    @Column(name = "emp_stack")
    @NonNull
    private String stack;

    @Column(name = "emp_content")
    private String content;

    @Builder
    public Employment(EmploymentModifyDTO employmentModifyDTO) {
        this.id = employmentModifyDTO.getId();
        this.company=employmentModifyDTO.getCompany();
        this.compensation=employmentModifyDTO.getCompensation();
        this.content= employmentModifyDTO.getContent();
        this.position= employmentModifyDTO.getPosition();
        this.stack=employmentModifyDTO.getStack();
    }
}
