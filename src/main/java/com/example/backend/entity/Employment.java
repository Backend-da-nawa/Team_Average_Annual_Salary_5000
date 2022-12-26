package com.example.backend.entity;

<<<<<<< HEAD
<<<<<<< HEAD
import com.example.backend.DTO.EmploymentDTO;
import com.example.backend.DTO.EmploymentModifyDTO;
import lombok.*;
=======
=======
import com.example.backend.DTO.EmploymentSubmitDTO;
>>>>>>> origin/submit_week1
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
<<<<<<< HEAD
>>>>>>> dcd043678b1b934eae92a7c13e94c0f564ea81cc
=======
>>>>>>> origin/submit_week1

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
    public Employment(EmploymentDTO employmentDTO) {
        this.id = employmentDTO.getId();
        this.company=employmentDTO.getCompany();
        this.compensation=employmentDTO.getCompensation();
        this.content= employmentDTO.getContent();
        this.position= employmentDTO.getPosition();
        this.stack=employmentDTO.getStack();
    }


