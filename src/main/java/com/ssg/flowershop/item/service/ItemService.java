package com.ssg.flowershop.item.service;

import com.ssg.flowershop.item.dto.ItemRead;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemService {
       //전체 상품 목록 조회 리턴타입으로 상품 조회 DTO 리스트
       List<ItemRead> findAll();

       //특정 상품 목록 조회 (특정 아이디 리스트로 조회) 매개변수로 상품의 아이디 리스트를 받아, 해당 아이디의 상품정보를 조회
       List<ItemRead> findAll(List<Integer> ids);

       // **페이징 처리된 상품 목록 조회 (추가)**
       Page<ItemRead> findAll(int page, int size);
}