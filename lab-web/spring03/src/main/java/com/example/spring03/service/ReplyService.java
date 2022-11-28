package com.example.spring03.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring03.domain.Post;
import com.example.spring03.domain.Reply;
import com.example.spring03.dto.ReplyReadDto;
import com.example.spring03.dto.ReplyRegisterDto;
import com.example.spring03.dto.ReplyUpdateDto;
import com.example.spring03.repository.PostRepository;
import com.example.spring03.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service // 스프링 컨텍스에 Service 컴포넌트로 등록. -> 의존성 주입이 가능해짐.
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;
    
    public Integer create(ReplyRegisterDto dto) {
        log.info("create(dto={})", dto);
        
        // 댓글이 달린 포스트를 검색
        Post post = postRepository.findById(dto.getPostId()).get();
        // DTO를 Reply 엔터티로 변환
        Reply reply = Reply.builder()
                .post(post).replyText(dto.getReplyText()).writer(dto.getWriter())
                .build();
        // 테이블에 저장
        reply = replyRepository.save(reply);
        
        return reply.getId(); // 테이블에 저장된 댓글 번호(아이디)를 리턴.
    }
    
    @Transactional(readOnly = true)
    // 데이터베이스 테이블에서 포스트 번호에 달려있는 모든 댓글을 검색해서 리스트를 리턴.
    public List<ReplyReadDto> readReplies(Integer postId) {
        log.info("readReplies(postId={})", postId);
        
        List<Reply> list = replyRepository.selectAllReplies(postId);
        
        // List<Reply>를 List<ReplyReadDto> 변환해서 리턴.
        return list.stream()
                .map(ReplyReadDto::fromEntity)
                .toList();
    }

    @Transactional(readOnly = true)
    public ReplyReadDto readReply(Integer replyId) {
        log.info("readReply(replyId={})", replyId);
        
        Reply entity = replyRepository.findById(replyId).get();
        
        return ReplyReadDto.fromEntity(entity);
    }
    
    public Integer delete(Integer replyId) {
        log.info("delete(replyId= {})", replyId);
        
        replyRepository.deleteById(replyId);
        
        return replyId;
    }
    
    @Transactional
    public Integer update(ReplyUpdateDto dto) {
        log.info("update(dto= {})", dto);
        
        // 수정하려는 댓글 아이디로 댓글 엔터티 객체를 검색.
        Reply entity= replyRepository.findById(dto.getReplyId()).get();
        // DB테이블에서 검색한 엔터티 객체를 수정.
        entity.update(dto.getReplyText());
        // @Transactional이 적용된 경우에 메서드 실행이 끝날 때 DB에 자동으로 save됨.
        
        return entity.getId(); // 수정한 엔터티의 아이디를 리턴.
    }
    
}