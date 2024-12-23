package com.LMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Principal")
public class PrincipalController {
    @GetMapping("/")
    public String getDashboard()
    {
        return "Principal Dashboard page";
    }
}
