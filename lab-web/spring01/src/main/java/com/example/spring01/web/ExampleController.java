package com.example.spring01.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

// POJO(Plain Old Java Object): 평범한 자바 객체.
// 특정 클래스를 상속해야만 하거나,
//  상속 후엔 메서드들을 반드시 override해야만 하는 클래스가 아님.

@Slf4j
@Controller
public class ExampleController {

    @GetMapping("/")
    public String home() {
        log.info("home()");
        return "index";
    }
    
}
