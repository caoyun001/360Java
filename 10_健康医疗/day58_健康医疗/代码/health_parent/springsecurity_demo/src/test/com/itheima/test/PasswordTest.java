package com.itheima.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {
    public static void main(String[] args) {
        //$2a$10$W/Ibh6czrLFeASX/7lyjk.NuV2ixNxPChZR3Risi7moYoPLxn9Twq
        //$2a$10$hXcmz6NeQg3sh2xmgeI54e/l6F1dQ03DIf9XMTmlGtkcJTDxKy0YK
        //$2a$10$Bz8ymtNoBs8sMKg.vt1FnObqGuXK5f7WZ8XPmBWUBlo.aNK2x1FEi
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pwd = encoder.encode("1234");
        System.out.println(pwd);

        boolean matches = encoder.matches("1234", "$2a$10$hXcmz6NeQg3sh2xmgeI54e/l6F1dQ03DIf9XMTmlGtkcJTDxKy0YK");
        System.out.println(matches);
    }
}
