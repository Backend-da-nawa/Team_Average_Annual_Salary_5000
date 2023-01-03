package com.example.backend.mapping;

import com.example.backend.entity.Company;

public interface WithoutContent {
    Long getId();
    Company getCompany();
    String getPosition();
    Long getCompensation();
    String getStack();
}
