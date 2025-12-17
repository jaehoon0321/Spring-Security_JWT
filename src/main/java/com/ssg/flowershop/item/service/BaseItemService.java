package com.ssg.flowershop.item.service;

import com.ssg.flowershop.item.dto.ItemRead;
import com.ssg.flowershop.item.entity.Item;
import com.ssg.flowershop.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseItemService implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public List<ItemRead> findAll() {
        return itemRepository.findAll().stream().map(Item::toRead).toList();
    }

    @Override
    public List<ItemRead> findAll(List<Integer> ids) {
        return itemRepository.findAllById(ids).stream().map(Item::toRead).toList();
    }

    // **페이징 처리된 상품 목록 조회 구현**
    @Override
    public Page<ItemRead> findAll(int page, int size) {
        // PageRequest.of(페이지 번호, 페이지 크기)로 Pageable 객체 생성
        PageRequest pageRequest = PageRequest.of(page, size);
        // ItemRepository의 findAll(Pageable)을 호출하여 결과를 Page<ItemRead>로 변환
        return itemRepository.findAll(pageRequest).map(Item::toRead);
    }
}