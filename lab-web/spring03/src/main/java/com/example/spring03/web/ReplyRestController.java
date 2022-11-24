package com.example.spring03.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring03.domain.Reply;
import com.example.spring03.dto.ReplyReadDto;
import com.example.spring03.dto.ReplyRegisterDto;
import com.example.spring03.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController // Rest서비스에서 사용되는 컨트롤러 객체
//-> @Controller클래스의 메서드 리턴값(String) => 뷰 이름
//-> @RestController클래스의 메서드 리턴값 => 클라이언트로 전송되는 값!
@RequestMapping("/api/reply")
public class ReplyRestController {

    private final ReplyService replyService;
    
    @PostMapping // 댓글 등록 REST 서비스
    public ResponseEntity<Integer> registerReply(@RequestBody ReplyRegisterDto dto) {
        // Ajax요청에서 서버로 보내는 데이터 HTTP패킷의 body에 포함됨.
        // @RequestBody: HTTP패킷 body에 포함된 데이터(파라미터)를 분석할 때 사용.
        
        log.info("registerReply(dto= {})", dto);
        
        // 댓글 데이터베이스 테이블에 등록.
        Integer replyId= replyService.create(dto);
        
        // 작성된 댓글의 아이디를 응답 데이터(response data)로 만들어서,
        //  Ajax요청에 대한 성공 응답을 전송.
        return ResponseEntity.ok(replyId); 
    }
    
    @GetMapping("/all/{postId}")
    // Controller에서 ResponseEntity를 리턴할 떄, 데이터 타입으로 엔터티 클래스를 사용하면 안됨.
    public ResponseEntity<List<ReplyReadDto>> readAllReplies(@PathVariable Integer postId){
        // @PathVariable: 요청 주소에서 변수처럼 값이 변하는 부분.
        
        log.info("readAllReplies(postId= {})", postId);
        
        List<ReplyReadDto> list= replyService.readReplies(postId);
        log.info("# of list= ", list.size());
        
        return ResponseEntity.ok(list);
        // Java의 List타입 객체가 JSON(JavaScript Object Notation)문자열로 변환돼서
        //  클라이언트(브라우저)로 전송.
    }
}
