package com.vv.study1.shorLink;

import java.security.SecureRandom;

/**
 * @author kw
 * @program WorkProject
 * @description 长链转短链
 * 用长连接转短链接
 * 短链接：域名加随机数 ，先生成一个随机数，再拼接域名
 * 将长链和短链存入数据表
 * @create 2024 - 06 - 30 21:34
 **/
public class RandomCodeGenerator {
    private static final String CHAR_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom random = new SecureRandom();


    public static String generateRandomCode(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rndCharAt = random.nextInt(CHAR_62.length());
            char rndChar = CHAR_62.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // 6位随机数
        String s = generateRandomCode(6);
        System.out.println(s);
    }
}
