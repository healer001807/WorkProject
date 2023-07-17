package com.vv.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vv.business.pojo.AddressDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description 地址数据层
 * @create 2023 - 07 - 12 20:49
 **/
@Mapper
public interface AddressMapper extends BaseMapper<AddressDTO> {
}
