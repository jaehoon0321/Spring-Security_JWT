package com.ssg.flowershop.carts.repository;

import com.ssg.flowershop.carts.entity.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart, Integer> {

    /// 장바구니 목록 조회(특정 회원)
    List<Cart> findAllByMemberId(Integer memberID);

    /// 장바구니 정보 조회(특정 회원 및 특정 상품)
    Optional<Cart> findByMemberIdAndItemId(Integer memberId, Integer itemId);

    /// 장바구니 삭제( 특정 회원)
    void deleteByMemberId(Integer memberId);

    /// 장바구니 삭제(특정 회원 및 특정 상품)
    void deleteByMemberIdAndItemId(Integer memberId, Integer itemId);
}
