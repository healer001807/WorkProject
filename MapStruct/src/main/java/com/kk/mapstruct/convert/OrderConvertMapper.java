package com.kk.mapstruct.convert;

import com.kk.mapstruct.pojo.OrderDTO;
import com.kk.mapstruct.pojo.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author kw
 * @program WorkProject
 * @description 订单转化接口
 * @create 2023 - 10 - 22 17:54
 **/
@Mapper
public interface OrderConvertMapper {

    OrderConvertMapper INSTANCE = Mappers.getMapper(OrderConvertMapper.class);

    /**
     * dto 转entity  两个实体字段名一致
     * 添加 属性字段不同 @Mapping
     *
     * @param orderDTO
     * @return
     */
    @Mapping(source = "orderitems", target = "orderItem")
//    @Mappings(value = @Mapping(target = ""))
    OrderEntity dtoToEntity(OrderDTO orderDTO);
}
