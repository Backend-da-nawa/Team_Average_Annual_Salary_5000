package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@RequiredArgsConstructor
@Table(name = "employment")
public class EmploymentVO {
    @Id
    @Column(name = "emp_id")
    private Long id;

    @JoinColumn(name = "com_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private CompanyVO company;

    @Column(name = "emp_position")
    private String position;

    @Column(name = "emp_compensation")
    private Long compensation;

    @Column(name = "emp_stack")
    private String stack;

}
