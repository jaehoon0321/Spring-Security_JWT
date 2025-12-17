package com.ssg.flowershop.order.controller;

import com.ssg.flowershop.account.helper.AccountHelper;
import com.ssg.flowershop.order.dto.OrderRead;
import com.ssg.flowershop.order.dto.OrderRequest;
import com.ssg.flowershop.order.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // ①
@RequestMapping("/v1") // ②
@RequiredArgsConstructor // ③
public class OrderController {

    private final AccountHelper accountHelper; // ④
    private final OrderService orderService; // ⑤

    @GetMapping("/api/orders")
    public ResponseEntity<?> readAll(HttpServletRequest req) { // ⑥
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(req);

        // 주문 목록
        List<OrderRead> orders = orderService.findAll(memberId);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/api/orders/{id}")
    public ResponseEntity<?> read(HttpServletRequest req, @PathVariable Integer id) { // ⑦
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(req);

        // 주문 조회
        OrderRead order = orderService.find(id, memberId);

        if (order == null) { // 주문 데이터가 없는 경우
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/api/orders")
    public ResponseEntity<?> add(HttpServletRequest req, @RequestBody OrderRequest orderReq) { // ⑧
        // 로그인 회원 아이디
        Integer memberId = accountHelper.getMemberId(req);


        if (memberId == null) {
            return new ResponseEntity<>("로그인이 필요합니다.", HttpStatus.UNAUTHORIZED); // 401 반환
        }

        // 주문 입력
        orderService.order(orderReq, memberId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}