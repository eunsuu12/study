package com.example.spring02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring02.domain.Post;
import com.example.spring02.dto.PostCreateDto;
import com.example.spring02.dto.PostUpdateDto;
import com.example.spring02.mapper.PostMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final필드를 argument로 갖는 생성자를 만듦.
@Service 
// -> @Service + applicationContext.xml: 스프링 컨테이너에 서비스 컴포넌트로 등록.
// -> 스프링 컨테이너가 필요한 곳(ex: controller객체)에 Service 컴포넌트를 주입할 수 있음.
public class PostService {

    // 의존성 주입(dependency inject):
    //  (1) 필드에 의한 의존성 주입: @Autowired
    //      @Autowired private PostMapper postMapper;
    
    //  (2) 생성자에 의한 의존성 주입: final필드 + @RequiredArgsConstructor
    
    // 생성자에 의한 의존성 주입
    private final PostMapper postMapper;
    
    public List<Post> read(){
        return postMapper.selectOrderByIdDesc();
    }

    public Post read(Integer id) {
        return postMapper.selectById(id);
    }

    public int create(PostCreateDto dto) {
        log.info("create(dto= {})", dto);
        return postMapper.insert(dto.toEntity());        
    }

    public int delete(Integer id) {
        log.info("delete(id= {})", id);
        return postMapper.deleteById(id);
        
    }

    public int update(PostUpdateDto dto) {
        log.info("update(dto= {})", dto);
        return postMapper.updateTitleAndContentById(dto.toEntity());
        
    }
    
    // TODO: 새글작성 / 글번호검색 / 수정 / 삭제 서비스
}
