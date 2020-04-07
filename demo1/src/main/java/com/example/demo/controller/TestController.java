package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private int count;

    @RequestMapping("test1")
        public String getRes(){
            count++;
            return "第"+count+"次hello";
    }
}
