package com.changgou;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptTest {


    /**
     * Bcrypt的加密测试
     *
     * 模拟管理后台管理员添加用户的操作
     *
     *
     * 密文密码：$2a$10$w3NCnlzszakhCDcI5s9REuqbBBPwYktRyxQtWOQWXa183g4zxLqgO
     * 密文密码：$2a$10$QIIGR4Kf38137EdVvlzDGOjfJATHqnI3nNIQOLdbdB69vF6Ldz//y
     * 密文密码：$2a$10$Hk0gQX1Ay01bQ8yT3utcouJVMit1xAucGUSJhhNISJxelek0iqUK6
     * 密文密码：$2a$10$7y76MQf7OQWFRB2KasXUxexEL3N2T.INMc8FvYfqu1H/tSd6Sdz6y
     * 密文密码：$2a$10$qfmSRHKhFszuw006jJFdd.eN/nM8m8gqPWtVvPACeXWuiZJw6vu8i
     * 密文密码：$2a$10$1werlzFvSbQgTp4.tv6rZ.X7ZrQTmuO1ljH2Kvku3LXH4agIZ4if6
     * 密文密码：$2a$10$sgPLXqsI4YTCtirT61a/yOSVVlN/grYb4oIk9N.AJmADUWVCxkImC
     * 密文密码：$2a$10$WAvM5uMxv0uTbfw7BMkBLOHGUbiUmbzThf6S7UzOGm90XJpyaEFuG
     * 密文密码：$2a$10$jeYHemA/ZQXXaS6QwYK14OEVS7qdQroEA43tXLk65iEI2EnZfTKwu
     * 密文密码：$2a$10$CXDt5VWgFyXnddL15ab0Bet8467v9GVrU0aiZWeXx8jdpHo/hcgaO
     */
    @Test
    public void testEncrypt(){

        for(int i=0;i<10; i++){
            //用户的明文密码
            String pwdText = "itheima";

            //基于用户的明文密码结合盐生成密文密码，每次生成的不一样
            String pwdEncrypt = BCrypt.hashpw(pwdText, BCrypt.gensalt());
            System.out.println("密文密码：" + pwdEncrypt);
        }

    }


    /**
     * BCypt的密码校验
     * 模拟用户登录管理后台，后台代码校验密码的逻辑
     */
    @Test
    public void testCheckPwd(){

        //用户登录管理后台输入的明文密码
        String pwdText = "itheima";

        //查询数据库该用户的密文密码
//        String pwdEncrypt = "$2a$10$sgPLXqsI4YTCtirT61a/yOSVVlN/grYb4oIk9N.AJmADUWVCxkImC";
//
//        boolean checkpw = BCrypt.checkpw(pwdText, pwdEncrypt);
//        System.out.println("校验登录是否成功：" + checkpw);



        String[] encryptPwdArr = {"$2a$10$QIIGR4Kf38137EdVvlzDGOjfJATHqnI3nNIQOLdbdB69vF6Ldz//y"
        ,"$2a$10$7y76MQf7OQWFRB2KasXUxexEL3N2T.INMc8FvYfqu1H/tSd6Sdz6y"
        ,"$2a$10$1werlzFvSbQgTp4.tv6rZ.X7ZrQTmuO1ljH2Kvku3LXH4agIZ4if6"
        ,"$2a$10$jeYHemA/ZQXXaS6QwYK14OEVS7qdQroEA43tXLk65iEI2EnZfTKwu"};
        for (String encryptPassword : encryptPwdArr) {
            boolean check = BCrypt.checkpw(pwdText, encryptPassword);
            System.out.println("校验登录是否成功：" + check);
        }

    }
}
