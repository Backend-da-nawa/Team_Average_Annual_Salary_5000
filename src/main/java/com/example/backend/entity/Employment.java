package com.example.backend.entity;

import com.example.backend.DTO.EmploymentSubmitDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

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

    public Employment(EmploymentSubmitDTO employmentSubmitDTO) {
        this.id = employmentSubmitDTO.getId();
        this.company = employmentSubmitDTO.getCompany();
        this.position = employmentSubmitDTO.getPosition();
        this.compensation = employmentSubmitDTO.getCompensation();
        this.stack = employmentSubmitDTO.getStack();
        this.content = employmentSubmitDTO.getContent();
    }
}
