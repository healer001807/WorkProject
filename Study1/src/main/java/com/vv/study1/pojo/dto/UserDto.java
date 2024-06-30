package com.vv.study1.pojo.dto;

import lombok.*;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 03 - 24 22:19
 **/
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String userName;
}
