package com.ssg.flowershop.block.repository;

import com.ssg.flowershop.block.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlockRepository extends JpaRepository<Block, Integer> { // ① 제네릭 매개변수로 토큰 차단 엔티티 Block 와 이 엔티티의 Id 타입인 Integer 지정

    // 토큰 차단 데이터 조회
    Optional<Block> findByToken(String token); // ② 토큰 차단 데이터 조회 메서드, 매개변수로 토큰을 받아 블러킹할 토큰을 조회한다. 조회된 데이터가 없을 수 있기 때문에 Optional 로 지정함
}