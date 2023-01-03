package com.example.backend.entity;

import com.example.backend.DTO.EmploymentDTO;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @JoinColumn(name = "com_id")
    @ManyToOne(fetch = FetchType.EAGER)
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
    public Employment(EmploymentDTO employmentDTO) {
        this.id = employmentDTO.getId();
        this.company = employmentDTO.getCompany();
        this.compensation = employmentDTO.getCompensation();
        this.content = employmentDTO.getContent();
        this.position = employmentDTO.getPosition();
        this.stack = employmentDTO.getStack();
    }
}