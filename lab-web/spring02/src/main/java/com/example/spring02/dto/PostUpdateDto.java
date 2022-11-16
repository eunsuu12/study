package com.example.spring02.dto;

import com.example.spring02.domain.Post;

import lombok.Data;
import lombok.NoArgsConstructor;

// 포스트 작성 페이지에서 보낸 요청 파라미터들을 저장하고
//  서비스 계층으로 전달하기 위한 목적의 DataTransferObject.
@NoArgsConstructor
@Data
// @RequiredArgsConstructor + @Getter + @Setter + @ToString + @EqualsAndHashCode
public class PostUpdateDto {
    private Integer id;
    private String title;
    private String content;
    
    //DTO객체를 Entity객체로 변환해서 리턴하는 메서드.
    public Post toEntity() {
        return Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
}
