package com.tang.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description
 * @Author RLY
 * @Date 2018/12/21 17:28
 * @Version 1.0
 **/
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
