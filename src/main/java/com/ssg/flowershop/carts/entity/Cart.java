/// DB생성해주고 그다음 entity 생성 작업 두번째 작업
/// DB에 따른
package com.ssg.flowershop.carts.entity;

import com.ssg.flowershop.carts.dto.CartRead;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "carts")/// 이 엔티티 클래스가 매핑될 데이터베이스 테이블 이름을 "carts"로

public class Cart {
    @Id/// 이 필드(id))를 테이블의 기본 키 (Primary  Key)로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)/// // 기본 키 값 생성 전략: DB가 자동으로 값을 증가시켜 생성합니다.
    private Integer id;///장바구니 항목의 고유 식별자


    @Column(nullable = false)
    private Integer memberId;

    @Column(nullable = false)
    private Integer itemId;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created;

    public Cart() {

    }

    /// Lombok @Builder 를 사용하여 생성자를 대체 가능하다.
    public Cart(Integer memberId, Integer itemId) {
        this.memberId = memberId;
        this.itemId = itemId;
    }
    ///엔티티 객체를 장바구니 조회 DTO로 변환하는 메서드
    /// ///빌더를 활용해 필드값을 초기화하고 객체를 생서한다 장바구니 서비스에서 데이터 조회시.
    public CartRead toRead(){
        return CartRead.builder()
                .id(id)
                .itemId(itemId)
                .build();
    }

    //


}
