package com.ssg.flowershop.block.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter // ① 모든 필드의 게터를 자동 생성
@Entity // ② JPA에 의해 관리되는 엔티티 설정
@Table(name = "blocks") // ③ 매핑된 데이터베이스 테이블의 정보를 나타내는 애너테이션
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ④ Id 필드로 해당 필드가 기본키이며 테이블의 기본키 필드와 매핑

    @Column(length = 250, nullable = false)
    private String token; // ⑤ 차단 토큰 필드로 @Column 을 지정하여 해당 필드가 테이블 컬럼과 매핑, 설정 가능한 최대길이 250, null 허용하지 않음 설정

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created; // ⑥ 생성 일시 필드

    public Block() { // ⑦ 기본 클래스 생성자
    }

    public Block(String token) { // ⑦ 차단 토큰을 인자로 받는 생성자
        this.token = token;
    }
}