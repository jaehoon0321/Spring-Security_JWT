package com.ssg.flowershop.carts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/// CartRead : 장바구니 조회 DTO
@Data
@Builder // 빌더 패턴 활성화
@AllArgsConstructor //
public class CartRead {
    private Integer id;
    private Integer itemId;
}