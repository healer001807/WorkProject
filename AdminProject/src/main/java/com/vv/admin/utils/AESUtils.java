package com.vv.admin.utils;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author kw
 * @program WorkProject
 * @description AES加密工具类
 * @create 2023 - 07 - 01 17:38
 **/
public class AESUtils {
    private static final String AES = "AES";
    private static final String AES_CIPHER = "AES/ECB/PKCS5Padding";

    /***
     * @description 根据自定义key生成密钥
     * @param [keyWord]
     * @return java.lang.String
     * @author
     * @date 2023/7/1
     **/

    public static String getAESKey(String keyWord) {
        try {
            final SecureRandom secureRandom = new SecureRandom(keyWord.getBytes());
            KeyGenerator key = KeyGenerator.getInstance(AES);
            key.init(128, secureRandom);
            return new String(Hex.encodeHex(key.generateKey().getEncoded()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * @description 加密
     * @param [content, keyWord]
     * @return java.lang.String
     * @author
     * @date 2023/7/1
     **/

    public static String encrypt(String content, String keyWord) {
        try {
            // 参数判断
            if (StrUtil.isBlank(content) || StrUtil.isBlank(keyWord)) {
                return null;
            }
            // 加密
            SecretKeySpec keySpec = new SecretKeySpec(Hex.decodeHex(keyWord.toCharArray()), AES);
            Cipher cipher = Cipher.getInstance(AES_CIPHER);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return new String(Hex.encodeHex(cipher.doFinal(content.getBytes(StandardCharsets.UTF_8))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /***
     * @description 解密
     * @param [content, keyWord]
     * @return java.lang.String
     * @author
     * @date 2023/7/1
     **/

    public static String decrypt(String content, String keyWord) {
        try {
            // 参数判断
            if (StrUtil.isBlank(content) || StrUtil.isBlank(keyWord)) {
                return null;
            }
            // 解密
            SecretKeySpec keySpec = new SecretKeySpec(Hex.decodeHex(keyWord.toCharArray()), AES);
            Cipher cipher = Cipher.getInstance(AES_CIPHER);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return new String(cipher.doFinal(Hex.decodeHex(content.toCharArray())));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
