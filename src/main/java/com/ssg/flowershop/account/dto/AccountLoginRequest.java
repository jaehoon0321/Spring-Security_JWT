package com.ssg.flowershop.account.dto;

import lombok.Getter;

@Getter // ①
public class AccountLoginRequest {

    private String loginId; // ②
    private String loginPw; // ③
}