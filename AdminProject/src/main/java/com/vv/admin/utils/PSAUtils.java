package com.vv.admin.utils;

import cn.hutool.core.util.StrUtil;
import com.vv.admin.pojo.dto.RSAKeyDTO;

import javax.crypto.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author kw
 * @program WorkProject
 * @description RSA加解密工具类
 * @create 2023 - 07 - 01 18:18
 **/
public class PSAUtils {

    private static final String RSA = "RSA";
    private static final Integer KEY_SIZE = 1024;

    /***
     * @description 生成 密钥对
     * @param []
     * @return com.vv.admin.pojo.dto.RSAKeyDTO
     * @author
     * @date 2023/7/1
     **/

    public static RSAKeyDTO getRSAKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
            keyPairGenerator.initialize(KEY_SIZE);
            // 密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // 私钥
            PrivateKey aPrivate = keyPair.getPrivate();
            // 公钥
            PublicKey aPublic = keyPair.getPublic();

            // 链式编程返回公钥私钥
            return RSAKeyDTO.builder().
                    privateKey(Base64.getEncoder().encodeToString(aPrivate.getEncoded()))
                    .publicKey(Base64.getEncoder().encodeToString(aPublic.getEncoded())).build();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    /***
     * @description 加密
     * @param [publicKey, content]
     * @return java.lang.String
     * @author
     * @date 2023/7/1
     **/

    public static String encrypt(String publicKey, String content) {
        try {
            // 非空校验
            if (StrUtil.isBlank(publicKey) || StrUtil.isBlank(content)) {
                return null;
            }
            // Base64.getDecoder() 解码器 公钥
            PublicKey aPublic = KeyFactory.getInstance(RSA).generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey)));
            // 加密
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.ENCRYPT_MODE, aPublic);
            // Base64.getEncoder() 编码器
            return Base64.getEncoder().encodeToString(cipher.doFinal(content.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * @description 解密
     * @param [privateKey, content]
     * @return java.lang.String
     * @author
     * @date 2023/7/1
     **/

    public static String decrypt(String privateKey, String content) {
        try {
            // 非空校验
            if (StrUtil.isBlank(privateKey) || StrUtil.isBlank(content)) {
                return null;
            }
            // 私钥
            PrivateKey aPrivate = KeyFactory.getInstance(RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
            // RSA解密
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.DECRYPT_MODE, aPrivate);
            return new String(cipher.doFinal(Base64.getDecoder().decode(content)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
