package com.ssg.flowershop.common.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HttpUtils {

    // 세션 입력
    public static void setSession(HttpServletRequest req, String key, Object value) {
        req.getSession().setAttribute(key, value);
    }

    // 세션 값 조회
    public static Object getSessionValue(HttpServletRequest req, String key) {
        return req.getSession().getAttribute(key);
    }

    // 세션 삭제
    public static void removeSession(HttpServletRequest req, String key) {
        req.getSession().removeAttribute(key);
    }

    // 쿠키 입력 : 쿠키를 입력하는 메서드, 매개변수로 HTTP 응답 객체와 쿠키의 이름, 값,
    //             유효시간(초)를 받고, HttpOnly 옵션을 true 로 설정하여 해당 쿠키를 서버에서만 접근 가능하도록 설정
    //             매개변수로 받은 유효시간이 0 이하라면 유효시간을 지정하지 않는데
    //             이렇게 하면 웹 브라우저가 종료될 때  쿠키도 삭제됨
    public static void setCookie(HttpServletResponse res, String name, String value, int expSeconds) { // ③
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        if (expSeconds > 0) {
            cookie.setMaxAge(expSeconds);
        }

        res.addCookie(cookie);
    }

    // ④ 쿠키 값 조회 : 특정 쿠키의 값을 조회하는 메서드. 매개변수로 HTTP 요청 객체와 쿠키의 이름을 받습니다.
    public static String getCookieValue(HttpServletRequest req, String name) {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    // ⑤ 쿠키 삭제 : 특정 쿠키 삭제 메서드. 매개변수로 HTTP 요청객체와 쿠키 이름을 받아 삭제합니다.
    public static void removeCookie(HttpServletResponse res, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        res.addCookie(cookie);
    }
    // 토큰 조회
    public static String getBearerToken(HttpServletRequest req) {
        String authorization = req.getHeader("Authorization");

        if (authorization != null) {
            return authorization.replace("Bearer ", "").trim(); // Bearer 값 조회
        }

        return null;
    }
}