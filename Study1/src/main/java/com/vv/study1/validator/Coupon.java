package com.vv.study1.validator;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 12 - 19 22:14
 **/
@Setter
@Getter
@Accessors(chain = true)
public class Coupon implements Serializable {

    @NotBlank(message = "手机号不能为空")
//    @Pattern(regexp="")
    private String phone;
    @NotBlank(message = "templateId不能为空")
    private String templateId;
}
