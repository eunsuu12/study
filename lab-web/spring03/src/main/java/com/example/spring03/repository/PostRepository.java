package com.example.spring03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring03.domain.Post;

// JpaRepository<엔터티 클래스 타입, PK데이터 타입>을 상속하는 인터페이스를 선언
//-> 기본적인 CRUD에 필요한 메서드들이 자동으로 생성.
//-> JpaRepository를 상속하는 인터페이스는 스프링 컨텍스트에서 bean으로 자동 관리됨.

// @Repository 필요 없음.
public interface PostRepository extends JpaRepository<Post, Integer>{

    // select * from POSTS order by ID desc
    List<Post> findByOrderByIdDesc();
}
