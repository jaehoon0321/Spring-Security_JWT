package com.ssg.flowershop.common.util.EncryptionUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionUtils {

    private static final String ALGORITHM = "AES"; // ① 알고리즘 종류 필드
    private static final String SECRET_KEY = "a72ha@61@16213iu"; // ② 암호화 복호화에 사용되는 고정된 비밀 키.외부 노출 안됨

    public static String encrypt(String value) { // ③ 매개변수로 받은 문자열을 암호화한다
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedValue = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encryptedValue);
        } catch (Exception ex) {
            throw new RuntimeException("데이터 암호화 중 오류가 발생했습니다.");
        }
    }

    public static String decrypt(String value) { // ④ 매개변수로 받은 암호화된 문자열을 복호화한다.
        try {
            SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedValue = Base64.getDecoder().decode(value);
            return new String(cipher.doFinal(decryptedValue));
        } catch (Exception ex) {
            throw new RuntimeException("데이터 복호화 중 오류가 발생했습니다.");
        }
    }
}