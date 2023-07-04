package com.vv.admin.service;

import com.vv.admin.pojo.dto.NodeDTO;
import com.vv.util.ResUtils;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description 树形结构接口层
 * @create 2023 - 07 - 04 20:36
 **/
public interface NodeService {

    /***
     * @description 查
     * @param []
     * @return java.util.List<com.vv.admin.pojo.dto.NodeDTO>
     * @author
     * @date 2023/7/4
     **/

    List<NodeDTO> getNodeList();

    /***
     * @description 构建树形结构
     * @param [nodeDTOS]
     * @return java.util.List<com.vv.admin.pojo.dto.NodeDTO>
     * @author
     * @date 2023/7/4
     **/

    ResUtils<List<NodeDTO>> buildTree(List<NodeDTO> nodeDTOS);
}
