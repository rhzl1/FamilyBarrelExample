package com.example.common;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义MD5密码验证器
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {

        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return MD5Util.verify(rawPassword.toString(),encodedPassword);
    }
}
