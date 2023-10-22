package com.kk.mapstruct.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @author kw
 * @program WorkProject
 * @description 订单实体
 * @create 2023 - 10 - 22 17:52
 **/
@Data
@ToString
public class OrderEntity {

    private String orderId;
    private String orderName;
    private String orderItem;

}
