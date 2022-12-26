package com.example.backend.controller;
<<<<<<< HEAD

import com.example.backend.service.EmploymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

=======
import com.example.backend.service.EmploymentService;
import org.springframework.web.bind.annotation.*;

>>>>>>> dcd043678b1b934eae92a7c13e94c0f564ea81cc
@RestController
public class EmploymentController {
    private  final EmploymentService employmentService;

    public EmploymentController(EmploymentService boardService) {
        this.employmentService = boardService;
    }
<<<<<<< HEAD
    @GetMapping("/employ/modify")
    public Long employModify(@RequestBody Map<String,Object> map)throws Exception{

        return employmentService.employModify(map);

    }

=======

    @GetMapping("/employ/delete")
    public Long employDelete(@RequestParam Long empId){

        return employmentService.employDelete(empId);
    }


>>>>>>> dcd043678b1b934eae92a7c13e94c0f564ea81cc
}
