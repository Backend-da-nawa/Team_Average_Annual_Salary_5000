package com.example.backend.VO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class EmploymentModifyVO {
    private Long id;
    private Long comId;
    private Long compensation;
    private String content;
    private String position;
    private String stack;

}
