package com.vv.study1.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 07 - 14 10:06
 **/
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    private String id;
    private String userName;
    private double price;
}
