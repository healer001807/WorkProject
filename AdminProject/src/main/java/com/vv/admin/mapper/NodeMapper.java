package com.vv.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vv.admin.pojo.dto.NodeDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kw
 * @program WorkProject
 * @description 树形结构数据层
 * @create 2023 - 07 - 04 20:43
 **/
@Mapper
public interface NodeMapper extends BaseMapper<NodeDTO> {
}
