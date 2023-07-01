package com.vv.admin.pojo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author kw
 * @program WorkProject
 * @description RSA 密钥对
 * @create 2023 - 07 - 01 18:19
 **/
@Data
@ToString
@Builder(toBuilder = true)
public class RSAKeyDTO {
    private String privateKey;
    private String publicKey;
}
