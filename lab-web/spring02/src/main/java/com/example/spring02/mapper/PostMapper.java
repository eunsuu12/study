package com.example.spring02.mapper;

import java.util.List;

import com.example.spring02.domain.Post;

// MyBatis 프레임워크에서 매퍼 인터페이스를 구현하는 클래스를 생성.
// MyBatis 프레임워크에서 매퍼 인터페이스를 찾을 수 있도록 applicationContext.xml파일에서
// <mybatis:scan> 설정을 해줌.
// 매퍼 인터페이스가 사용할 SQL문장들을 정의한 xml파일을 작성.

public interface PostMapper {

    List<Post> selectOrderByIdDesc();
    int insert(Post post);
    Post selectById(Integer id);
    int updateTitleAndContentById(Post entity);
    int deleteById(Integer id);
}
