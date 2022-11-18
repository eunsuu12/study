package com.example.spring02.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring02.domain.User;
import com.example.spring02.dto.UserCreateDto;
import com.example.spring02.dto.UserUpdateDto;
import com.example.spring02.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    
    // public List<User> read()
    @GetMapping("/list")
    public void list(Model model) {
        List<User> list= userService.read();
        model.addAttribute("list", list);
    }
    
    @GetMapping("/create")
    public void create() {
        log.info("create()");
    }
    
    // public int create(UserCreateDto dto)
    @PostMapping("/create")
    public String create(UserCreateDto dto) {
        log.info("create(dto= {})", dto);
        userService.create(dto);
        return "redirect:/user/list";
    }
    
    // public User read(Integer id)
    @GetMapping("/detail")
    public void detail(Integer id, Model model) {
        log.info("detail(id= {})", id);
        User user= userService.read(id);
        model.addAttribute("user", user);
    }
    
    @GetMapping("/modify")
    public void update(Integer id, Model model) {
        log.info("update(id= {})", id);
        User user= userService.read(id);
        model.addAttribute("user", user);
    }
    
    // public int update(UserUpdateDto dto)
    @PostMapping("/modify")
    public String update(UserUpdateDto dto, Model model) {
        log.info("update(dto= {}", dto);
        userService.update(dto);
        model.addAttribute("id", dto.getId());
        return "redirect:/user/detail";
    }
    
    // public int delete(Integer id)
    @PostMapping("/delete")
    public String delete(Integer id) {
        log.info("delete(id= {})", id);
        userService.delete(id);
        return "redirect:/user/list";
    }
    
    
}
