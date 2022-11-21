package com.example.spring03.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/") // 요청 URL/방식 매핑.
    public String home(Model model) {
        log.info("home()");
        model.addAttribute("msg", "안녕, Spring Boot!");
        return "home"; // View이름 -> src/main/resources/templates/파일이름.html
    }
}
