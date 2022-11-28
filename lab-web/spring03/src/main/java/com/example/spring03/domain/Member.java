package com.example.spring03.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Entity(name= "MEMBERS")
@SequenceGenerator(name = "MEMBERS_SEQ_GEN", sequenceName = "MEMBERS_SEQ",allocationSize = 1)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBERS_SEQ_GEN")
    private Integer id; // PK
    
    @Column(unique = true, nullable = false) // unique, not null 제약 조건
    private String username; // 사용자 아이디
    
    @Column(nullable = false)
    private String password; // 사용자 비밀번호
        
    @Column(nullable = false)
    private String email; // 사용자 이메일 -> 소셜로그인 기능에서 사용될 수 있음.
    
    private String nickname; // 사용자 별명
    
    private boolean deleted; // 탈퇴 여부?
    
    private boolean social; // 소셜로그인 여부?
    
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    //-> Builder패턴으로 객체를 생성할 때, roles() 메서드를 호출하지 않으면
    // null대신에 클래스의 필드 선언에서 생성된 객체가 사용되도록 하기 위해서.
    private Set<MemberRole> roles= new HashSet<>();
    
    public Member addRole(MemberRole role) {
        roles.add(role);
        
        return this;
    }
}
