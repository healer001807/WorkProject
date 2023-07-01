package com.vv.admin.pojo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author kw
 * @program WorkProject
 * @description 用户信息
 * @create 2023 - 07 - 01 10:23
 **/
@Builder(toBuilder = true) // 此注解可以创建对象
@Data
@ToString
public class UserDTO {
    private Long userId;
    private String userName;
    private String userPhone;
    private Integer userAge;
}
