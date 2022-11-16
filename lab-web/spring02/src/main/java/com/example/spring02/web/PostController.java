package com.example.spring02.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring02.domain.Post;
import com.example.spring02.dto.PostCreateDto;
import com.example.spring02.dto.PostUpdateDto;
import com.example.spring02.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post")
//-> 클래스에 @RequestMapping 애너테이션을 사용하면
// 그 클래스의 모든 메서드들의 매핑 주소는 @RequestMapping에서 설정된 URL로 시작함.
@Controller // 스프링 컨테이너가 Bean으로 생성, 관리
public class PostController {

    private final PostService postService; // 생성자에 의한 의존성 주입
    
    @GetMapping("/list")
    public String list(Model model) {
        log.info("list()");
        List<Post> list= postService.read();
        model.addAttribute("list", list);
        return "/post/list";
    }
    
    @GetMapping("/detail")
    public String detail(Integer id, Model model) {
        log.info("detail(id= {})", id);
        Post post = postService.read(id);
        model.addAttribute("post", post);
        return "/post/detail";
    }
    
    @GetMapping("/create")
    public String create() {
        log.info("create()");
        return "/post/create";
    }
    
    @PostMapping("/create")
    public String create(PostCreateDto dto) {
        log.info("create(dto= {})", dto);
        postService.create(dto);
        //포스트 목록 페이지로 이동(redirect):
        //  PRG(Post - Redirect - Get)
        return "redirect:/post/list";
    }
    
    @GetMapping("/modify")
    public String modify(Integer id, Model model) {
        log.info("modify(id= {})", id);
        Post post= postService.read(id);
        model.addAttribute("post", post);
        return "/post/modify";
    }
    
    @PostMapping("/delete")
    public String delete(Integer id) {
        log.info("delete(id= {})", id);
        postService.delete(id);
        return "redirect:/post/list";
    }
    
    @PostMapping("/update")
    public String update(PostUpdateDto dto) {
        log.info("update(dto= {}", dto);
        postService.update(dto);
        return "redirect:/post/detail/?id="+dto.getId();
    }
    
    // TODO: 새글작성/ 수정페이지 / 수정 / 삭제 컨트롤러 메서드
}
