package com.kk.mapstruct;

import cn.hutool.core.util.StrUtil;
import com.kk.mapstruct.convert.OrderConvertMapper;
import com.kk.mapstruct.pojo.OrderDTO;
import com.kk.mapstruct.pojo.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapStructApplicationTests {

    @Test
    void contextLoads() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderName("123");
        orderDTO.setOrderId(StrUtil.uuid());
        orderDTO.setOrderitems("订单详情页");

        OrderEntity orderEntity = OrderConvertMapper.INSTANCE.dtoToEntity(orderDTO);
        System.out.println(orderEntity);
    }

}
