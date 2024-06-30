package com.vv.study1.validated;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 03 - 20 22:30
 **/
@Setter
@Getter
public class UserVo {
    @NotBlank(message = "用户名不能为空", groups = Update.class)
    private String userName;
}
