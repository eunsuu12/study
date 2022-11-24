package com.example.spring03.dto;

import java.time.LocalDateTime;

import com.example.spring03.domain.Reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class ReplyReadDto {
    //직렬화가 가능한(Serializable을 구현한 타입)필드로만 구성.
    private Integer replyId;
    private Integer postId;
    private String replyText;
    private String writer;
    private LocalDateTime createdTime;
    private LocalDateTime modifiedTime;
    
    // Entity객체에서 DTO 객체를 생성해서 리턴하는 메서드.
    public static ReplyReadDto fromEntity(Reply entity) {
        return ReplyReadDto.builder()
                .replyId(entity.getId())
                .postId(entity.getPost().getId())
                .replyText(entity.getReplyText())
                .writer(entity.getWriter())
                .createdTime(entity.getCreatedTime())
                .modifiedTime(entity.getModifiedTime())
                .build();
    }
}
