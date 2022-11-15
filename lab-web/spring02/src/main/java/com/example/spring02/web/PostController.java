package com.example.spring02.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring02.domain.Post;
import com.example.spring02.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller // 스프링 컨테이너가 Bean으로 생성, 관리
public class PostController {

    private final PostService postService; // 생성자에 의한 의존성 주입
    
    @GetMapping("/post/list")
    public String list(Model model) {
        log.info("list()");
        List<Post> list= postService.read();
        model.addAttribute("list", list);
        return "/post/list";
    }
    
    @GetMapping("/post/detail")
    public void detail(Integer id, Model model) {
        log.info("detail()");
        Post post = postService.selectById(id);
        model.addAttribute("post", post);
    }
    
    // TODO: 새글작성/ 수정페이지 / 수정 / 삭제 컨트롤러 메서드
}
