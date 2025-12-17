package com.ssg.flowershop.carts.service;

import com.ssg.flowershop.carts.dto.CartRead;
import com.ssg.flowershop.carts.entity.Cart;

import java.util.List;

public interface CartService {

    // 장바구니 상품 데이터 목록 조회(특정 회원)
    List<CartRead> findAll(Integer memberId); // ①

    // 장바구니 상품 데이터 조회(특정 회원의 특정 상품)
    CartRead find(Integer memberId, Integer itemId); // ②

    // 장바구니 상품 데이터 전체 삭제(특정 회원)
    void removeAll(Integer memberId); // ③

    // 장바구니 상품 데이터 삭제(특정 회원의 특정 상품)
    void remove(Integer memberId, Integer itemId); // ④

    // 장바구니 데이터 저장(특정 회원의 특정 상품)
    void save(Cart cart); // ⑤
}