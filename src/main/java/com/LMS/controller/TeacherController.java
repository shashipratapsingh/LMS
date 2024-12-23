package com.LMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {
    @GetMapping("/")
    public String getProfile()
    {
        return "Teacher DashBoard page";
    }
}
