package com.example.spring03.dto;

import com.example.spring03.domain.Reply;

import lombok.Data;

@Data
public class ReplyRegisterDto {

    // 필드 이름들은 Ajax요청에서 사용된 data객체의 속성 이름과 동일하게.
    private Integer postId;
    private String replyText;
    private String writer;

}
