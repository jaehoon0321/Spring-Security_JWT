package com.ssg.flowershop.item.entity;

import com.ssg.flowershop.item.dto.ItemRead;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter   //모든 필드의 게터를 자동으로 생성해 주는 애너테이션
@Entity   //JPA에 의해 관리되는 엔티티 임을 나타내는 애너테이션
@Table(name = "items") //매핑된 데이터베이스 테이블( flowershop 스키마의 items테이블)을 지정
public class Item {
    @Id  //아이디 필드 , 해당 필드가 기본키이며, 테이블의 기본키 컬럼과 매핑됨을 나타냄
    // 기본키의 값을 데이터베이스가 자동으로 증가시켜 생성하도록 @GeneratedValue 애너테이션과
    // 기본키 생성 전략을 GenerationType.IDENTITY 로 지정함
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50, nullable = false)   //name의 길이는 50이고, 널 허용하지 않음
    private String name;

    @Column(length = 100, nullable = false)
    private String imgPath;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer discountPer;

    @Column(updatable = false, nullable = false) //생성일시 필드 , 널허용하지 않고  최초값 입력 후 수정되지 못함
    @CreationTimestamp    //데이터 삽입 시 값이 없다면 현재 시간이 입력되도록 한다.
    private LocalDateTime created;

    //상품 조회 DTO 변환
    //엔티티 객체를 상품 조회 DTO로 변환하는 메서드이다. 빌더를 활용하여 필드의 값을 간편하게 초기화하고 객체를 생성한다.
    //상품서비스에서 데이터를 조회할때 사용함

    public ItemRead toRead() {
        return ItemRead.builder()
                .id(id)
                .name(name)
                .imgPath(imgPath)
                .price(price)
                .discountPer(discountPer).build();
    }

}
