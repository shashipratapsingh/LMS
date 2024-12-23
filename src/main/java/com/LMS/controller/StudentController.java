package com.LMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @GetMapping("/")
    public String getStudent()
    {
        return "Student DashBoard page";
    }
}
