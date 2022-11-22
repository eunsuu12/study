package com.example.spring03.dto;

import com.example.spring03.domain.Post;

import lombok.Data;

@Data // 생성자+게터+세터+투스트링+...
public class PostCreateDto {
    // DTO클래스의 필드 이름= 요청 파라미터 이름.
    private String title;
    private String content;
    private String author;
    
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
