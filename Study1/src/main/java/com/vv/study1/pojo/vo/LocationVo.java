package com.vv.study1.pojo.vo;

import lombok.*;

import java.io.Serializable;

/**
 * @author kw
 * @program WorkProject
 * @description 地理位置请求参数
 * @create 2023 - 12 - 02 21:43
 **/
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LocationVo implements Serializable {

    private String lng;
    private String lat;
}
