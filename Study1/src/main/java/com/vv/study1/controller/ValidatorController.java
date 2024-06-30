package com.vv.study1.controller;


import cn.hutool.json.JSONUtil;
import com.vv.study1.validated.Update;
import com.vv.study1.validated.UserVo;
import com.vv.study1.validator.Coupon;
import com.vv.study1.validator.ValidatorUtil;
import com.vv.valid.Validation;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2023 - 12 - 19 22:16
 **/
@Slf4j
@RestController
@RequestMapping("validator")
public class ValidatorController {

    @GetMapping
    public List<Coupon> getList() {
        List<Coupon> list = new LinkedList<>();
        Coupon coupon = new Coupon().setPhone("123456789").setTemplateId("11");
        list.add(coupon);
        Coupon coupon1 = new Coupon().setPhone("").setTemplateId("11");
        list.add(coupon1);
        Coupon coupon2 = new Coupon().setPhone("123456789").setTemplateId("");
        list.add(coupon2);
        list.forEach(coupon3 -> {
            // 返回校验失败数据
            Set<ConstraintViolation<Coupon>> validate = ValidatorUtil.getValidator().validate(coupon3);
            System.out.println(validate);
        });

        return list;
    }

    @PostMapping("createUser")
    public String createUser(@RequestBody @Valid UserVo userVo) {
        return JSONUtil.toJsonStr(userVo);
    }

    @PostMapping("updateUser")
    public String updateUser(@RequestBody @Validated(Update.class) UserVo userVo) {
        return JSONUtil.toJsonStr(userVo);
    }
}
