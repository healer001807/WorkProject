package com.vv.admin.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.vv.admin.pojo.dto.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author kw
 * @program WorkProject
 * @description jwt token 工具类
 * @create 2023 - 07 - 01 10:20
 **/
public class JwtUtils {

    public static final String SUBJECT = "work";
    public static final String APP_SECRET = "work";
    public static final long EXPIRE = 1000 * 60 * 30; // 过期时间

    /***
     * @description 生成 JWT token
     * @param [userDTO]
     * @return java.lang.String
     * @author
     * @date 2023/7/1
     **/

    public static String generateToken(UserDTO userDTO) {
        // 非空校验
        if (Optional.ofNullable(userDTO).isEmpty()) {
            return null;
        }
        // 准备参数
        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("userId", String.valueOf(userDTO.getUserId()));
        claimsMap.put("userName", userDTO.getUserName());
        claimsMap.put("userPhone", userDTO.getUserPhone());
        // 生成token
        return Jwts.builder().setSubject(SUBJECT).setClaims(claimsMap)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APP_SECRET).compact();
    }

    /**
     * 解密token
     *
     * @param token
     * @return
     */
    public static String getJwtToken(String token) {
        // 校验token是否为空
        if (StrUtil.isBlank(token)) {
            return null;
        }
        // 验证token
        return JSONUtil.toJsonStr(JSONUtil.parse(Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody()));
    }
}
