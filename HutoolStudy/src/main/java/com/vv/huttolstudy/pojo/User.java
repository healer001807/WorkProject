package com.vv.huttolstudy.pojo;

import lombok.*;

/**
 * @author kw
 * @program WorkProject
 * @description 用户对象
 * @create 2023 - 11 - 18 12:25
 **/

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userPhone;
}
