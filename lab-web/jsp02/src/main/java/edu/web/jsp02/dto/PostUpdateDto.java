package edu.web.jsp02.dto;

import edu.web.jsp02.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 업데이트 하기 위해서 필요한 정보들을 전달할 때 사용하는 객체.
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PostUpdateDto {
    private Integer id;
    private String title;
    private String content;
    
    public Post toEntity() {
        return Post.builder()
                .id(id).title(title).content(content)
                .build();
    }
}
