package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
@Getter
@Table(name = "company")
@RequiredArgsConstructor
public class Company {

    @Id
    @Column(name = "com_id")
    private Long id;

    @OneToMany(mappedBy = "company",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Employment> employments;

    @Column(name = "com_name")
    private String name;

    @Column(name = "com_country")
    private String country;

    @Column(name = "com_area")
    private String area;

}
